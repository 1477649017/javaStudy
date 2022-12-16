import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        //动态规划问题
        //三种操作中选一个操作步骤数最小的
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];//多出一行一列做辅助
        //初始化
        for(int i = 0;i <= len1;i++){
            dp[i][0] = i;
        }
        for(int j = 0;j <= len2;j++){
            dp[0][j] = j;
        }

        for(int i = 1;i <= len1;i++){
            for(int j = 1;j <= len2;j++){
                dp[i][j] = Math.min(dp[i][j-1] + 1,dp[i-1][j] + 1);
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    //不需要进行交换
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                }else{
                    //需要做出替换
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1] + 1);
                }
            }
        }
        System.out.println(dp[len1][len2]);
    }
}