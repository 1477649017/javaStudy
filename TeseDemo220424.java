
import java.util.Random;
import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-04-24
 * Time: 9:46
 */
import java.io.*;
public class TeseDemo220424 {
    public static void main(String[] args) {
        Console cons = System.console();

        if (cons == null) {
            System.out.println(
                    "No console available");
            return;
        }
        char[] password = cons.readPassword("Passwoed:");
    }

//    计算某一个数的阶乘
    public static int func(int n){
        int ret = 1;
        for(int i = 1;i <= n;i++){
            ret *= i;
        }
        return ret;
    }
//    计算前多少项阶乘之和
    public static int func1(int k){
        int sum = 0;
        for(int i = 1;i <= k;i++){
            sum += func(i);
        }
        return sum;
    }
    public static void main7(String[] args) {
//        写函数来求阶乘之和
        Scanner myscanner = new Scanner(System.in);
        System.out.println("请输入你想要求取前多少项的阶乘的和:");
        int num = myscanner.nextInt();
        int sum = func1(num);
        System.out.println("前 " + num + "项的阶乘和为" + sum);
    }
    public static void main6(String[] args) {
//        生成随机数
        Random random = new Random(2022);
        int rannum = random.nextInt();//生成[0,100) 的随机数 其他范围可以通过在后面加上数来进行范围改变，默认左边都是从0开始
        System.out.println(rannum);

        int rannum1 = (int)(Math.random()*100);
        System.out.println(rannum1);
    }
    public static void main5(String[] args) {
        Scanner myscanner1 = new Scanner(System.in);
        while(myscanner1.hasNextInt()){
            int age = myscanner1.nextInt();
            System.out.println(age);
        }
    }
    public static void main4(String[] args) {
        Scanner myscanner = new Scanner(System.in);

        System.out.println("请输入年龄");
        int num = myscanner.nextInt();
        System.out.println(num);

        System.out.println("请输入名字");
        String str = myscanner.nextLine();//读入一行
        System.out.println(str);

        System.out.println("请输入专业");
        String str1 = myscanner.next();
        System.out.println(str1);//读入一个字符串，遇到空格停止
    }
    public static void main3(String[] args) {
        int i = 1;
        while(i <= 10){
            if(i == 2){
                continue;
            }
            System.out.println("hehe");
            i++;
        }
    }
    public static void main2(String[] args) {
        int a = 3;
        switch(a){
            default:
                System.out.println("输入错误!");
                break;
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
        }
    }
    public static void main1(String[] args) {
        int x = 10;
        int y = 10;
        if (x == 10)
            if (y == 10)
                System.out.println("aaa");
        else
            System.out.println("bbb");

    }

}
