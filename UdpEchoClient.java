import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-10-12
 * Time: 15:16
 */
//客户端
public class UdpEchoClient {
    private DatagramSocket datagramSocket = null;//定义一个网卡对象
    private String serverIp;
    private int serverPort;
    //客户端这边在构造的时候，要指明服务器的ip与端口
    public UdpEchoClient(String serverIp,int serverPort) throws SocketException {
        //客户端自身ip就是其所在主机，端口是系统自己分配的
        datagramSocket = new DatagramSocket();//这里就需要像服务器那边一样指定端口了
        //把服务器ip,以及端口先保存下来，后面有用
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true){
            //开启客户端
            //1.从客户端读取用户输入
            System.out.print("---->");
            String request = scan.next();//接收请求输入
            //2.构造一个UDP请求发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(this.serverIp),this.serverPort);//构造这个请求的时候需要将服务器的ip，端口号填进去，表示你这个请求要发给谁
            datagramSocket.send(requestPacket);//把请求发送给服务器
            //3.从服务器读取响应并进行解析
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024],1024);//构造一个空的DatagramPacket来存放我们响应的结果
            datagramSocket.receive(responsePacket);
            String response = new String(responsePacket.getData(),responsePacket.getLength());//将结果转成字符串
            //4.把结果显示到控制台上
            System.out.println(response);//打印结果
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",9090);//服务器地址现在就是本机ip,端口是服务器绑定的端口
        udpEchoClient.start();//启动客户端
    }
}
