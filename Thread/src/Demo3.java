/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-15
 * Time: 8:00
 */
//3，使用匿名内部类,创建Thread子类
public class Demo3 {
    public static void main(String[] args) {
        Thread t3 = new Thread(){
            @Override
            public void run() {
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t3.start();

        while(true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
