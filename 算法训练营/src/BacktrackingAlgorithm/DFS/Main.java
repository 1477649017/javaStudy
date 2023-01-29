package BacktrackingAlgorithm.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-29
 * Time: 10:10
 */
//数字的全排列问题 输入数字n 对于1~n的数字进行排列 输出所有的排列方法
public class Main {
    private static int N = 10;//定义一个数字常量
    private static int[] path = new int[N];//定义一个路径数组 用来保存每一次的路径情况
    private static boolean[] isUsed = new boolean[N];//定义一个状态数组 标记对应位置上的数字使用使用过

    public static void main(String[] args) {
        List<List<Integer>> path = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入n的值:");
        int n = scanner.nextInt();
        DFS(1,n);
    }

    private static void DFS(int index,int n) {
        //DFS 深度优先搜索
        if(index == n + 1){
            //如果层次数等于n+1了 就说明这条路径是遍历完了 第一个数字为第一层 后面一次类推
            //打印path数组中的当前路径
            for(int i = 0;i < n;i++){
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }

        //没有搜索到底 就继续往下搜索
        for(int i = 1;i <= n;i++){
            //isUsed数组是有多余空间的 所以就直接让数字对应好下标 这样更方便
            if(!isUsed[i]){
                //如果当前这个数字还没有用过 那么就可以加入到路径中
                path[index-1] = i;
                isUsed[i] = true;//更新状态 这个数字已经用过了
                DFS(index+1,n);//往深层遍历
                isUsed[i] = false;//回溯后需要还原 因为这条路径已经走到底了 i这个数字需要重新再去组合下一种情况了
            }
        }
    }
}
