import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-29
 * Time: 14:42
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //实现Callable定义一个任务
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);//用来保存结果

        Thread t = new Thread(futureTask);
        t.start();
        System.out.println(futureTask.get());//阻塞等待，直至计算完成
    }
}
