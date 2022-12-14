/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-12-14
 * Time: 22:22
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class gServer implements Runnable{

    private DatagramSocket DS;
    private int Port = 9998;

    private ArrayList<SocketAddress> clients = new ArrayList<SocketAddress>(); //保存客户端IP地址

    public gServer() throws Exception{
        try {
            DS = new DatagramSocket(Port);
            new Thread(this).start();
        } catch (Exception ex) {
        }
    }
    public void run(){
        try{
            while(true){
                byte[] data = new byte[255];
                DatagramPacket DP = new DatagramPacket(data,data.length);
                DS.receive(DP);

                SocketAddress clientip = DP.getSocketAddress();

                if(!clients.contains(clientip)){
                    clients.add(clientip);
                }
                this.sendAll(DP);
            }
        }catch(Exception ex){
        }
    }
    private void sendAll(DatagramPacket dp) throws Exception {
        for(SocketAddress sa : clients){
            DatagramPacket dd = new DatagramPacket(dp.getData(),dp.getLength(),sa);
            DS.send(dd);
        }
    }
    public static void main(String[] args) throws Exception{
        new gServer();
    }
}
