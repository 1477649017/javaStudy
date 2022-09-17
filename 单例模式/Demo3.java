import javax.crypto.interfaces.PBEKey;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-17
 * Time: 15:52
 */
public class Demo3 {
    public static Object object1 = new Object();
    public static Object object2 = new Object();
    public static Object object3 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try{
                for (int i = 0; i < 10; i++) {
                    synchronized (object3){
                        object3.wait();
                    }
                    System.out.print("A");
                    synchronized (object1){
                        object1.notify();
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{

            try{
                for (int i = 0; i < 10; i++) {
                    synchronized (object1){
                        object1.wait();
                    }
                    System.out.print("B");
                    synchronized (object2){
                        object2.notify();
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }


        });

        Thread t3 = new Thread(()->{
            try{
                for (int i = 0; i < 10; i++) {
                    synchronized (object2){
                        object2.wait();
                    }
                    System.out.print("C");
                    synchronized (object3){
                        System.out.println();
                        object3.notify();
                    }

                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000);

        synchronized (object3){//这里先手动唤醒一下t1线程
            object3.notify();
        }

    }
}
