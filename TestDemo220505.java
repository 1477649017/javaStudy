/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-05
 * Time: 15:37
 */
class Student{
    private String myName;
    private int age;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override //注解：指的是这个方法是重新写的
//    重写了一下Object类的toString方法，
//    让它能够以字符串的形式打印我们对象的属性的值，不用再自己定义show方法
    public String toString() {
        return "Student{" +
                "myName='" + myName + '\'' +
                ", age=" + age +
                '}';
    }
    //    public void setMyName(String myName){
//        this.myName = myName;
//    }//提供一个外部赋值设置的接口
//    public String getMyName(){
//        return myName;
//    }
}
public class TestDemo220505 {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setMyName("xiaowang");
        String str = stu.getMyName();
        //System.out.println(str);
        System.out.println(stu);//直接打印对象的值，如果上面没有重写Object的toSting方法，那么打印的就是 类名 + @ + 地址的哈希值
        //为什么不用对象名.toString呢,可以用，但是没有上面的方法方便，其实println底层也会调用toString，所以没必要用对象名去调用
    }
}
