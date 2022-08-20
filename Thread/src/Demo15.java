import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-20
 * Time: 11:54
 */
class doSUM{
    long sum1 = 0;
    long sum2 = 0;

    public void addEven(int val){
        sum1 += val;
    }

    public void addOdd(int val){
        sum2 += val;
    }

    public long getSum(){
        return sum1 + sum2;
    }
}
public class Demo15 {
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();//记录开始时间
        //定义数组并进行赋值
        int[] array = new int[10000000];
        Random random = new Random();
        for(int i = 0;i < array.length;i++){
            array[i] = random.nextInt(100) + 1;
        }

        doSUM doSUM = new doSUM();
        //实现多线程计算偶数下标元素之和
        Thread t1 = new Thread(()->{
           //计算偶数下标元素之和
            for(int i = 0;i < array.length;i += 2){
                doSUM.addEven(array[i]);
            }
        });

        //实现多线程计算奇数下标元素之和
        Thread t2 = new Thread(()->{
            //计算偶数下标元素之和
            for(int i = 1;i < array.length;i += 2){
                doSUM.addOdd(array[i]);
            }
        });
        t1.start();
        t2.start();

        t1.join();//让main线程阻塞等待
        t2.join();

        long end = System.currentTimeMillis();//记录结束时间
        System.out.println("所有元素之和:" + doSUM.getSum());
        System.out.println("耗时时间:" + (end - begin) + " ms");
    }
}
