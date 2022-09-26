import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-26
 * Time: 19:50
 */
public class Demo17 {
    public static void main(String[] args) throws InterruptedException {
        //构造的时候要指定计数器的值，即可用资源的个数
        Semaphore semaphore = new Semaphore(3);
        //执行P操作
        semaphore.acquire();
        System.out.println("P操作 申请资源");
        semaphore.acquire();
        System.out.println("P操作 申请资源");
        semaphore.acquire();
        System.out.println("P操作 申请资源");

        //到这里就会阻塞 除非semaphore.release()进行V操作释放资源
        semaphore.acquire();
        System.out.println("P操作 申请资源");


    }
}
