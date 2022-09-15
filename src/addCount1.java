

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-09
 * Time: 20:50
 */


class Count{
    public synchronized void increase(){
        synchronized (this){

        }
        increase2();
    }

    public void increase2(){
        increase3();
    }

    public synchronized void increase3(){

    }
}
public class addCount1 {
    public static Count counter = new Count();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for(int i = 0;i < 10000;i++){
                counter.increase();
            }
        });
        t1.start();

        t1.join();

    }
}
