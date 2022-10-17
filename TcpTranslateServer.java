package TranslateServer_TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-10-17
 * Time: 16:43
 */
public class TcpTranslateServer {
    private ServerSocket serverSocket = null;
    private Map<String,String> map = new HashMap<>();
    public TcpTranslateServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        map.put("cat","小猫");
        map.put("duck","鸭子");
    }
    public void start() throws IOException {
        System.out.println("服务器启动!");
        ExecutorService pool = Executors.newCachedThreadPool();
        while (true){
            Socket clientSocket = serverSocket.accept();
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
        }
    }

    public void processConnection(Socket clientSocket){
        System.out.printf("客户端上线 ip: %s  port: %d",clientSocket.getInetAddress().toString(),clientSocket.getPort());
        System.out.println();
        try(InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()){
            while (true){
                Scanner scan = new Scanner(inputStream);
                if(!scan.hasNext()){
                    //判定输入流中，如果没有下一个数据了就退出
                    System.out.printf("客户端下线 ip: %s  port: %d",clientSocket.getInetAddress().toString(),clientSocket.getPort());
                    System.out.println();
                    break;
                }
                String request = scan.next();
                String response = process(request);
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                printWriter.flush();
                System.out.printf("客户端ip: %s 客户端端口: %d ;做出请求: %s ,服务器响应结果: %s \n",clientSocket.getInetAddress().toString()
                        ,clientSocket.getPort()
                        ,request,response);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String process(String request) {
        return map.getOrDefault(request,"在词典中未查询到相关词语");
    }

    public static void main(String[] args) throws IOException {
        TcpTranslateServer tcpTranslateServer = new TcpTranslateServer(8888);
        tcpTranslateServer.start();
    }
}
