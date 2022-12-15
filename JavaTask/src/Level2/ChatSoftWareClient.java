package Level2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

public class ChatSoftWareClient extends JFrame implements ActionListener,Runnable{

    private JTextField field = new JTextField();
    private JTextArea area = new JTextArea("聊天内容：\n");

    private String name = null;

    private int serverPort;
    private String serverIp;
    private DatagramSocket datagramSocket;

    public ChatSoftWareClient(String serverIp, int serverPort) throws SocketException {
        this.setTitle("客户端");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(area, BorderLayout.CENTER);
        this.add(field, BorderLayout.SOUTH);
        field.addActionListener(this);
        this.setSize(400, 290);
        this.setVisible(true);
        name = JOptionPane.showInputDialog("输入昵称");


        try{
            datagramSocket = new DatagramSocket();//创建网卡对象
            this.serverIp = serverIp;
            this.serverPort = serverPort;

            //提示某用户进行登录 将这个信息发给服务器 然后服务器转发给其他的客户端
            String str = name + "已上线!";
            byte[] data = str.getBytes();//字符串转换为字节数组
            //构造DatagramPacket对象 其中要加入服务器的ip 端口信息
            DatagramPacket requestPacket = new DatagramPacket(data,data.length,InetAddress.getByName(this.serverIp),this.serverPort);
            datagramSocket.send(requestPacket);//将数据报发送给服务器

            //另外开启一个线程去接收服务器转发回来的数据
            new Thread(this).start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run(){
        try{
            while (true){
                //接收返回响应
                DatagramPacket responsePacket = new DatagramPacket(new byte[1024],1024);//创建一个空的Packet对象
                datagramSocket.receive(responsePacket);
                //将结果转换成字符串
                String response = new String(responsePacket.getData(),0,responsePacket.getLength());
                //接收返回的消息后添加显示在窗口上
                area.append(response + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e){
        //客户端开始聊天
        //当你在聊天框中输入内容 回车 消息内容会通过这个方法发送给服务器
        try {
            String str = name + "说：" + field.getText();
            byte[] dd = str.getBytes();
            //也是将说的内容发送给服务器 服务器那边会把内容返还回来
            DatagramPacket Data = new DatagramPacket(dd,dd.length,InetAddress.getByName(this.serverIp),this.serverPort);
            datagramSocket.send(Data);
            field.setText("");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        ChatSoftWareClient chatSoftWareClient = new ChatSoftWareClient("127.0.0.1",8888);
    }
}
