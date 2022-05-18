package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-18
 * Time: 9:36
 */
interface AnimalEat{
    public int a = 10;
    public boolean b = false;
    public static final int c = 20;
    default void eat(){

    };
    public static void func(){

    }


}
class Dog implements AnimalEat{
    @Override
    public void eat() {
        System.out.println("狗狗吃狗粮！");
    }
    
}
class Cat implements AnimalEat{
    @Override
    public void eat() {
        System.out.println("猫猫吃猫粮！");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        AnimalEat animal1 = new Dog();
        AnimalEat animal2 = new Cat();
        animal1.eat();
        animal2.eat();

    }
}
