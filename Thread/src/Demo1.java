/**
 * Created with IntelliJ IDEA.
 * Description: 创建线程
 * User: 14776
 * Date: 2022-08-14
 * Time: 10:47
 */


//1,写一个线程继承于Thread
class MyThread1 extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("hello thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class Demo1{
    //运行一个java程序就是开启了一个进程，每个进程至少有一个线程，默认这个线程就是main方法所在的线程（主线程）【jvm创建】
    //main所在的线程与我们自己创建的线程它是一个并发执行的关系
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();//这里并没有创建一个线程
        myThread.start();//调用start方法的时候创建线程，这个线程的工作就是我们run方法里面所写的
        //start另外启动一个新的线程，这个新线程是一个新的执行流，与现有线程的执行流不相关。他们是并发(并发+并行)的关系

        while(true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
