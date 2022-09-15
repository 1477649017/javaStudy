package demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-15
 * Time: 18:24
 */
public class Test3 {
    public static Object object1 = new Object();
    public static Object object2 = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (object1){
                try {
                    object1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());//首先获取到当前线程的引用
            }
        },"a");

        Thread t2 = new Thread(()->{
            synchronized (object2){
                try {
                    object2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());//首先获取到当前线程的引用
                object1.notify();
            }
        },"b");


        Thread t3 = new Thread(()->{
            synchronized (object2){
                System.out.println(Thread.currentThread().getName());//首先获取到当前线程的引用
                object2.notify();
            }
        },"c");

        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
