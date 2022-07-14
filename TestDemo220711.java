import jdk.internal.org.objectweb.asm.tree.AbstractInsnNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-11
 * Time: 6:59
 */
public class TestDemo220711 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.creatBinaryTree();//创建好一个二叉树
        System.out.println("======前序遍历======");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();

        System.out.println("======中序遍历======");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();

        System.out.println("======后序遍历======");
        binaryTree.postOrder(binaryTree.root);
        System.out.println();

        System.out.println("======总结点数======");
        int ret1 = binaryTree.size(binaryTree.root);
        System.out.println(ret1);
        binaryTree.size2(binaryTree.root);
        System.out.println(BinaryTree.nodeSize);
        System.out.println();

        System.out.println("=======叶子节点数======");
        int leafCount = binaryTree.getLeafNodeCount(binaryTree.root);
        System.out.println(leafCount);
        binaryTree.getLeafNodeCount1(binaryTree.root);
        System.out.println(BinaryTree.count);
        System.out.println();

        System.out.println("======第K层节点的个数======");
        int klevelNum = binaryTree.getKLevelNodeCount(binaryTree.root,3);
        System.out.println(klevelNum);
        binaryTree.getKLevelNodeCount2(binaryTree.root,3);
        System.out.println(BinaryTree.kNodeCount);

        System.out.println("======二叉树的高度======");
        int height = binaryTree.getHeight(binaryTree.root);
        System.out.println(height);

        System.out.println("======查找值为vaule的节点======");
        System.out.println(binaryTree.find(binaryTree.root,'E').val);

        System.out.println("======层序遍历======");
        binaryTree.levelOrder(binaryTree.root);

        System.out.println("======判断是不是完全二叉树======");
        System.out.println(binaryTree.isCompleteTree(binaryTree.root));
    }
//    public static void main(String[] args) {
//        // 子问题思路  获取树中节点的个数
//        int ret = 0;
//        int size(TreeNode root) {
//            if(root == null){
//                return 0;
//            }
//            ret += size(root.left);
//            ret += size(root.right);
//            return ret + 1;
//        }
//
////遍历思路：只要遍历到了节点 就nodeSize ++
//        public static int nodeSize;
//        void size2(TreeNode root) {
//            if(root == null){
//                return ;
//            }else{
//                nodeSize++;
//            }
//            size2(root.left);
//            size2(root.right);
//        }
//
//        // 获取第K层节点的个数
//        int getKLevelNodeCount(TreeNode root,int k) {
//            if(k == 0){
//                return 0;
//            }
//            if(k == 1){
//                return 1;
//            }
//            return getKLevelNodeCount(root.left,k-1) + getKLevelNodeCount(root.right,k-1);
//        }
//
//
//        // 获取二叉树的高度
//        int getHeight(TreeNode root) {
//            int leftHeight = 0;
//            int rightHeight = 0;
//            if(root == null){
//                return 0;
//            }
//            leftHeight += getHeight(root.left);
//            rightHeight += getHeight(root.right);
//            return Math.max(leftHeight,rightHeight) + 1;
//
//        }
//
//        // 检测值为value的元素是否存在
//        TreeNode find(TreeNode root, int val) {
//            if(root == null){
//                return null;
//            }
//            if(root.val == val){
//                return root;
//            }
//            find(root.left,val);
//            find(root.right,val);
//        }
//
//
//    }
}
