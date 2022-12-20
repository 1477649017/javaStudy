import java.util.*;
public class Main{
    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//物品种数
        int v = scan.nextInt();//背包体积
        //利用数组保存每个物品的价值和体积
        int[] V = new int[n + 1];//存储物品体积的数组
        int[] W = new int[n + 1];//存储物品价值的数组
        for(int i = 1;i <= n;i++){
            V[i] = scan.nextInt();
            W[i] = scan.nextInt();
        }
        
        int[][] dp = new int[n + 1][v + 1];
        //多出一行一列 当i = 0 j= 0 的时候最大价值应该都是0 所以也不需要进行特别的初始化
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= v;j++){
                dp[i][j] = dp[i-1][j];//不取第i件物品
                if(j >= V[i]){
                    //取第i件物品
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j - V[i]] + W[i]);
                }
            }
        }
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//物品种数
        int v = scan.nextInt();//背包容量
        int[] V = new int[n+1];
        int[] W = new int[n+1];
        for(int i = 1;i <= n;i++){
            V[i] = scan.nextInt();
            W[i] = scan.nextInt();
        }

        int[] dp = new int[v+1];
        for(int i = 1;i <= n;i++){
            for(int j = V[i];j <= v;j++){
                dp[j] = Math.max(dp[j],dp[j - V[i]] + W[i]);
            }
            for(int j = 0;j < dp.length;j++){
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }

    }
}