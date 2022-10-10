/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-10-10
 * Time: 23:01
 */
import java.util.*;


public class Solution {
    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public boolean isPalindrome(String s, int start, int end) {
        //判断是不是回文串
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    //优化，利用动态规划实现回文串的判断
    public  boolean[][] getMat(String s) {
        int len = s.length();
        boolean[][] Mat = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; ++j) {
                if (j == i)
// 单字符为回文字符串
                    Mat[j][i] = true;
                else if (i == j + 1) {
// 相邻字符如果相同，则为回文字符串
                    if (s.charAt(i) == s.charAt(j))
                        Mat[j][i] = true;
                    else
                        Mat[j][i] = false;
                } else {
// F(i,j) = {s[i]==s[j] && F(i+1,j-1)
// j > i+1
                    Mat[j][i] = (s.charAt(i) == s.charAt(j)) && Mat[j + 1][i - 1];
                }
            }
        }
        return Mat;
    }

    public int minCut (String s) {
        // write code here
        int len = s.length();
        boolean[][] Mat = getMat(s);
        if (len == 0) {
            return 0;//本身就是空字符串
        }
        if (Mat[0][len-1]) {
            //如果整个字符串本身就是回文串
            return 0;
        }
        int[] minCutNum = new int[len + 1];//定义数组来记录结果
        //赋初值
        for (int i = 1; i <= len; i++) {
            minCutNum[i] = i - 1; //表示前i个字符分割的最大次数
            //minCutNum[0]不用初始化了，空串已经上面考虑了
        }
        //开始进行计算
        for (int i = 2; i <= len; i++) {
            //i直接从2开始，i = 1一个字符分割次数肯定是0
            //先判断是不是整个就是回文
            if (Mat[0][i-1]) {
                minCutNum[i] = 0;
                continue;//就可以直接开始新的循环了
            }
            for (int j = 1; j < i; j++) {
                //遍历这前i个字符，就直接从i开始了，整个是回文上面考虑了
                //这里的j可以理解为字符下标
                if (Mat[j][i-1]) {
                    minCutNum[i] = Math.min(minCutNum[i], minCutNum[j] + 1);
                }
            }
        }
        return minCutNum[len];
    }
}