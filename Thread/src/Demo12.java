/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-20
 * Time: 9:08
 */
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        //线程还未创建
        System.out.println(t.getState());
        t.start();
        //线程创建开始工作
        System.out.println(t.getState());

        Thread.sleep(1000);
        System.out.println(t.getState());

        t.join();//让main线程等待t执行完

        //t线程执行完成
        System.out.println(t.getState());
    }
}
