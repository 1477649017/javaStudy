/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-20
 * Time: 16:38
 */
public class Demo16 {
    public static void main(String[] args) throws InterruptedException {
        //定义一个线程数组
        Thread[] threads = new Thread[20];

        for(int i = 0;i < 20;i++){
            final int n = i;
            threads[i] = new Thread(()->{
                System.out.println(n);
            });
        }

        //循环进行开启
        for (Thread t:threads) {
            t.start();
        }

        //进入等待
        for (Thread t:threads) {
            t.join();
        }

        //最后主线程输出ok
        System.out.println("ok");
    }
}
