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
import java.util.*;
class Solution {
    public List<Integer> path = new ArrayList<>();
    public Map<Integer,Boolean> map = new HashMap<>();
    public List<List<Integer>> ret = new ArrayList<>();

    public void DFS(int[] nums,int index){
        if(index == nums.length + 1){
            if(!ret.contains(path)){//判断一下是不是已经有了 避免加入重复值
                ret.add(new ArrayList<>(path));
            }
            return ;
        }

        for(int i = 0;i < nums.length;i++){
            if(!map.get(i)){
                path.add(nums[i]);
                map.put(i,true);//用了该元素就改变状态
                DFS(nums,index + 1);//往下递归
                map.put(i,false);//还原状态
                path.remove(path.size() - 1);//还原path
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        //因为存在重复值 所以保存状态不能再和值对应了 可以通过数组下标来对应状态 因为下标事唯一的
        for(int i = 0;i < nums.length;i++){//初始化元素状态 都是没有用过的
            map.put(i,false);
        }
        DFS(nums,1);
        return ret;
    }
}