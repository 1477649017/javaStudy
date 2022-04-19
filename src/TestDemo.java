/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-04-19
 * Time: 11:59
 */
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;


public class TestDemo {

    public static void main(String[] args) {
        char num3 ='a';
        System.out.println(num3);

        char num4 ='王';
        System.out.println(num4);

        char num5 = 97;
        System.out.println(num5);

        short a =128;

        byte b =(byte) a;
        System.out.println(a);
        System.out.println(b);
    }
    public static void fun(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE + 1;
        System.out.println(a);
        System.out.println(b);
        int c = 10;
        System.out.println(c);

        //长整型
        long unm = 10L;//定义长整形后面必须要加上一个L，最好用大写
        System.out.println("长整形最大值 ：" + Long.MAX_VALUE );
        System.out.println("长整形最小值 ：" + Long.MIN_VALUE);

        //双精度浮点型
        double  num1 = 1.2;
        System.out.println("浮点型最大值：" + Double.MAX_VALUE);
        System.out.println("浮点型最小值：" + Double.MIN_VALUE);
        System.out.printf("%.2f\n",num1);

        //单精度浮点型
        float num2 = 1.2f;
        System.out.println(num2);
    }
}
