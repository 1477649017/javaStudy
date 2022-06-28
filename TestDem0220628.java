import com.sun.prism.impl.shape.BasicRoundRectRep;

import java.util.ArrayList;
import java.util.LinkedList;

class Student{
    public String name;
    public int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "" + this.name + "," + this.age;
    }
    public boolean equals(Object obj) {
        Student stu = (Student) obj;//这里要强转一下
        if(this.name == stu.name && this.age == stu.age){
            return true;//this是你的调用者，也即是你想删除的对象，stu是遍历这个顺序表中的元素
        }else{
            return false;
        }
    }
}
public class TestDem0220628 {
    public static void main2(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("张三",12));
        arrayList.add(new Student("李四",13));
        arrayList.add(new Student("王五",14));
        System.out.println(arrayList);
        arrayList.remove(new Student("李四",13));//从顺序表里面删除李四这个对象
        System.out.println("删除后：");
        System.out.println(arrayList);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);//尾插其实就是从头开始一个个加入到顺序表中
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1,5);
        System.out.println(arrayList);
//        可以传入一个任何实现了Collection接口的实现类对象
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        System.out.println(linkedList);

        arrayList.addAll(linkedList);//直接把linkedlist中的内容全部追加到arraylist的尾部
        System.out.println(arrayList);
        arrayList.addAll(1,linkedList);//也可以指定位置
        System.out.println(arrayList);

        arrayList.remove(1);
        System.out.println(arrayList);//删除指定位置上的元素

    }
}
