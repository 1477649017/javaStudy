/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-16
 * Time: 10:14
 */

class MyThread extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public MyThread(String name) {
        super(name);
    }
}
public class Demo7 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("这是一个新创建的线程！");
        myThread.setDaemon(true);//使用setDaemon将其设置为后台线程。设置操作要在start之前
        myThread.start();

        System.out.println(myThread.getId());
        System.out.println(myThread.getName());
        System.out.println(myThread.getState());
        System.out.println(myThread.getPriority());
        System.out.println(myThread.isDaemon());
        System.out.println(myThread.isAlive());
        System.out.println(myThread.isInterrupted());


        System.out.println("main线程结束！");

    }
}
