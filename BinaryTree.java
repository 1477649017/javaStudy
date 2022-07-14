import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class TreeNode{//二叉树的一个节点类
        public char val;
        public TreeNode leftChild;//左孩子引用
        public TreeNode rightChild;//右孩子引用

        public TreeNode(char val){
            this.val = val;
        }
    }
    public TreeNode root;//根节点引用

    //枚举法创建二叉树
    public void creatBinaryTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.leftChild = B;
        A.rightChild = C;
        B.leftChild = D;
        B.rightChild = E;
        E.rightChild = H;
        C.leftChild = F;
        C.rightChild = G;
        this.root = A;
    }

    // 前序遍历
    void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");//先打印根节点
        preOrder(root.leftChild);//然后去递归遍历左子树
        preOrder(root.rightChild);//然后递归遍历右子树
    }

    // 中序遍历
    void inOrder(TreeNode root){
        if(root == null){
            return ;
        }
        inOrder(root.leftChild);//进来先递归遍历左子树
        System.out.print(root.val + " ");//打印根节点
        inOrder(root.rightChild);//递归遍历右子树
    }

    // 后序遍历
    void postOrder(TreeNode root){
        if(root == null){
            return ;
        }
        postOrder(root.leftChild);//进来先递归遍历左子树
        postOrder(root.rightChild);//递归遍历右子树
        System.out.print(root.val + " ");//打印根节点
    }

    // 获取树中节点的个数
    //1,子问题思路
    int size(TreeNode root){
//        if(root == null){
//            return 0;
//        }
//        return size(root.leftChild) + size(root.rightChild) + 1;//子问题，求整个书结点数，那就是自身1 + 左树 + 右树
            int ret = 0;
            if(root == null){
                return 0;
            }
            ret += size(root.leftChild);
            ret += size(root.rightChild);
            return ret + 1;

    }

    //遍历思路
    public static int nodeSize;
    void size2(TreeNode root){
        if(root == null){
            return ;
        }
        nodeSize++;
        size2(root.leftChild);
        size2(root.rightChild);
    }

    // 获取叶子节点的个数
    //1,子问题思路
    int getLeafNodeCount(TreeNode root){
        int leafCount = 0;
        if(root == null){
            return 0;
        } //是叶子节点返回值就是1，不是叶子节点返回值就是0
        if(root.leftChild == null && root.rightChild == null){
            return 1;//说明现在是一个叶子节点
        }
        leafCount += getLeafNodeCount(root.leftChild);
        leafCount += getLeafNodeCount(root.rightChild);
        //把每次递归的返回值加起来就是叶子结点的个数
        return leafCount;
    }

    //2,遍历思路 遇到叶子节点就++
    public static int count = 0;
    void getLeafNodeCount1(TreeNode root){
        if(root == null){
            return ;
        }
        if(root.leftChild == null && root.rightChild == null){
            count++;
        }
        getLeafNodeCount1(root.leftChild);
        getLeafNodeCount1(root.rightChild);
    }

    // 获取第K层节点的个数
    int getKLevelNodeCount(TreeNode root,int k){
        //子问题的思路
        if(root == null){
            return 0;
        }
        if(k == 1){//k减到1的时候就是所谓的第k层
            return 1;
        }
        return getKLevelNodeCount(root.leftChild,k-1) + getKLevelNodeCount(root.rightChild,k-1);//左树第三层加上右树第三层
        //注意传参不能是--k，因为你传k-1就只是传了值，--k把k自身的值改变了，你遍历完左树返回上一层k的值直接变了，影响右树的遍历
    }

    // 获取第K层节点的个数
    public static int kNodeCount = 0;
    void getKLevelNodeCount2(TreeNode root,int k){
        //遍历的思路
        if(root == null){
            return;
        }
        if(k == 1){//k减到1的时候就是所谓的第k层
            kNodeCount += 1;//遇到就++
        }
        getKLevelNodeCount2(root.leftChild,k-1);
        getKLevelNodeCount2(root.rightChild,k-1);
        //注意传参不能是--k，因为你传k-1就只是传了值，--k把k自身的值改变了，你遍历完左树返回上一层k的值直接变了，影响右树的遍历
    }

    // 获取二叉树的高度
    int getHeight(TreeNode root){
    //子问题思路 左树高度 右树高度的最大值+1
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.leftChild),getHeight(root.rightChild)) + 1;
    }


    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, char val){
        //子问题思路
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;//根就是的情况，也就是找到了作为返回值
        }
        TreeNode leftTree = find(root.leftChild,val);//先找左树
        if(leftTree != null){
            return leftTree;//这个地方是不能return root的，因为每返回出一层,root都会变
        }
        TreeNode rightTree = find(root.rightChild,val);
        if(rightTree != null){
            return rightTree;
        }
        return null;
    }

    //层序遍历
    void levelOrder(TreeNode root){
        if(root == null){
            return;//二叉树为空，那就直接return掉
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//首先就把root入队
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();//队头元素出队
            System.out.print(cur.val + " ");//打印元素的值
            if(cur.leftChild != null){
                queue.offer(cur.leftChild);//如果cur的左孩子不为空就入队
            }
            if(cur.rightChild != null){
                queue.offer(cur.rightChild);//如果cur的右孩子不为空就入队
            }

        }
    }

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//首先就把root入队
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();//队头元素出
            if(cur != null){
                queue.offer(cur.leftChild);//左孩子入队,null也是能够入队的
                queue.offer(cur.rightChild);//右孩子入队
            }else{
                break;//如果cur是空了就跳出循环
            }
        }
        //跳出循环后继续判断，可能是也可能不是完全二叉树
        while(!queue.isEmpty()){
            if(queue.poll() != null){//如果继续出队元素的过程中遇到了不是null的元素，那就不是完全二叉树
                return false;
            }
        }
        return true;
    }


}
