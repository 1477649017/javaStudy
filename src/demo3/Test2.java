package demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-15
 * Time: 16:52
 */
public class Test2 {
    //定义一个特定的对象，来确保我们的调用wait与notify是同一个对象
    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while(true){
                System.out.println("wait之前");
                synchronized (object){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("wait唤醒之后");
            }
        });
        t1.start();
        Thread.sleep(1000);//确保能先执行t1线程

        Thread t2 = new Thread(()->{
            while(true){
                System.out.println("notify之前");
                synchronized (object){
                    object.notify();
                }
                System.out.println("notify之后");
                try {
                    Thread.sleep(5000);//休眠一下，假设t2这里还有其他逻辑没有执行完
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();

        t1.join();
        t2.join();

    }
}
