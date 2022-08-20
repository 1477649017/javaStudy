/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-20
 * Time: 11:14
 */
public class Demo14 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        t.start();
        System.out.println("2");
    }
}
