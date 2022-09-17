/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-17
 * Time: 22:20
 */
public class Demo4 {
    private static volatile int count = 0;//多次读取count，会有修改，可能会有内存可见性问题
    private static Object locker = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (locker){
                    while(count%3 != 0){//0%3 == 0 写成循环就是因为可能要多次wait
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(Thread.currentThread().getName());
                    count++;
                    locker.notifyAll();//当count的值使得t1不会wait的时候,t2,t3都会wait，所以这里都要唤醒
                }
            }
        },"A");

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (locker){
                    while(count%3 != 1){
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(Thread.currentThread().getName());
                    count++;
                    locker.notifyAll();
                }
            }
        },"B");

        Thread t3 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (locker){
                    while(count%3 != 2){
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName());
                    count++;
                    locker.notifyAll();
                }
            }
        },"C");

        t1.start();
        t2.start();
        t3.start();


    }
}
