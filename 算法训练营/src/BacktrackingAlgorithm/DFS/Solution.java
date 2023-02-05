package BacktrackingAlgorithm.DFS;

//import java.util.ArrayList;
//import java.util.List;
//
//class Solution {
//    public static List<Integer> path = new ArrayList<>();
//    public static List<List<Integer>> ret = new ArrayList<>();
//
//    public void DFS(int[] nums,int index){
//        ret.add(new ArrayList<>(path));
//        //index表示每一次的起始位置
//        if(index >= nums.length){
//            //终止条件
//            return ;
//        }
//
//        for(int i = index;i < nums.length;i++){
//            path.add(nums[i]);
//            DFS(nums,i+1);
//            path.remove(path.size() - 1);
//        }
//
//    }
//    public List<List<Integer>> subsets(int[] nums) {
//        DFS(nums,0);
//        return ret;
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[]{1,2,3};
//        solution.subsets(nums);
//        System.out.println(ret);
//    }
//}


////////////////////////////////////////////////////////////////////////
//import java.util.*;
//class Solution {
//    public static List<Integer> path = new ArrayList<>();
//    public static List<List<Integer>> ret = new ArrayList<>();
//    public void DFS(int index,int n,int k){
//
//        if(path.size() == k){
//            ret.add(new ArrayList<>(path));
//            return ;
//        }
//
//        for(int i = index;i <= n;i++){
//            path.add(i);
//            DFS(i+1,n,k);
//            path.remove(path.size() - 1);
//        }
//    }
//    public List<List<Integer>> combine(int n, int k) {
//        DFS(1,n,k);
//        return ret;
//    }
//
//    public static void main(String[] args) {
//        Solution sl = new Solution();
//        sl.combine(1,1);
//        System.out.println(ret);
//
//    }
//}


////////////////////////////////////////////////////////////////////////
//import java.util.*;
//class Solution {
//    public boolean[] col = new boolean[20];//保存列的状态
//    public boolean[] dg = new boolean[20];//保存正对角线的状态
//    public boolean[] undg = new boolean[20];//保存反对角线的状态
//    public boolean[] row = new boolean[20];
//    public List<List<String>> ret = new ArrayList<>();
//
//    public void DFS(int x,int y,int count,int n,char[][] chessboard){
//        //按每一个格子进行枚举
//        if(y == n){
//            //说明已经到了最右边格子了 需要跳到下一行搜索
//            y = 0;
//            x++;
//        }
//
//        if(x == n){
//            if(count == n){
//                //说明已经全部搜索完毕 并且放入了n个皇后 也就是一种可行的解法
//                //存储结果
//                List<String> ret_col = new ArrayList<>();
//                for(char[] tmp : chessboard){
//                    String s = new String(tmp);//这是一行的结果
//                    ret_col.add(s);
//                }
//                ret.add(ret_col);//将整个棋盘的结果存储到ret中
//
//            }
//            return ;
//        }
//
//        //否则就是继续往下一个格子搜索 每个格子有两种情况 放或不放
//        //不放
//        DFS(x,y + 1,count,n,chessboard);
//        //放
//        if(!row[x] && !col[y] && !dg[x + y] && !undg[x - y + n]){
//            chessboard[x][y] = 'Q';//放下皇后
//            row[x] = col[y] = dg[x + y] = undg[x - y + n] = true;//更改状态
//            DFS(x,y+1,count + 1,n,chessboard);
//            row[x] = col[y] = dg[x + y] = undg[x - y + n] = false;//还原状态 回溯
//            chessboard[x][y] = '.';
//        }
//    }
//
//    public List<List<String>> solveNQueens(int n) {
//        char[][] chessboard = new char[n][n];//定义一个n*n的棋盘
//        for(char[] tmp:chessboard){//初始化棋盘
//            Arrays.fill(tmp,'.');
//        }
//        DFS(0,0,0,n,chessboard);
//        return ret;
//    }
//
//    public static void main(String[] args) {
//        Solution sl = new Solution();
//        List<List<String>> ret = sl.solveNQueens(4);
//        System.out.println(ret);
//    }
//}


///////////////////////////////////////////////////////////////
//import java.util.*;
//class Solution {
//    public List<Integer> path = new ArrayList<>();
//    public Map<Integer,Boolean> map = new HashMap<>();
//    public List<List<Integer>> ret = new ArrayList<>();
//
//    public void DFS(int[] nums,int index){
//        if(index == nums.length + 1){
//            if(!ret.contains(path)){//判断一下是不是已经有了 避免加入重复值
//                ret.add(new ArrayList<>(path));
//            }
//            return ;
//        }
//
//        for(int i = 0;i < nums.length;i++){
//            if(!map.get(i)){
//                path.add(nums[i]);
//                map.put(i,true);//用了该元素就改变状态
//                DFS(nums,index + 1);//往下递归
//                map.put(i,false);//还原状态
//                path.remove(path.size() - 1);//还原path
//            }
//        }
//
//
//    }
//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        //因为存在重复值 所以保存状态不能再和值对应了 可以通过数组下标来对应状态 因为下标事唯一的
//        for(int i = 0;i < nums.length;i++){//初始化元素状态 都是没有用过的
//            map.put(i,false);
//        }
//        DFS(nums,1);
//        return ret;
//    }
//}


