package TcpEchoServer_TCP;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-10-15
 * Time: 14:16
 */
//服务器端
public class TcpEchoServer {
    //建立一个ServerSocket对象
    private ServerSocket listenSocket = null;
    public TcpEchoServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);//绑定一个端口
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");
        while(true){
            //1.调用accept来接收客户端的连接，TCP这里必须要先建立连接才能通信
            Socket clientSocket = listenSocket.accept(); //listenSocket这个是用来监听连接的,相当于是拉客的
            //处理这个连接 具体处理交给clientSocket对象
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("客户端上线 ip: %s  port: %d",clientSocket.getInetAddress().toString(),clientSocket.getPort());
        try(InputStream inputStream = clientSocket.getInputStream();OutputStream outputStream = clientSocket.getOutputStream()){
            //利用try with resources
            while (true){
                //循环读取请求并解析
                //这里需要循环去读请求，因为如果这个客户端存在多次请求，这里的循环就不会结束，是不需要去重新建立连接的
                Scanner scan = new Scanner(inputStream);
                if(!scan.hasNext()){
                    //如果没有下一个请求了就就退出
                    System.out.printf("客户端下线 ip: %s  port: %d",clientSocket.getInetAddress().toString(),clientSocket.getPort());
                    break;
                }
                String request = scan.next();//字节流所以可以直接通过Scanner读取请求
                //计算响应
                String response = process(request);
                //把响应写回客户端
                //outputStream.write(response.getBytes());//文件操作的方法也是可以的，主要是针对字节流的就可以
                //利用PrintWriter进行写操作
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                //刷新一下缓冲区，确保响应会写回
                printWriter.flush();
                //打印日志
                System.out.printf("客户端ip: %s 客户端端口: %d ;做出请求: %s ,服务器响应结果: %s \n",clientSocket.getInetAddress().toString()
                        ,clientSocket.getPort()
                        ,request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //为什么只有它需要关闭
            clientSocket.close();
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9999);
        tcpEchoServer.start();
    }
}
