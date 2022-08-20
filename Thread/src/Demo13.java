/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-20
 * Time: 10:22
 */
class Test{
    public int count = 0;
    public void increase(){
        count++;
    }
}
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread t1 = new Thread(()->{
           for(int i = 0;i < 50000;i++){
               test.increase();
           }
        });

        Thread t2 = new Thread(()->{
            for(int i = 0;i < 50000;i++){
                test.increase();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(test.count);
    }
}
