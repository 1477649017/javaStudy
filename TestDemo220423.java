import java.util.Scanner;
import java.util.Random;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class TestDemo220423{
    public static void main1(String[] args) {
//        1. 根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
        Scanner myscanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入年龄：");
            int age = myscanner.nextInt();
            if(age < 18){
                System.out.println("少年");
            }else if(age >= 19 && age < 28){
                System.out.println("青年");
            }else if(age >= 29 && age < 55){
                System.out.println("中年");
            }else{
                System.out.println("老年");
            }
        }
    }

    public static void main2(String[] args) {
//        2. 判定一个数字是否是素数
        Scanner myscanner1 = new Scanner(System.in);
        while(true){
            System.out.println("请输入一个数:");
            int num = myscanner1.nextInt();
            int flag = 1;
            for(int i = 2;i <= (int)(sqrt(num));i++){
                if(num%i == 0){
                    System.out.println("不是素数!");
                    flag = 0;
                    break;
                }
            }
            if(flag == 1){
                System.out.println("是素数!");
            }
        }
    }

    public static void main3(String[] args) {
//        3. 打印 1 - 100 之间所有的素数
        for(int i = 2; i <= 100;i++){
            int flg = 1;
            for(int j = 2;j <= (int)(sqrt(i));j++){
                if(i%j == 0){
                    flg = 0;
                    break;
                }
            }
            if( flg == 1){
                System.out.print(i + " ");
            }
        }
    }

    public static void main4(String[] args) {
//        4. 输出 1000 - 2000 之间所有的闰年
        for(int i = 1000;i <= 2000;i++){
            if((i % 4 == 0 && i % 100 != 0) || (i %400 == 0)){
                System.out.println(i + " ");
            }
        }
    }

    public static void main5(String[] args) {
//        5. 输出乘法口诀表
        for(int i = 1;i <= 9;i++){
            for(int j = 1;j <= i;j++){
                System.out.print("" + i + "*" + j + "=" + i*j + "\t");
            }
            System.out.println();
        }
    }

    public static void main6(String[] args) {
//        6. 求两个正整数的最大公约数 辗转相除法
        Scanner myscanner2 = new Scanner(System.in);
        int a = myscanner2.nextInt();
        int b = myscanner2.nextInt();
        int m = 0;
        while((m = a%b) != 0){
            a = b;
            b = m;
        }
        System.out.println(b);
    }

    public static void main7(String[] args) {
//7. 求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数
//本身，如： 153＝1^3＋5^3＋3^3 ，则153是一个“水仙花数”。)
        for(int i = 0;i <= 999;i++){
            int tmp = i;
            int sum = 0;
            while(tmp != 0){
                int a = tmp%10;
                sum += (int)(pow(a,3));
                tmp /= 10;
            }
            if(sum == i){
                System.out.println(i + " ");
            }
        }
    }


    public static int checknum(int num){
        int count = 0;
        while(num != 0){
            num = num&(num-1);//运算后要赋值给num
            count++;
        }
        return count;
    }
    public static void main8(String[] args) {
//        8. 写一个函数返回参数二进制中 1 的个数
        Scanner myscanner3 = new Scanner(System.in);
        int num = myscanner3.nextInt();
        int ret = checknum(num);
        System.out.println("二进制位中一的个数:" + ret);
    }

    public static void main9(String[] args) {
//        9. 获取一个数二进制序列中所有的偶数位和奇数位，分别输出二进制序列。
        Scanner myscanner4 = new Scanner(System.in);
        int num = myscanner4.nextInt();
        for(int i = 0;i < 32;i += 2){
            System.out.print(((num >> i)&1) + " ");//奇数位
        }
        System.out.println();
        for(int i = 1;i < 32;i += 2){
            System.out.print(((num >> i)&1) + " ");//偶数位
        }
    }

    public static void main10(String[] args) {
//        10. 完成猜数字游戏
        int num = (int)(Math.random()*100 + 1);//[0,100]的随机数
        Scanner myscanner5 = new Scanner(System.in);
        while(true){
            System.out.println("请输入你猜的数字：");
            int guessnum = myscanner5.nextInt();
            if(guessnum < num){
                System.out.println("猜小了");
            }else if(guessnum > num){
                System.out.println("猜大了");
            }else{
                System.out.println("猜对了");
                break;
            }
        }

    }

    public static void main11(String[] args) {
        //        11,模拟登录
        String password = "123456";
        Scanner myscanner5 = new Scanner(System.in);
        int count = 3;
        while(count > 0){
            System.out.println("请输入你的六位密码：");
            String guessword = myscanner5.next();
            if(password.equals(guessword)){
                System.out.println("登录成功!");
                count--;
                break;
            }else{
                System.out.println("密码错误!请重新输入!");
                count--;
                System.out.println("你还有" + count + "次机会");
            }

        }
    }

    public static void main12(String[] args) {
//        统计1~100中数字9出现的个数
        int count = 0;
        for(int i = 9;i < 100;i++){
            if(i%10 == 9){
                count++;
            }
            if(i/10 == 9){
                count++;
            }
        }
        System.out.println("9的个数" + count);
    }






}