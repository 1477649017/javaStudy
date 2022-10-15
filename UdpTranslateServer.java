package Translate_Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-10-15
 * Time: 11:37
 */
//翻译服务器
public class UdpTranslateServer {
    private DatagramSocket datagramSocket = null;
    private Map<String,String> map = new HashMap<>();//用一个map来保存单词，翻译的对应关系
    public UdpTranslateServer(int port) throws SocketException {
        //绑定端口
        datagramSocket = new DatagramSocket(port);
        //初始化map
        map.put("abandon","放弃");
        map.put("cat","小猫");
        map.put("hello","你好");
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");
        while (true){
            //等待客户端请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024],1024);
            datagramSocket.receive(requestPacket);
            String request = new String(requestPacket.getData(),0,requestPacket.getLength());//将请求转换成字符串
            //根据请求计算响应
            String response = process(request);
            //将响应写回客户端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,requestPacket.getSocketAddress());
            datagramSocket.send(responsePacket);
            //打印日志
            System.out.printf("客户端ip: %s 客户端端口: %d ;做出请求: %s ,服务器响应结果: %s \n",requestPacket.getAddress().toString()
                    ,requestPacket.getPort()
                    ,request,response);
        }
    }

    private String process(String request) {
        return map.getOrDefault(request,"在词典中未查询到该单词!");//返回对应值
    }

    public static void main(String[] args) throws IOException {
        UdpTranslateServer udpTranslateServer = new UdpTranslateServer(8080);
        udpTranslateServer.start();
    }

}
