package demo4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-18
 * Time: 14:05
 */
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public int compareTo(Student o) {
        return this.age - o.age;
    }

}
class AgeCompare implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}
class ScoreCompare implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return (int)(o1.score - o2.score);
    }

}
class NameCompare implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}
public class Test {
    public static void sort(Comparable[] array){
        for(int i = 0;i < array.length - 1;i++){
            for(int j = 0;j < array.length - 1 - i;j++){
                if(array[j].compareTo(array[j+1]) > 0){
                    Comparable tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Student[] stu = new Student[3];
        stu[0] = new Student("xiaowang",18,88.0);
        stu[1] = new Student("zhangsan",19,66.0);
        stu[2] = new Student("lisi",12,98.9);
        System.out.println("按照年龄比较：");
        AgeCompare com1 = new AgeCompare();
        NameCompare com2 = new NameCompare();
//        int ret1 = com1.compare(stu[0],stu[1]);
//        if(ret1 < 0){
//            System.out.println("<");
//        }else if(ret1 == 0){
//            System.out.println("==");
//        }else{
//            System.out.println(">");
//        }
//        System.out.println("按照分数比较：");
//        ScoreCompare com2 = new ScoreCompare();
//        int ret2 = com2.compare(stu[1],stu[2]);
//        if(ret2 < 0){
//            System.out.println("<");
//        }else if(ret2 == 0){
//            System.out.println("==");
//        }else{
//            System.out.println(">");
//        }
        sort(stu);
        System.out.println("排序后：" + Arrays.toString(stu));

    }
//    public static void main1(String[] args) {
//        Student[] stu = new Student[3];
//        stu[0] = new Student("xiaowang",18,88.0);
//        stu[1] = new Student("zhangsan",19,66.0);
//        stu[2] = new Student("lisi",12,88.9);
//        Comparable com = stu[0];
//        int ret = com.compareTo(stu[1]);//单纯两个学生对象之间的比较
//        if(ret < 0){
//            System.out.println("<");
//        }else if(ret == 0){
//            System.out.println("==");
//        }else{
//            System.out.println(">");
//        }
//
////        对这个学生数组按照年龄进行排序
//        Arrays.sort(stu);
//        System.out.println("排序后：" + Arrays.toString(stu));
//    }
}
