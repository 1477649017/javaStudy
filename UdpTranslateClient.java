package Translate_Server;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-10-15
 * Time: 11:38
 */
//翻译客户端
public class UdpTranslateClient {
    private DatagramSocket datagramSocket = null;
    private String serverIp;
    private int serverPort;

    public UdpTranslateClient(String serverIp,int serverPort) throws SocketException {
        datagramSocket = new DatagramSocket();
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true){
            //客户端读取输入
            System.out.print("---->");
            String request = scan.next();//接收请求输入
            //构造请求
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length, InetAddress.getByName(this.serverIp),this.serverPort);
            //发送给服务器
            datagramSocket.send(requestPacket);
            //接收响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024],1024);
            datagramSocket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());//将结果转成字符串
            //输出结果
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpTranslateClient udpTranslateClient = new UdpTranslateClient("127.0.0.1",8080);//服务器地址现在就是本机ip,端口是服务器绑定的端口
        udpTranslateClient.start();//启动客户端
    }
}
