import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-29
 * Time: 14:54
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);//5个人参加比赛
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(()->{
                System.out.println("选手出发！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "选手到达！");
                countDownLatch.countDown();//标记已经有人到了
            });
            t.start();
        }

        countDownLatch.await();//进行阻塞，直至计数器见为0
        System.out.println("选手都已到达，比赛结束！");
    }
}
