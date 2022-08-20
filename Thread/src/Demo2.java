import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-15
 * Time: 8:00
 */
//2,写一个类实现Runnable接口

class MyThread2 implements Runnable{
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

public class Demo2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread t2 = new Thread(myThread2);//传入实现类对象。解耦合，也更适用于多线程,多个线程干同一个活
        t2.start();

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
