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
import java.util.*;
class Solution {
    public static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> ret = new ArrayList<>();
    public void DFS(int index,int n,int k){

        if(path.size() == k){
            ret.add(new ArrayList<>(path));
            return ;
        }

        for(int i = index;i <= n;i++){
            path.add(i);
            DFS(i+1,n,k);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        DFS(1,n,k);
        return ret;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.combine(1,1);
        System.out.println(ret);

        Map<Integer,Boolean> map = new HashMap<>();
        
    }
}