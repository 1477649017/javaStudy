/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-11
 * Time: 15:28
 */
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
        if(k == 1){
            return 1;
        }
        return getKLevelNodeCount(root.leftChild,k-1) + getKLevelNodeCount(root.rightChild,k-1);//左树第三层加上右树第三层
    }
}
