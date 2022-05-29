import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-29
 * Time: 18:37
 */
class Student{
    public int age;
    public Student(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}
public class TestDemo220529 {
    public static void main(String[] args) {
        String s1 = new String("abcdefabdddd");
        String ret = s1.replace('a','t');//替换生成一个新的对象
        System.out.println(ret);//tbcdeftbdddd

        String ret1 = s1.replace("ab","qq");
        System.out.println(ret1);//qqcdefqqdddd

        String ret2 = s1.replaceAll("ab","ss");
        System.out.println(ret2);//sscdefssdddd

        String ret3 = s1.replaceFirst("ab","hh");//替换第一次出现的内容
        System.out.println(ret3);//hhcdefabdddd
    }
    public static void main5(String[] args) {
        String s1 = String.format("%d - %d - %d",2022,5,29);
        System.out.println(s1);//输出字符串 “2022 - 5 - 29”
    }
    public static void main4(String[] args) {
//      字符串转数组
        String s1 = new String("hello");
        char[] ch = s1.toCharArray();
        for (char x:ch) {
            System.out.println(x);
        }
//        数组转字符串
        char[] ch1 = {'h','e','l','l','o'};
        String s2 = new String(ch1);
        System.out.println(s2);

    }
    public static void main3(String[] args) {
        String s1 = new String("HELLO");
        System.out.println(s1.toLowerCase());//输出hello
        System.out.println(s1);//输出HELLO

        String s2 = new String("hello");
        System.out.println(s2.toUpperCase());//输出HELLO
        System.out.println(s2);//输出hello
    }
    public static void main2(String[] args) {
        int a = Integer.valueOf("100");
        int b = Integer.valueOf("100",8);//八进制转化
        System.out.println(a);//输出100
        System.out.println(b);//输出64

        int c = Integer.parseInt("123");
        System.out.println(c);//输出123
    }
    public static void main1(String[] args) {
//        将其他数据类型转换成字符串
        String str1 = String.valueOf(123);
        String str2 = String.valueOf(11.2);
        String str3 = String.valueOf(new Student(18));//也可以将一个对象转换成字符串

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