//////////////////////////////////////////////////
//组总和
//import java.util.*;
//class Solution {
//    public List<Integer> path = new ArrayList<>();
//    public List<List<Integer>> ret = new ArrayList<>();
//
//    public void DFS(int[] candidates,int target,int sum,int startIndex){
//        if(sum > target){
//            return ;//说明递归到目前sum已经大于了target就可以直接返回了
//        }
//        if(sum == target){
//            //找到了一个结果
//            ret.add(new ArrayList<>(path));
//            return ;
//        }
//
//        for(int i = startIndex;i < candidates.length;i++){
//            path.add(candidates[i]);
//            sum += candidates[i];
//            DFS(candidates,target,sum,i);
//            sum -= candidates[i];
//            path.remove(path.size() - 1);
//        }
//    }
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        //组合总和其实对于组合问题而言 换汤不换药
//        DFS(candidates,target,0,0);
//        return ret;
//    }
//}


//组合总和2
//import java.util.*;
//class Solution {
//    public List<Integer> path = new ArrayList<>();
//    public List<List<Integer>> ret = new ArrayList<>();
//    public Map<Integer,Boolean> map = new HashMap<>();
//
//    public void DFS(int[] candidates, int target,int sum,int startIndex){
//        if(sum > target){
//            return ;
//        }
//        if(sum == target){
//            ret.add(new ArrayList<>(path));
//            return ;
//        }
//
//        for(int i = startIndex;i < candidates.length;i++){
//            if(i > 0 && candidates[i] == candidates[i-1] && map.get(candidates[i-1]) == false){
//                continue;//去重
//            }
//
//            path.add(candidates[i]);
//            sum += candidates[i];
//            map.put(candidates[i],true);
//            DFS(candidates,target,sum,i+1);
//            sum -= candidates[i];
//            map.put(candidates[i],false);
//            path.remove(path.size() - 1);
//
//        }
//    }
//
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        //相对于组合总和1 这个题唯一的不同点就是每个数字只能使用一次了
//        Arrays.sort(candidates);//一定要先排序才可以
//        for(int i = 0;i < candidates.length;i++){
//            map.put(candidates[i],false);
//        }
//
//        DFS(candidates,target,0,0);
//        return ret;
//    }
//}

//组合总和3
//import java.util.*;
//class Solution {
//    public List<Integer> path = new ArrayList<>();
//    public List<List<Integer>> ret = new ArrayList<>();
//
//    public void DFS(int k,int n,int sum,int startIndex){
//        if(sum > n){
//            return ;
//        }
//        if(path.size() == k){
//            if(sum == n){
//                ret.add(new ArrayList<>(path));
//            }
//            return ;
//        }
//
//        for(int i = startIndex;i <= 9 - (k - path.size()) + 1;i++){
//            path.add(i);
//            sum += i;
//            DFS(k,n,sum,i+1);
//            sum -= i;
//            path.remove(path.size() - 1);
//        }
//    }
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        //限定了数字1~9之间的数字进行组合 每个数字最多使用一次 这里不存在重复数字
//        DFS(k,n,0,1);
//        return ret;
//    }
//
//}


////////////////////////////////
//分割回文串
//import java.util.*;
//class Solution {
//    public List<String> path = new ArrayList<>();
//    public List<List<String>> ret = new ArrayList<>();
//
//    public boolean isPalindrome(String s,int left,int right){
//        while(left < right){
//            if(s.charAt(left) != s.charAt(right)){
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
//    public void DFS(String s,int startIndex){
//        if(startIndex == s.length()){
//            ret.add(new ArrayList<>(path));
//            return ;
//        }
//
//        for(int i = startIndex;i < s.length();i++){
//            //每次分割出的子串就是[startIndex,i]
//            //先判断分出来的是不是回文串 目前都不是就没必要往下递归了
//            if(isPalindrome(s,startIndex,i)){
//                //目前是一个回文字符串 先加入path中
//                path.add(s.substring(startIndex,i+1));
//            }else{
//                continue;//不是回文串就跳过当前这种分割法
//            }
//
//            DFS(s,i+1);
//            path.remove(path.size() - 1);
//        }
//    }
//
//    public List<List<String>> partition(String s) {
//        DFS(s,0);
//        return ret;
//    }
//}


