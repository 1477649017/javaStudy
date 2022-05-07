/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-07
 * Time: 9:44
 */
class Person{
    private String name;
    private  int age;
    static{
        count = 100;
        System.out.println("这是一个静态代码块！");
    }
    public static int count = 0;

    {
        System.out.println("这是一个实例代码块！");
    }


    public Person(){
        System.out.println("Person<> init");

    }
    public Person(String name,int age){
        System.out.println("Person<String,int> init");
    }

}
class Student{
    private static String name;
    private static int age;
    static{
        name = "xiaowang";
        age = 10;
    }
    public Student(){
        System.out.println("Student<init>");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestDemo220507 {
    public static void main3(String[] args) {
        Student stu = new Student();
        System.out.println(stu);
    }
    public static void main(String[] args) {
        System.out.println(Person.count);
//        Person per1 = new Person();
//        System.out.println("=========================");
//        Person per2 = new Person();


    }
}
