
public class TestDemo {
    public static void main(String[] args) {
//        字符串转数字
        String str = "1234";
        int ret = Integer.parseInt(str);
        System.out.println(ret);
//         数字转字符串
        String str1 = String.valueOf(ret);
        System.out.println(str1);
//        字符串+的拼接
        int a = 10;
        int b = 20;
        System.out.println( a + b + "aaaaa");
        System.out.println("aaaaa" + a + b);
        System.out.println("aaaaa" + (a + b));

    }
}
