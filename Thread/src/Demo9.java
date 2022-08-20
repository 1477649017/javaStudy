/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-17
 * Time: 8:35
 */
public class Demo9 {
    public static boolean singal = false;
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        thread.start();

        try {//main线程休眠3秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();//将进程打断
        System.out.println("进程已被打断！");
    }
}
