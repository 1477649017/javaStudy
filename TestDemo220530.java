/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-30
 * Time: 14:15
 */
public class TestDemo220530 {
    public static void main(String[] args) {
        String s1 = "hello";
        final char[] value = new char[]{'a','b','c'};
        value[0] = 'e';
        //value = new char[]{'d','f'};

    }
    public static void main7(String[] args) {
        char[] ch = {'a','b','c'};
        String s1 = new String(ch);


        String s2 = "abc";
        s1.intern();
        System.out.println(s1 == s2);
    }
    public static void main6(String[] args) {
        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println(s1 == s2);
    }
    public static void main5(String[] args) {
        String s = new String("   ab ababab abab    ");
        System.out.println(s);
        System.out.println(s.trim());
    }
    public static void main4(String[] args) {
        String s = new String("hello world");
        String ret1 = s.substring(3);
        String ret2 = s.substring(3,7);
        System.out.println(ret1);
        System.out.println(ret2);
    }
    public static void main3(String[] args) {
        String s1 = new String("name==zhangsan&&age==20");
        String[] ret = s1.split("&&");
        for (String s:ret) {
            String[] ret1 = s.split("==");
            for (String ss:ret1) {
                System.out.println(ss);
            }
        }
    }
    public static void main2(String[] args) {
        String s1 = new String("192\\168.11.11");
        String[] ret = s1.split("\\\\");
        for (String s:ret) {
            System.out.println(s);
        }
    }
    public static void main1(String[] args) {
        String s1 = new String("I am a student");
        String[] ret = s1.split(" ",2);
        for (String s:ret) {
            System.out.println(s);
        }
    }
}
