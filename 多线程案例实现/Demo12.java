import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-20
 * Time: 16:34
 */


class MyThreadPool{
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();//阻塞队列里面放任务

    public void submit(Runnable runnable) throws InterruptedException {//这是提交任务，把任务放入阻塞队列
        queue.put(runnable);
    }

    public MyThreadPool(int m){//构造方法，创建m个线程来执行任务
        for (int i = 0;i < m;i++){
            Thread t = new Thread(()->{
                //开启线程去执行任务
                while (true){//这个线程开启之后你要让它循环的去取任务，执行任务
                    try {
                        Runnable runnable = queue.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();//这些线程都是前台线程，不会立即结束
        }
    }

}
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(20);
        for (int i = 0;i < 50;i++){//循环去提交任务
            int taskId = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务执行，编号为: " + taskId);
                }
            });
        }
    }
}
