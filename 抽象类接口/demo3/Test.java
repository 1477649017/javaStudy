package demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-18
 * Time: 13:53
 */
interface IRun{
    void run();
}
interface ISwim{
    void swim();
}
interface IFly extends IRun,ISwim{
    void fly();
}
class Duck implements IFly{
    @Override
    public void run() {
        System.out.println("鸭子在跑~");
    }
    @Override
    public void swim() {
        System.out.println("鸭子在游~");
    }
    @Override
    public void fly() {
        System.out.println("鸭子在飞~");
    }
}
public class Test {
    public static void doDuck(IFly fly){
        fly.run();
        fly.fly();
        fly.swim();
    }
    public static void main(String[] args) {
        doDuck(new Duck());
    }
}
