/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-12
 * Time: 10:46
 */
class Student{
//    实例成员变量
    public String name;
    public int age;
//    静态成员变量
    public static String classnum;

    public static void setClassnum(String classnum) {
        Student.classnum = classnum;
    }
    static{
        classnum = "105Java";
    }

    public Student(){

    }
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void func1(Student this){
        System.out.println(this.age);
    }
//    静态的成员方法
    public static void func(Student student){
        System.out.println("这是一个静态的成员方法！");
        System.out.println(student.name);//因为不依赖于对象，所以主函数也没有实例化对象，所以不能访问到依赖于对象的实例化成员
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Outerclass{
    public int date1 = 1;
    private  int date2 = 2;
    public static int date3 = 3;

//    实例内部类
//    1，实例内部类不能定义静态成员变量？？
//    一般不这样弄，非要定义，那这个静态成员变量必须用final修饰
//    2，实力内部类不能定义静态的成员方法？？
//    确实是不行
//    3，当内部类与外部类有同名的成员变量的时候，如果你是用内部类对象去访问的话，肯定是就近选取内部类的同名变量，this此时代表内部类对象引用
//    如果想要访问外部类的，那就只能 外部类类名.this.外部类同名变量
//    也就是说在内部类里面，不仅包含内部类的this，也包含外部类的this，使用的时候仅需用类名区分
//    同理到静态成员上，用外部类类名.成员变量即可
    class Innerclass {
    //        public static int date3;
    public int date1 = 100;
    public int date4 = 4;
    private int date5 = 5;
    public static final int date3 = 200;

        public void innerFunc() {
            System.out.println("实例内部类的普通方法！");
            System.out.println(this.date1);
            System.out.println("外部类：" + Outerclass.this.date1);
            System.out.println(date2);
            System.out.println(date3);
            System.out.println("外部类：" + Outerclass.date3);
            System.out.println(date4);
            System.out.println(date5);
//            在实例内部类里面，可以访问到自身内部类的成员，也可以访问到外部类的成员变量，静态与非静态都可以
//        public static innerStaticfunc(){
//
//        }
        }
   }
}

class Base1{

}
class Base2 extends Base1{

}
class test extends  Base2{

}
public class TestDemo220512 {
    public static void main(String[] args) {
        Base1 a1 = new Base1();
        Base1 a2 = new Base2();
        Base1 a3 = new test();
    }
    public static void main4(String[] args) {

//        怎么定义一个内部类对象
//        外部类类名.内部类类名  对象名 = 外部类对象引用.new 内部类类名
        Outerclass out = new Outerclass();//定义一个外部类对象
//        Outerclass.Innerclass inner= out.new Innerclass();//把实例内部类看成是一个实例成员，利用外部类对象定义内部类对象
        System.out.println(out.date1);
//        把上面的两行定义内容合并一下如下：
        Outerclass.Innerclass inner1= new Outerclass().new Innerclass();
        inner1.innerFunc();
    }
    public static void main3(String[] args) {
        Student stu1 = new Student();
    }
    public static void main2(String[] args) {
        Student stu = new Student();
        Student.func(stu);//静态的方法不依赖于对象，所以可以直接用类名来调用
    }
    public static void main1(String[] args) {
        Student stu1 = new Student("xiaowang",19);
        Student stu2 = new Student("xiaoli",20);
        System.out.println(stu1);
        System.out.println(Student.classnum);
        System.out.println(stu2);
        System.out.println(Student.classnum);
    }
}
