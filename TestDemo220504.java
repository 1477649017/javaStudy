/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-04
 * Time: 15:54
 */
class Student{
//    1,字段，属性
    public String name;
    public int age;
//    2,方法
    public void doClass(){
        System.out.println("做作业！");
    }
    public void doTest(){
        System.out.println("做试卷！");
    }
}

class Person{
    //1，字段，成员属性
//2，方法，行为
//    访问修饰限定符
//    public 公有的  private  私有的  protected 受保护的 如果什么都不写，默认权限，那就是包访问权限
    public String name ;//实例化成员变量(存储在对象的内部)  在类的内部，方法的外部
    public int age ;
    public static int weight;//静态成员变量 只有一份 不属于对象 而是属于类 也就是说存储在方法区 不初始化和实例化成员一样，是对应的0值

    //方法是不属于对象的
    public void func1(){ //实例成员方法
        int a = 10;//局部变量 在栈区
        System.out.println("hehe");
    }
    public static void func2(){//静态成员方法
        System.out.println("haha");
    }

}
class  Test{
    public int a;//实例化成员变量
    public static int count;//静态成员变量
    public static void func(){
        Test te = new Test();
        te.a = 10;//这是不行的
        count = 2;
        System.out.println(count);
    }
}
public class TestDemo220504 {
    public int a = 10;
    public static void func1(){

    }
    public static void main(String[] args) {
        func1();
        TestDemo220504 test1 = new TestDemo220504();
        test1.a  = 100;
        System.out.println(test1.a);
        Test.func();
    }
    public static void main2(String[] args) {
        Test test1 = new Test();//new一个对象test1
        test1.a++;
        Test.count++;
        System.out.println(test1.a);
        System.out.println(Test.count);
        System.out.println("=============");
        Test test2 = new Test();//new一个对象test2
        test2.a++;
        Test.count++;
        System.out.println(test2.a);
        System.out.println(Test.count);
    }
    public static void main1(String[] args) {
        Person per = new Person();//实例化一个对象,可以实例化多个对象
//        .是对象的访问操作符
        System.out.println(per.age);//实例成员变量在你没有初始化时，它的默认值是其类型对应的0值，引用类型是null 整形是0
        System.out.println(per.name);//char 是 '\u0000'  boolean是false  浮点数是0.0
        per.age = 18;
        System.out.println(per.age);
//        如何访问到静态成员变量 直接类名.静态成员变量
        System.out.println(Person.weight);
//        如何使用实例成员方法  直接对象名.方法
        per.func1();
//        如何使用静态成员方法 ，依然是类名.方法名
        Person.func2();
    }
}
