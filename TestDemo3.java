/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-22
 * Time: 16:35
 */
public class TestDemo3 {
    public static void main(String[] args) {
        Integer integer1 = 127;
        Integer integer2 = 127;
        System.out.println(integer1 == integer2);

        Integer integer3 = 128;
        Integer integer4 = 128;
        System.out.println(integer3 == integer4);

    }
    public static void main1(String[] args) {
        int ret = 10;
//        Integer integer1 = 10;//自动装箱
       Integer integer2 = Integer.valueOf(ret);//显式装箱
//        Integer integer3 = new Integer(ret);//显式装箱
        Integer integer1 = 10;//自动装箱

        int val1 = integer1;//自动拆箱
        System.out.println(val1);

        int val2 = integer1.intValue();//显示拆箱,拆为int类型
        System.out.println(val2);

        double val3 = integer1.doubleValue();//显示拆箱，拆为double类型
        System.out.println(val3);
    }
}
