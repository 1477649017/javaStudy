/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-06
 * Time: 22:55
 */
class Test{
    public int count = 0;
//    public synchronized void increase(){
//        count++;
//    }

    public  void increase(){
        synchronized (this){
            count++;
        }
    }
}

public class addCount {
    public static Test test = new Test();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for(int i = 0;i < 10000;i++){
                test.increase();
            }
        });

        Thread t2 = new Thread(()->{
            for(int i = 0;i < 10000;i++){
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
