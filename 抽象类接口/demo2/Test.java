package demo2;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-18
 * Time: 11:33
 */
interface ISwimming{
    void swim();
}
interface IRunning{
    void run();
}
abstract class Animal{
    public  String name;
    public  int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void eat();
}
class Cat extends Animal implements IRunning,ISwimming{
    public Cat(String name,int age){
        super(name,age);
    }
    public void eat(){
        System.out.println(name + "吃猫粮！");
    }
    public void run(){
        System.out.println(name + "正在跑！");
    }

    @Override
    public void swim() {
        System.out.println("猫猫学习游泳~！");
    }
}

class duck extends Animal implements ISwimming{
    public duck(String name,int age){
        super(name,age);
    }
    public void eat(){
        System.out.println(name + "吃鸭粮！");
    }
    public void swim(){
        System.out.println(name + "正在游泳！");
    }
}
public class Test {
    public static void doRun(IRunning irun){
        irun.run();
    }
    public static void doSwim(ISwimming iswim){
        iswim.swim();
    }
    public static void doEat(Animal animal){
        animal.eat();
    }
    public static void main(String[] args) {
        doEat(new Cat("汤姆",5));
        doEat(new duck("唐老鸭",6));
        doSwim(new duck("唐老鸭",6));
        doRun(new Cat("汤姆",5));
        doSwim(new Cat("汤姆",5));
    }
}
