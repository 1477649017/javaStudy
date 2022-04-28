import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-04-28
 * Time: 9:05
 */
public class TestDemo220428 {
    public static int sum(int n){
        if(n == 1){
            return 1;
        }
        return n + sum(n-1);
    }
    public static void main(String[] args) {
        int n = 10;
        int ret = sum(n);
        System.out.println(ret);
    }
    public static int jumpFloor(int n){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else{
            return jumpFloor(n-1) + jumpFloor(n-2);
        }

    }
    public static void main3(String[] args) {
//        跳台阶问题
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入台阶数：");
        int n = scan.nextInt();
        int ret = jumpFloor(n);
        System.out.println("一共有：" + ret + "种跳法！");
    }
    public static void move(char pos1,char pos2){//模拟移动的过程
        System.out.print(pos1 + " ——> " + pos2 + " ");
    }
    public static void hanoi(int n,char pos1,char pos2,char pos3){
        if(n == 1){
            move(pos1,pos3);
            return;
        }
        hanoi(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanoi(n-1,pos2,pos1,pos3);
    }
    public static void main2(String[] args) {
//        递归实现汉诺塔问题
        hanoi(1,'A','B','C');
        System.out.println();
        hanoi(2,'A','B','C');
        System.out.println();
        hanoi(3,'A','B','C');

    }
    public static int fib1(int n){
        int f1 = 1;
        int f2 = 1;
        int f3 = 1;
        for(int i = 3;i <= n;i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    public static int fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
    public static void main1(String[] args) {
//        递归求斐波那契数列的第n项
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入您想要求取的项数：");
        int n = scan.nextInt();
        int ret = fib(n);
        System.out.println("第" + n + "项为：" + ret);
    }
}
