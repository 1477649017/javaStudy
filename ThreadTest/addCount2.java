import sun.reflect.generics.tree.Tree;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-10
 * Time: 10:24
 */
class Count2{
//    public final int count;
//    public Count2(int count) {
//        this.count = count;
//    }

    volatile public  int count = 0;

}
public class addCount2 {
    public static Count2 count2 = new Count2();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while(count2.count == 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1线程执行完毕！");
        });
        t1.start();

        Thread t2 = new Thread(()->{
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入一个值:");
            count2.count = scan.nextInt();
        });
        t2.start();

        t1.join();
        t2.join();

    }
}
