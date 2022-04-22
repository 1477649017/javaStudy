/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-04-22
 * Time: 8:59
 */
public class TestDemo220422 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
//        int ret = a > b ? 1:1.2;错误的!!!!

        int c = 1;
        float d = 1.2f;
        c *= d;
        System.out.println(c);

        float num1 = 14.88f;
        System.out.println(num1%14);

    }
    public static void main4(String[] args) {
        int a = 10;
        System.out.println(a<<1);
        System.out.println(a>>1);

        int b = -1;
        System.out.println(b>>>1);//11111111 >>> 01111111
    }
    public static void main3(String[] args) {
        int a = 1;
        a += 2; // 相当于 a = a + 2
        System.out.println(a); // 输出3

//        易错点注意
        short b = 1;
//        b = b + 1;这么写肯定是报错，因为类型不兼容
        b += 1;//但是这么写就可以，因为这里其实有一个自动的强制类型的转换
        System.out.println(b);


    }
    public static void main2(String[] args) {
        System.out.println(10%3);
        System.out.println(10%-3);
        System.out.println(-10%3);
        System.out.println(-10%-3);
    }


    public static void main1(String[] args) {
//        int/int 结果还是整形
        int a = 5;
        int b = 2;
        System.out.println(a/b);
        int c = 0;
        System.out.println(a/c);
    }
}
