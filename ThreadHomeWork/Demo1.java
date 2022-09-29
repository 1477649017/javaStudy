import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-29
 * Time: 11:52
 */
public class Demo1 {
    public volatile static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        //使用 Semphore 来控制线程安全,实现同时自增一个变量
        //Semphore实现线程安全相当于是资源量是1
        Semaphore semaphore = new Semaphore(1);
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                try {
                    //使用资源之为1的信号量进行包裹就相当于是加锁
                    semaphore.acquire();//进行自增的时候就申请资源
                    count++;
                    semaphore.release();//自增完释放掉
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                try {
                    semaphore.acquire();//进行自增的时候就申请资源
                    count++;
                    semaphore.release();//自增完释放掉
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}
