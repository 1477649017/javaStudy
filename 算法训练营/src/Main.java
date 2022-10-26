import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-10-26
 * Time: 16:54
 */
public class Main {
    private static int greedStrategy(int[] workTime,int[] machineTime,int n,int m) {
        //先把作业时间排序
        Arrays.sort(workTime);
        if(n <= m){
            //如果说作业数小于等于机器数，那就一台机器一个作业，返回最长的作业时间
            return workTime[n-1];
        }else {
            //如果不是，那就按照从大到小先每一个机器分配一个作业
            int i = 0;
            for(;i < m;i++){
                machineTime[i] = workTime[n-1-i];
            }
            //然后从剩下的作业中挑选最大的，准备添加到最小时间的机器上面

            for(int j = n-1-i;j >= 0;j--){
                //遍历剩下的作业
                int min = Integer.MAX_VALUE;
                int flag = 0;
                for(int tmp = 0;tmp < m;tmp++){
                    if(machineTime[tmp] < min){
                        min = machineTime[tmp];
                        flag = tmp;
                    }
                }
                //找到时间当前最小的机器之后，把当前作业交给它
                machineTime[flag] += workTime[j];
            }
        }
        //等所有作业分配完全，找出最后执行玩的机器，也就是时间最长的
        int ret = machineTime[0];
        for (int cur:machineTime) {
            if(cur > ret){
                ret = cur;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        //某工厂有n个独立的作业，由m台相同的机器进行加工处理。作业i所需的加工时间为ti，任何作业在被处理时不能中
        //断，也不能进行拆分处理。现厂长请你给他写一个程序：算出n个作业由m台机器加工处理的最短时间
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入作业数:");
        int n = scan.nextInt();
        System.out.println("请输入机器数:");
        int m = scan.nextInt();

        int[] workTime = new int[n];//保存每个作业需要执行的时间
        int[] machineTime = new int[m];//记录每个机器上执行作业的总时间
        System.out.println("请输入各个作业的执行所需时间:");
        for(int i = 0;i < n;i++){
            workTime[i] = scan.nextInt();
        }
        int ret = greedStrategy(workTime,machineTime,n,m);
        System.out.println(ret);
    }



    public static int solve(int money,int[][] moneyCount){
        //要想纸币数量最少，那么肯定是按面值大的用
        int num = 0;//记录纸币数量
        for(int i = moneyCount.length - 1;i >= 0;i--){
            //计算一下当前money，要低几张当前最大面值的钱，这个值要和这个纸币的数量进行对比，因为可能没有那么多
            int tmp = Math.min(money/moneyCount[i][0],moneyCount[i][1]);
            money -= tmp*moneyCount[i][0];//更新一下剩余money的值
            num += tmp;//累加一下这个纸币的数量
        }
        if(money > 0){
            //如果最后money还是大于0，说明凑不齐这个面值
            return -1;
        }
        return num;
    }
    public static void main1(String[] args) {
        //假设1元、2元、5元、10元、20元、50元、100元的纸币分别有c0, c1, c2, c3, c4, c5, c6张。现在要用这些钱来支付K
        //元，至少要用多少张纸币？
        //先记录一下纸币的面值和数量
        int[][] moneyCount = { { 1, 3 }, { 2, 1 }, { 5, 4 }, { 10, 3 }, { 20, 0 },{50, 1}, { 100, 10 } };
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入的你要支付的钱:");
        int money = scan.nextInt();
        if(solve(money,moneyCount) != -1){
            System.out.println(solve(money,moneyCount));
            return;
        }
        System.out.println("无法凑齐所要支付的钱");
    }
}
