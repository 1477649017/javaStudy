/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-15
 * Time: 8:43
 */

//5，使用lambda表达式，简化匿名内部类实现Runnable接口
public class Demo5 {
    public static void main(String[] args) {
        Thread t5 = new Thread(()->{
            while(true){
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t5.start();

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
