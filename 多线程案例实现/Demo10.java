import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-19
 * Time: 19:46
 */

class MyTimerTask implements Comparable<MyTimerTask>{//这是一个描述人物的类,要实现Comparable接口，因为优先级阻塞队列中的元素会进行比较
    //要执行的任务
    private Runnable runnable;
    //定时时间 是一个时间戳
    private long executeTime;

    public MyTimerTask(Runnable runnable, long executeTime) {
        this.runnable = runnable;
        this.executeTime = System.currentTimeMillis() + executeTime;//获取到系统时间，将其转化成一个时间戳值
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int)(this.executeTime - o.executeTime);//创建的是小根堆，this代表的是你要加入队列的任务对象
    }
}
class MyTimer {//这是一个定时器类
    public BlockingQueue<MyTimerTask> queue = new PriorityBlockingQueue<>();//带有优先级的阻塞队列，管理任务
    public Object locker = new Object();//锁对象
    public MyTimer() {
        //创建一个扫描线程
        Thread t = new Thread(()->{
            while (true){
                //循环去取队首元素进行判断
                try {
                    synchronized (locker){
                        MyTimerTask task = queue.take();
                        //取出之后进行判断
                        long curTime = System.currentTimeMillis();//获取当前时间
                        if(curTime >= task.getExecuteTime()){
                            //如果当前系统时间的时间戳大于你设定的时间的时间戳就说明可以开始执行了
                            task.getRunnable().run();
                        }else{
                            //如果还没到时间，就把任务又塞回去
                            queue.put(task);
                            locker.wait(task.getExecuteTime() - curTime);//没到时间就wait让出cpu资源
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //开启线程
        t.start();
    }

    public void schedule(Runnable runnable, long delay) throws InterruptedException {
        MyTimerTask myTimerTask = new MyTimerTask(runnable,delay);
        queue.put(myTimerTask);
        synchronized (locker){
            locker.notify();//唤醒wait
        }

    }
}
public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                //这是任务本体
                System.out.println("时间到1，开始执行任务!");
            }
        },3000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                //这是任务本体
                System.out.println("时间到2，开始执行任务!");
            }
        },5000);
    }
}
