/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-16
 * Time: 8:53
 */
public class Demo6 {
    public static final long max = 10000000000l;

    public static void main(String[] args) {
        serial();
        concurrent();
    }

    public static void concurrent(){
        //多线程并发执行
        long begin = System.currentTimeMillis();
        Thread t1 = new Thread(()->{
            long a = 0;
            for(long i = 0;i < max;i++){
                a++;
            }
        });

        Thread t2 = new Thread(()->{
            long a = 0;
            for(long i = 0;i < max;i++){
                a++;
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("多线程时间间隔 ：" + (end - begin) + " ms");
    }
    public static void serial(){
        //串行执行
        long a = 0;
        long begin = System.currentTimeMillis();//获取开始时间毫秒数
        for(long i = 0;i < max;i++){
            a++;
        }

        a = 0;
        for(long i = 0;i < max;i++){
            a++;
        }
        long end = System.currentTimeMillis();
        System.out.println("串行时间间隔 ：" + (end - begin) + " ms");
    }
}
