/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-17
 * Time: 10:05
 */
public class Demo10 {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for(int i = 0;i < 8;i++){
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        System.out.println("main线程开始阻塞等待thread执行");
        try {
            thread.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main线程阻塞结束");
    }
}
