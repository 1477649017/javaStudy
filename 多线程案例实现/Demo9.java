import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-19
 * Time: 19:15
 */
public class Demo9 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("时间到1");
            }
        },3000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("时间到2");
            }
        },5000);


    }
}
