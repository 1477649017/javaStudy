/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-16
 * Time: 16:52
 */
class Animal{
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        eat();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

     public void eat(){
        System.out.println(name + "正在吃饭！");
    }
}
class Dog extends Animal{
    private String color;//子类特有属性

    public Dog(String name, int age,String color) {
        super(name, age);
        this.color = color;
    }
    @Override
    public void eat(){//重写父类的方法
        System.out.println(color);
        System.out.println(getName() + "正在吃狗粮！");
    }
    public void swim(){
        System.out.println(getName() + "在游泳！");
    }
}

class Cat extends Animal{
    private String weight;//子类特有属性

    public Cat(String name, int age) {
        super(name, age);
    }
    public void eat(){//重写父类的方法
        System.out.println(getName() + "正在吃猫粮！");
    }
}
public class TestDemo220516 {
    public static void func(Animal animal){
        animal.eat();
    }
    public static void main(String[] args) {
//        func(new Dog("狗狗",5));
//        func(new Cat("猫猫",5));
//        Animal animal = new Cat("猫猫",5);
//        if(animal instanceof Dog){
//            Dog dog = (Dog)(animal);
//            dog.swim();
//        }
        Dog dog = new Dog("狗狗",5,"黄色");

    }
}
