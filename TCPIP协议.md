#  TCP/IP协议

#  封装与分用

**![image-20221012140444230](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221012140444230.png) **

***

#  Socket套接字

TCP/UDP的区别：

![image-20221012143553663](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221012143553663.png) 

***

(1)，什么叫做有连接，无连接？

有连接，无连接表示双方是不是必须建立连接才能进行通信。例如我们打电话，对方必须接通你的电话，双方才能进行通信。但是发微信，发短信这种，不需要对方接通，你这边编辑好按了发送，对方就会收到你的消息。

(2)，什么叫可靠传输与不可靠传输

注意这里的可靠不是指的数据百分百正确不出错，而是代表在一方发送了数据之后，可以知道对方是不是收到了数据。

(3)，面向字节流，面向数据报

TCP和文件操作一样，对于数据的操作也是基于流的，面向字节流，在处理数据的时候基本单位就是字节，可以一次发送多个字节，也可以一个一个字节发送多次。但是面向数据报，数据处理的基本单位就是一个数据报，每次发送就只能是一个数据报的大小。

(4)，全双工

全双工相对的还有一个半双工。全双工代表一个通道，双向通信。半双工代表一个通道，单向通信。网络通信一般都是全双工的。

***

实现一个简单的回显服务器【UDP版本】：

服务器代码实现：

```java
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
```

![image-20221014152545629](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221014152545629.png) 

***

客户端代码实现：

```java
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-10-12
 * Time: 15:16
 */
//客户端
public class UdpEchoClient {
    private DatagramSocket datagramSocket = null;//定义一个网卡对象
    private String serverIp;
    private int serverPort;
    //客户端这边在构造的时候，要指明服务器的ip与端口
    public UdpEchoClient(String serverIp,int serverPort) throws SocketException {
        //客户端自身ip就是其所在主机，端口是系统自己分配的
        datagramSocket = new DatagramSocket();//这里就需要像服务器那边一样指定端口了
        //把服务器ip,以及端口先保存下来，后面有用
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true){
            //开启客户端
            //1.从客户端读取用户输入
            System.out.print("---->");
            String request = scan.next();//接收请求输入
            //2.构造一个UDP请求发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(this.serverIp),this.serverPort);//构造这个请求的时候需要将服务器的ip，端口号填进去，表示你这个请求要发给谁
            datagramSocket.send(requestPacket);//把请求发送给服务器
            //3.从服务器读取响应并进行解析
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024],1024);//构造一个空的DatagramPacket来存放我们响应的结果
            datagramSocket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());//将结果转成字符串
            //4.把结果显示到控制台上
            System.out.println(response);//打印结果
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",9090);//服务器地址现在就是本机ip,端口是服务器绑定的端口
        udpEchoClient.start();//启动客户端
    }
}
```

![image-20221014224024120](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221014224024120.png) 

***

整体流程分析：

![image-20221015101457250](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221015101457250.png) 

***

问题：如果同时多个客户端请求怎么办？

首先，在服务器这边，接收请求并解析，根据请求计算响应，将响应写回客户端。这三个步骤的执行速度其实是非常快的，所以对于这多个请求，服务器虽然是串行去执行的，但是一般都是能够响应过来的。

如果说响应时间过长，这个时候我们就需要开启多线程了，对于服务器上的那个工作进程，来利用多线程并发处理我们的请求，压榨CPU的资源。如果到这里还是不行，那就需要分布式去处理了，多台主机来处理请求。

***

【IDEA开启多个客户端：】

![image-20221015105320125](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221015105320125.png) 

***

【翻译服务器:】

服务器端：

```java
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
```

***

客户端：

```java
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
```

***

运行截图：

![image-20221015120902226](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221015120902226.png) 

***

其实相当于上面的回显服务器，整个代码并且没有大的区别，主要就是根据请求计算响应的这个实现过程，这两个服务器是不一样的，所以其实大家这里为了方便其实可以直接继承之前的回显服务器端，然后重写一下process方法，然后再改一下细节，就可以了。

***

实现一个简单的回显服务器【TCP版本】：

```java
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
```

```java
package TcpEchoServer_TCP;

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

    public void start(){
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

```

【注意：】

![image-20221017111855089](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221017111855089.png) 

***

我们说过，对于Socket对象，亦或是DatagramSocket对象，其实这种网卡的代言人，在操作系统眼里，其实就是文件，那么对于一个进程而言，它的文件描述符表是有限的，那么上面对于循环创建的Socket对象，如果你只是打开而不关闭，最终会把文件描述符表占满，所以需要我们手动的在一个客户端请求执行完之后就把它释放掉。

***

上面实现了TCP版本的回显服务器，但是，一个服务器肯定一般不是给一个客户端使用的，所以我们开了多个客户端，但问题也随之来了，我们的代码还有一些问题。

![image-20221017142523824](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221017142523824.png) 

****

【问题分析：】

![image-20221017144200163](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221017144200163.png) 

***

出现这种问题，与UDP的无连接是有一些关系的。对于UDP而言，它是无连接的，也是就是客户端，服务器不需要建立连接，客户端那边直接发请求就好，然后服务器这边处理请求，就算是有多个客户端发请求，你可以看作服务器是在串行的处理这各个请求，无需专注于是哪个服务器发的请求。

****

这里介绍TCP中的两个连接方式：

1，长连接：不关闭连接，双方不停的交互数据，相当于这个服务器与某一个客户端绑定了，能多次收发数据。

2，短链接：每次计算响应并返回之后，都关闭连接。也就是只能一次收发数据。【利用短连接就需要每次都重新建立连接】

对于TCP而言，你采用长连接的方式就是上面的问题的根本原因【因为我们那里是循环在读取一个客户端的请求】，因为服务器这边是无法再次调用到accept，那么其他客户端就无法连接上服务器，除非当前的客户端下线。

那么使用长连接，有不有什么办法可以解决上面的问题呢？答案就是多线程，每来一个客户端，就单独给它分一个线程去进行处理。

```java
//代码改变就是服务器端的start方法
public void start() throws IOException {
    System.out.println("服务器启动!");
    while(true){
        //1.调用accept来接收客户端的连接，TCP这里必须要先建立连接才能通信
        Socket clientSocket = listenSocket.accept(); //listenSocket这个是用来监听连接的,相当于是拉客的
        //处理这个连接 具体处理交给clientSocket对象
        Thread t = new Thread(()->{//新创建一个线程去处理工作,这样就不影响这边的连接循环逻辑了
            try {
                processConnection(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
```

将每一个工作都分给一个新线程，这样start()方法的自身执行逻辑不会受到processConnection()方法的影响，也就是可以循环的去调用accept()接收连接了。

***

这样利用长连接+多线程的方式，既可以不用重复频繁的建立连接，又可以达到处理多个客户端的要求。

```java
public void start() throws IOException {
    System.out.println("服务器启动!");
    ExecutorService pool = Executors.newCachedThreadPool();
    while(true){
        //1.调用accept来接收客户端的连接，TCP这里必须要先建立连接才能通信
        Socket clientSocket = listenSocket.accept(); //listenSocket这个是用来监听连接的,相当于是拉客的
        //处理这个连接 具体处理交给clientSocket对象
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    processConnection(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
//每个线程操作的clientSocket是不同的，clientSocket是基于IO流操作的，IO流本身就是线程安全的，所以这里没有线程安全的问题
```

当然，鉴于如果请求量大，可能会频繁的创建销毁线程，所以还可以优化，利用线程池会更加的好。

***

【扩展：】

![image-20221019224719425](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221019224719425.png) 
