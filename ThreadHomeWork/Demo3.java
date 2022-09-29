import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-29
 * Time: 14:47
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);//传入要进行计算的值
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                atomicInteger.getAndIncrement();//后置++
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                atomicInteger.getAndIncrement();//后置++
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(atomicInteger.get());
    }
}
