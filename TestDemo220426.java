import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-04-26
 * Time: 11:41
 */

public class TestDemo220426 {
    public static int getFactorial(int n){
        int tmp = 1;
        for(int i = 1;i <= n;i++){
            tmp *= i;
        }
        return tmp;
    }
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        System.out.println("请输入您想要求取哪个数的阶乘：");
        int n = myscanner.nextInt();
        int ret = getFactorial(n);
        System.out.println(n + "的阶乘为：" + ret);
    }
    public static int getSum(int n){
        int ret = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            ret *= i;
            sum += ret;
        }
        return sum;
    }
    public static void main3(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        System.out.println("请输入您想要求取多少项阶乘的和：");
        int n = myscanner.nextInt();
        int sum = getSum(n);
        System.out.println("前" + n + "项阶乘之和：" + sum);
    }
    public static int add(int x,int y){
        return x + y;
    }
    public static double add(double x,double y,double z){
        return x + y + z;
    }
    public static void main2(String[] args) {
        int a = 10;
        int b = 10;
        int ret = add(a,b);
        System.out.println("两个整数之和：" + ret);

        double c = 11.1;
        double d = 12.1;
        double f = 13.1;
        double ret1 = add(c,d,f);
        System.out.println("三个小数之和：" + ret1);
    }
    public static int findMax(int num1,int num2){
        return (num1 > num2)? num1:num2;
    }
    public static double findMax(double num1,double num2){
        return (num1 > num2)? num1:num2;
    }
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入两个整数进行比较：");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int ret = findMax(num1,num2);
        System.out.println("较大值：" + ret);

        System.out.println("请输入两个小数进行比较：");
        double num3 = scan.nextDouble();
        double num4 = scan.nextDouble();
        double ret1 = findMax(num3,num4);
        System.out.println("较大值：" + ret1);

    }
}
