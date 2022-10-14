import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-10-12
 * Time: 15:15
 */
//服务器
public class UdpEchoServer {
    private DatagramSocket datagramSocket = null;//这就是一个网卡对象，利用它来操作网卡接收，发送数据
    public UdpEchoServer(int port) throws SocketException {
        //参数的端口号表示我们的服务器要绑定的端口号，目的就是让我们的客户端明确是访问主机上的哪个进程
        //想要通过端口号访问进程，那么在进程启动的时候就要绑定一个端口号，并且通常情况下，一个进程只能绑定一个端口号
        datagramSocket = new DatagramSocket(port);
    }

    //通过这个方法来启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动！");
        while (true){//循环等待，处理客户端的请求
            //循环里处理请求
            //1.读取请求并解析
            //receive(DatagramPacket p) 这是一个输出型参数，也就是会把从网卡读取到的这个数据报(请求)，保存在我们的DatagramPacket对象里面
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024],1024);
            //定义一个DataGramPacket 并且为其分配空间(数组),length指的是接收指定长度
            datagramSocket.receive(requestPacket);
            //然后将这个requestPacket转换成字符串，方便打印
            String request = new String(requestPacket.getData(),0,requestPacket.getLength());//取出字节数组并转成字符串，String有这种构造方法
            // 2.根据请求计算响应
            //根据请求做出响应，这是一个回显服务器，就直接返回请求就好
            String response = process(request);
            // 3.把响应写回客户端
            //写回客户端，数据传输也是以数据报的形式
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes()
                    ,response.getBytes().length,requestPacket.getSocketAddress());
            datagramSocket.send(responsePacket);//通过网卡将结果数据报发送回客户端

            //4.打印一个日志
            System.out.printf("客户端ip: %s 客户端端口: %d ;做出请求: %s ,服务器响应结果: %s \n",requestPacket.getAddress().toString()
                    ,requestPacket.getPort()
                    ,request,response);
        }
    }

    private String process(String request) {
        return request;//直接返回
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);//new一个服务器对象并绑定一个端口号
        udpEchoServer.start();//开启这个服务器
    }
}
