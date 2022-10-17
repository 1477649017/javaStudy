package huixianServer_TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-10-15
 * Time: 14:16
 */
//客户端
public class TcpEchoClient {
    //客户端使用Socket与服务器建立连接
    private Socket socket = null;
    public TcpEchoClient(String serverIP,int serverPort) throws IOException {
        //建立连接
        socket = new Socket(serverIP,serverPort);
        //这里和UDP就有很大的区别，UDP是只创建一个DatagramSocket对象就好了，服务器IP，port都是在数据报中才去指定
        //但是这里连接的时候就需要指定
    }

    public void start() throws IOException {
        Scanner scan = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){
            while (true){
                //1.从控制台读取数据，构造一个请求
                System.out.println("-->");
                String request = scan.next();
                //2.发送请求给服务器
                //把请求写入网卡
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                printWriter.flush();//记得这里刷新一下缓冲区
                //3.读取响应
                Scanner responseScan = new Scanner(inputStream);
                String response = responseScan.next();
                //4.将结果输出
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",9999);
        tcpEchoClient.start();
    }
}
