/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-06
 * Time: 22:55
 */

class Locker{

}
class Test{
    public  static int count = 0;
    public static Object locker = new Object();
//    public  void increase(){
//        synchronized (Test.class){
//            count++;
//        }
//    }

    public synchronized static void increase(){
        count++;

    }

//    public  void increase2(){
//        synchronized (this){
//            count++;
//        }
//    }

}

public class addCount {
    public static Test test = new Test();
    public static Test test2 = new Test();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for(int i = 0;i < 10000;i++){
                test.increase();
            }
        });

        Thread t2 = new Thread(()->{
            for(int i = 0;i < 10000;i++){
                test2.increase();

            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(test.count);


    }
}
