import java.util.*;

//把数字翻译成字符串
public class Solution {
    /**
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve (String nums) {
        // write code here
        int n = nums.length();
        int[] dp = new int[n+1];
        //dp[i]表示以第i个字符结尾的字符串的译码个数
        dp[0] = 1;//对于dp[2]有用
        if(nums.charAt(0) == '0'){
            //如果就一个字符并且是0，那么就没有译码
            dp[1] = 0;
        }else{
            dp[1] = 1;
        }

        for(int i = 2;i <= n;i++){
            //分为两种情况，就是当前这个字符可以单独译码(不是0)
            //或者可以和前一个组合译码 前一个是1 前一个是2并且自身小于等于'6'
            //情况1 可以单独译码
            if(nums.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            //情况2 可以组合译码
            if(nums.charAt(i-2) == '1' || nums.charAt(i-2) == '2' && nums.charAt(i-1) <= '6'){
                dp[i] += dp[i-2];
            }
            //如果技能单独译码 又可以组合译码 刚好两个if就都满足了
        }
        return dp[n];
    }


    //最长公共子串
    public String getMaxSubStr(String str1,String str2){
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int len1 = ch1.length;
        int len2 = ch2.length;
        //定义一个dp数组 记录信息
        int[][] dp = new int[len1 + 1][len2 + 1];
        int start = 0;//用来保存最长公共子串的起始下标
        int maxSub = 0;
        for(int i = 1;i <= len1;i++){
            for(int j = 1;j <= len2;j++){
                //i j表示的都是第几个字符位置 而不是下标 这点要注意
                if(ch1[i-1] == ch2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > maxSub){
                        maxSub = dp[i][j];//更新最大子串长度值
                        start = i - maxSub;//更新最长子串的其实下标
                    }
                }
            }
        }
        return str1.substring(start,start+maxSub);
    }
    public String LCS (String str1, String str2) {
        // write code here
        //F(i,j) = F(i-1,j-1) + 1
        //表示以str1的第i个字符结尾 以str2的第j个字符结尾的最长公共子串

        String tmp = null;
        if(str1.length() < str2.length()){
            return getMaxSubStr(str1,str2);
        }else{
            return getMaxSubStr(str2,str1);
        }
    }

    //这个题说是动归 其实过程也是一个个进行组合计算 本质上和双层for循环暴力求解差不多的意思
}