/////////////////////////////////////
//复原IP地址
//import java.util.*;
//class Solution {
//    public List<String> path = new ArrayList<>();
//    public List<String> ret = new ArrayList<>();
//
//    public boolean isLegal(String s,int start,int end){
//        //每次分割出来的段中 数值只能是介于0~255之间 不能以0开头
//        //不能含有其他非数字字符
//        if (start > end) {
//            return false;
//        }
//        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
//            return false;
//        }
//        int num = 0;
//        for (int i = start; i <= end; i++) {
//            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
//                return false;
//            }
//            num = num * 10 + (s.charAt(i) - '0');
//            if (num > 255) { // 如果⼤于255了不合法
//                return false;
//            }
//        }
//        return true;
//    }
//    public void DFS(String s,int startIndex,int splitSum){
//        //注意一共只能分割三次
//        if(splitSum == 3){
//            if(isLegal(s,startIndex,s.length() - 1)){
//                //对最后的一段进行合法判断
//                StringBuilder stringBuilder = new StringBuilder();
//                for(int i = 0;i < path.size();i++){
//                     stringBuilder.append(path.get(i));
//                     stringBuilder.append(".");
//                }
//                stringBuilder.append(s.substring(startIndex,s.length()));
//                ret.add(stringBuilder.toString());
//            }
//            return ;
//        }
//
//        for(int i = startIndex;i < s.length();i++){
//            //分割后先判断是不是合法的 不是合法的就没有必要往下去递归
//            //[startIndex,i] 分割出的区间
//            if(isLegal(s,startIndex,i)){
//                //是合法的
//                path.add(s.substring(startIndex,i+1));//分割出来加入到path中
//                splitSum++;//分割次数++
//                DFS(s,i+1,splitSum);
//                splitSum--;
//                path.remove(path.size() - 1);
//            }else{
//                break;
//            }
//        }
//    }
//    public List<String> restoreIpAddresses(String s) {
//        //这个题和分割回文串大同小异 都是分割问题
//        DFS(s,0,0);
//        return ret;
//    }
//}

///////////////////////////////////
//子集II
//import java.util.*;
//class Solution {
//    List<Integer> path = new ArrayList<>();
//    List<List<Integer>> ret = new ArrayList<>();
//    Map<Integer,Boolean> map = new HashMap<>();
//
//    public void DFS(int[] nums,int startIndex){
//        ret.add(new ArrayList<>(path));
//        if(startIndex >= nums.length){
//            return ;
//        }
//
//        for(int i = startIndex;i < nums.length;i++){
//            if(i > 0 && nums[i] == nums[i-1] && map.get(i-1) == false){
//                continue;
//            }
//            path.add(nums[i]);
//            map.put(i,true);
//            DFS(nums,i + 1);//每次往下递归是在当前i的基础上往下递归 不是startIndex 注意！！！！！
//            map.put(i,false);
//            path.remove(path.size() - 1);
//        }
//    }
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        //去重问题和组合总和II是一样的
//        Arrays.sort(nums);
//        for(int i = 0;i < nums.length;i++){
//            map.put(i,false);
//        }
//        DFS(nums,0);
//        return ret;
//    }
//}

/////////////////////////////////////////////
//递增子序列
//import java.util.*;
//
//class Solution {
//    public List<Integer> path = new ArrayList<>();
//    public List<List<Integer>> ret = new ArrayList<>();
//
//    public void DFS(int[] nums,int startIndex){
//        if(path.size() > 1){
//            ret.add(new ArrayList<>(path));
//        }
//        if(startIndex == nums.length){
//            return ;
//        }
//        Set<Integer> set = new HashSet<>();//用来保存本层已经使用过了哪些元素
//        //其实定义全局的Map也是可以的 但是键的问题比较难搞
//
//        for(int i = startIndex;i < nums.length;i++){
//            if((path.size() != 0 && nums[i] < path.get(path.size() - 1)) || set.contains(nums[i]) == true){
//                //在path不是空的条件下 现在遍历到的新元素比path末尾元素小 则不满足递增条件 或者该元素在本层之前用过了
//                continue;
//            }
//            path.add(nums[i]);
//            set.add(nums[i]);
//            DFS(nums,i+1);
//            path.remove(path.size() - 1);
//        }
//
//    }
//
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        //其实只选取nums中的递增元素的话 也就是求取一个递增数组的递增子序列 也就是子集II的问题
//        DFS(nums,0);
//        return ret;
//    }
//}


/////////////////////////////////////////////////
// 全排列II
import java.util.*;
class Solution {
    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> ret = new ArrayList<>();
    public Map<Integer,Boolean> map = new HashMap<>();

    public void DFS(int[] nums){
        if(path.size() == nums.length){
            ret.add(new ArrayList<>(path));
            return ;
        }
        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1] && map.get(i-1) == false){
                continue; //同一层遇到重复的元素 进行剪枝
            }
            if(!map.get(i)){
                path.add(nums[i]);
                map.put(i,true);
                DFS(nums);
                map.put(i,false);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//排序让相同的元素挨在一起
        for(int i = 0;i < nums.length;i++){
            map.put(i,false);
        }
        DFS(nums);
        return ret;
    }
}



