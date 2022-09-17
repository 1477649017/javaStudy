/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-17
 * Time: 16:46
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution {
    //以前序遍历解决
    public static String Serialize(TreeNode root) {
        //将二叉树转换为字符串,而且是前序遍历的顺序
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            stringBuilder.append("#,");
            return stringBuilder.toString();
        }
        //首先把根节点加入
        stringBuilder.append(root.val + ",");
        stringBuilder.append(Serialize(root.left));//往左边递归
        stringBuilder.append(Serialize(root.right));//往右边递归
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

    }
}