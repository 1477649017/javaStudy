/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-04-21
 * Time: 10:07
 */
public class TestDemo220421 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(!(a < b));
//        System.out.println(!a);错误的，没有说什么a非0，然后前面加上！就表示结果为假
    }
    /**
     * Java前置自增以及后置自增中的坑
     * @param args
     */
    public static void main2(String[] args) {
        int i = 1;
        i = ++i;
        System.out.println(i);//输出2

        int j = 1;
        j = j++;
        System.out.println(j);
    }
    public static void main1(String[] args) {
        byte a = 127;
        byte b = (byte)(a + 1);
        System.out.println(b);

//        short c = 32767 + 1;这里是不行的，因为后面相加后是一个整形，前后类型不兼容，并且加起来的结果值也是超范围的
        short c = 32767;
        short d = (short)(c + 1);
        System.out.println(d);

        int e = 2_147_483_647 + 1;//为什么这里就可以这样写，因为前后都是整形，也就是说
//      对于某一个类型的变量，不存在整型提升以及前后等号两边类型相同的情况下，直接赋值一个超过范围的字面常量是不行的，但我们可以进行拆分后赋值
        System.out.println(e);

        long f = Long.MAX_VALUE + 1;
        System.out.println(f);
    }
}
