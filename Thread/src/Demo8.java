/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-17
 * Time: 8:17
 */

class MyThread3 extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Demo8 {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        //myThread3.run();
        myThread3.start();

        System.out.println("main线程结束！");
    }
}
