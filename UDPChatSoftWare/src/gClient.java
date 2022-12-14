/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-12-14
 * Time: 22:22
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class gClient extends JFrame implements Runnable,ActionListener {

    private JTextField field = new JTextField();
    private JTextArea area = new JTextArea("聊天内容：\n");

    private String name = null;

    private int Port = 9998;
    private DatagramSocket DS;

    public gClient(){

        this.setTitle("客户端");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(area, BorderLayout.CENTER);
        this.add(field, BorderLayout.SOUTH);
        field.addActionListener(this);
        this.setSize(400, 290);

        this.setVisible(true);

        name = JOptionPane.showInputDialog("输入昵称");

        try {
            DS = new DatagramSocket();
            InetAddress address = InetAddress.getByName("Localhost");
            DS.connect(address,Port);

            String str = name + "登录!";
            byte[] data = str.getBytes();
            DatagramPacket DP = new DatagramPacket(data,data.length);

            DS.send(DP);
            new Thread(this).start();

        } catch (Exception e) {
        }
    }
    public void run(){
        try{
            while(true){
                byte[] data = new byte[255];
                DatagramPacket DP = new DatagramPacket(data,data.length);
                DS.receive(DP);
                String str = new String(DP.getData(),0,DP.getLength());
                area.append(str + '\n');
            }
        }catch(Exception ex){
        }
    }
    public void actionPerformed(ActionEvent e){
        try{
            String str = name + "说：" + field.getText();
            byte[] dd = str.getBytes();
            DatagramPacket Data = new DatagramPacket(dd,dd.length);
            DS.send(Data);
            field.setText("");
        }catch(Exception ex){
        }
    }
    public static void main(String[] args){
        new gClient();
    }
}
