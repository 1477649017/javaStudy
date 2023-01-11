package IoC;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-11
 * Time: 21:20
 */
public class App {
    public static void main(String[] args) {
        Tire tire = new Tire(15);
        Bottom bottom = new Bottom(tire);
        FrameWork frameWork = new FrameWork(bottom);
        Car car = new Car(frameWork);
        car.init();
    }
}
