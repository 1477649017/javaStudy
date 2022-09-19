import java.lang.reflect.Array;
import java.util.Arrays;

//首先自己实现一个普通队列 + 线程安全 + 阻塞实现
class MyBlockingQueue1 {
    private int[] elem = new int[100];

    volatile int head = 0;//头指针
    volatile int tail = 0;//尾指针
    volatile int size = 0;//记录有效元素个数
    //入队函数
    public void put(int val)  {
        synchronized (this){
            //首先判断是否满
            while (size == elem.length){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //没有满就把元素放进去
            elem[tail] = val;
            tail++;
            if(tail >= elem.length){
                tail = 0;//因为是循环数组，所以转到头去
            }
            size++;
            this.notify();
        }
    }

    //出队函数
    public int take()  {
        int ret = 0;
        synchronized (this){
            while (size == 0){//队列为空就不能出元素
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ret = elem[head];
            head++;
            if(head >= elem.length){
                head = 0;
            }
            size--;
            this.notify();

        }
        return ret;
    }
}
public class Demo8 {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue1 queue1 = new MyBlockingQueue1();

        Thread customer = new Thread(()->{
            while (true){
                int ret = queue1.take();
                System.out.println("消费元素 " + ret);
            }
        });

        Thread producer = new Thread(()->{
            while (true){
                queue1.put(1);
                System.out.println("生产元素 " + 1);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        customer.start();

        producer.join();
        customer.join();
    }
}
