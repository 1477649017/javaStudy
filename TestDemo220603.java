import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-03
 * Time: 10:36
 */
public class TestDemo220603 {
    public static void main4(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("world");
    }
    public static void main3(String[] args) {
        StringBuilder stringBuilder1 = new StringBuilder("hello");//"hello"还是在常量池
        stringBuilder1.append("world");
        System.out.println(stringBuilder1);//追加 相当于String类的 +=

        System.out.println(stringBuilder1.length());//求字符串的长度

        stringBuilder1.reverse();//将字符串进行逆置
        String s1 = stringBuilder1.toString();//用String类型的变量接收
        System.out.println(s1);
    }
    public static void main2(String[] args) {
        String s = "hello";
//        想要实现在后面追加一个world
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello");
        stringBuilder.append("world");
        s = stringBuilder.toString();
        System.out.println(s);
    }
    public static void main1(String[] args) {
        String s = "hello";
        s += "world";
        System.out.println(s);
    }
}
