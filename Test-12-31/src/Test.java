/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-12-31
 * Time: 18:52
 */
public class Test {
    public int getFirstUnFormedNum(int[] arr) {
        //其实这个题本质上还是一个0 1背包的问题
        //[min,max]背包的大小在这个范围内进行变化 相当于背包最大是max
        //数组arr中的元素就是物品 然后每个元素本身的值既是它的体积 也是价值
        //我们要求的就是在每个背包大小下能够放入的价值最大 最后需要验证的就是每个状态下的最大值是不是等于背包的大小
        //如果不是等于背包的大小 那么就是相当于这个和不是在子集里面
        if(arr.length == 0 || arr == null){
            return 0;
        }
        if(arr.length == 1){
            //如果数组只有一个元素 那么最小不可组成和就是arr[0] + 1 也就是max+1
            return arr[0] + 1;
        }
        //找出数组元素中的最小值 以及所有的元素的和
        int min = arr[0];
        int max = arr[0];
        for(int i = 1;i < arr.length;i++){
            max += arr[i];
            if(arr[i] < min){
                min = arr[i];
            }
        }
        int[] dp = new int[max + 1];//其实只有min 下标到 max下标是有效的
        //背包的大小[min,max]中变化
        for(int i = 0;i < arr.length;i++){
            //遍历物品
            for(int j = max;j >= arr[i];j--){
                //这里采取的一维的解法 所以是倒序的遍历
                dp[j] = Math.max(dp[j],dp[j - arr[i]] + arr[i]);
            }
        }

        //开始检验
        for(int i = min;i <= max;i++){
            if(dp[i] != i){
                return i;//说明出现了一个不可组成和
            }
        }
        return max + 1;
    }
}
