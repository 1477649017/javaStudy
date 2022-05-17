package demo2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-17
 * Time: 16:46
 */
interface Ianimal{
    public abstract void eat();
}
class Dog implements Ianimal{
    @Override
    public void eat() {
        System.out.println("狗吃狗粮！");
    }
}
class Cat implements Ianimal{
    @Override
    public void eat() {
        System.out.println("猫吃猫粮！");
    }
}
public class Test {
    public static void eatFood(Ianimal animal){
        animal.eat();
    }
    public static void main(String[] args) {
        eatFood(new Dog());
        eatFood(new Cat());
    }
}
