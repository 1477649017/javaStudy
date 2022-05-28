/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-28
 * Time: 11:37
 */
public class TestDemo220528 {
    public static void main(String[] args) {
        String str1 = new String("abcdcedcf");
        int ret = str1.lastIndexOf("dc",5);
        System.out.println(ret);
    }
    public static void main5(String[] args) {
        String str1 = new String("hello");
        for (int i = 0; i < str1.length(); i++) {
            System.out.println(str1.charAt(i));//将字符串的字符一个个输出
        }
        int ret = str1.indexOf("ll",4);
        System.out.println(ret);

        int ret1 = str1.lastIndexOf('e');
        System.out.println(ret1);
    }
    public static void main4(String[] args) {
        String str1 = new String("HELLO");
        String str2 = new String("hello");
        System.out.println(str1.equalsIgnoreCase(str2));//忽略大小写进行比较  true
        System.out.println(str1.compareToIgnoreCase(str2));//忽略大小写进行比较  false
    }
    public static void main3(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");
        String str3 = new String("abcd");
        String str4 = new String("abcdef");

        System.out.println(str1.compareTo(str2));//输出0
        System.out.println(str1.compareTo(str3));//输出7
        System.out.println(str3.compareTo(str4));//输出-2
    }
    public static void main2(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a == b);

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1 == str2);//str1，str2就是两个对象，地址的值肯定不相同

        System.out.println(str1.equals(str2));//true，字符串的内容是一样的

    }
    public static void main1(String[] args) {
//        1，使用常量串进行构造，其实和数组的静态赋值一样，这里也是省略的写法
        String str1 = "hello";
        System.out.println(str1);
//        2,使用关键字new一个对象
        String str2 = new String("hahaha");
        System.out.println(str2);
//        3,利用字符数组进行构造
        char[] arr = {'a','b','c','d'};
        String str3 = new String(arr);
        System.out.println(str3);

    }
}
