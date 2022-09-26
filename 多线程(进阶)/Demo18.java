import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-26
 * Time: 21:11
 */
public class Demo18 {
    public static void main(String[] args) throws InterruptedException {
        //有十个选手参赛
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for(int i = 0;i < 10;i++){
            //创建10个线程来执行任务
            Thread t = new Thread(()->{
                System.out.println("选手出发！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("选手到达！" + Thread.currentThread().getName());
                countDownLatch.countDown();//每到达一个选手计数器减1
            });
            t.start();
        }

        //await()会进行阻塞等待，直至计数器减为0，才会解除阻塞
        countDownLatch.await();
        System.out.println("全部选手到达，比赛结束！");
    }
}
