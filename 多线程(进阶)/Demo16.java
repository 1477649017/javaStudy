import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-26
 * Time: 18:43
 */
public class Demo16 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);//传入一个你要操作的值
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                count.getAndIncrement();//这个相当于count++
                //怎么区分看increment以及decrement的位置就好
//                count.incrementAndGet();//这个相当于++count
//                count.getAndDecrement();//这个相当于count--
//                count.decrementAndGet();//这个相当于--count
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                count.getAndIncrement();//这个相当于count++

            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.get());//输出2000
    }
}
