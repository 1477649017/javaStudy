package reflectDemo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-24
 * Time: 15:09
 */

 class Student {
    //私有属性name
    private String name = "xiaowang";
    //公有属性age
    public int age = 18;

    //不带参数的构造方法
    public Student() {
        System.out.println("reflectDemo.Student()");
    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("reflectDemo.Student(String,name)");
    }

    private void eat() {
        System.out.println("i am eat");
    }

    public void sleep() {
        System.out.println("i am pig");
    }

    private void function(String str) {
        System.out.println(str);
    }

    @
            Override
    public String toString() {
        return "reflectDemo.Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}




