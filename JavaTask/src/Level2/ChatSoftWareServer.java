package Level2; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-12-14
 * Time: 22:22
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class ChatSoftWareServer implements Runnable{

    private DatagramSocket datagramSocket = null;//创建出网卡对象

    private ArrayList<SocketAddress> clients = new ArrayList<SocketAddress>(); //创建出一个list来保存客户端IP地址

    public ChatSoftWareServer(int port) throws Exception{//构造方法
        datagramSocket = new DatagramSocket(port);
        //另外开启一个线程去接收发送的消息
        new Thread(this).start();
    }

    //重写以下run方法 也就是线程需要执行的任务
    public void run(){
        try{
            while (true){
                DatagramPacket requestPacket = new DatagramPacket(new byte[1024],1024);//定义一个DatagramPacket对象 用来接收请求;
                datagramSocket.receive(requestPacket);//接收请求并填充到requestPacket对象中
                //SocketAddress包含着该请求客户端的ip 以及端口信息 通过requestAddress获取
                SocketAddress clientip = requestPacket.getSocketAddress();

                if(!clients.contains(clientip)){//判断list中是不是有了这个客户端的信息
                    clients.add(clientip);
                }

                this.sendAll(requestPacket);//将数据报转发到其他所有客户端
                //因为是聊天程序，所以这里不需要服务器做出任何响应 只是将信息转发给所有客户端就行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void sendAll(DatagramPacket datagramPacket) throws Exception {
        //循环转发
        for(SocketAddress socketAddress : clients){
            //根据传过来的requestPacket对象 获取到其中的字节数组 其长度
            //根据list中的客户端信息 将数据转发出去
            DatagramPacket dd = new DatagramPacket(datagramPacket.getData(),datagramPacket.getLength(),socketAddress);
            datagramSocket.send(dd);
        }
    }
    public static void main(String[] args) throws Exception{
        ChatSoftWareServer chatSoftWareServer = new ChatSoftWareServer(8888);
    }
}
