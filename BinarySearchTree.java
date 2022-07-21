
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-21
 * Time: 15:48
 */
public class BinarySearchTree {//二叉搜索树
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode root;

    /*
    * 搜索函数，查看当前搜索树里面是否存在该元素
    * 找到就返回节点，找不到就返回null
    * */

    public TreeNode searchKey(int key){
        if(root == null){
            return null;
        }
        TreeNode cur = root;
        while(cur != null){
            if(cur.val < key){
                cur = cur.right;
            }else if(cur.val > key){
                cur = cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }

    /*
    * 插入函数，在二叉搜索树里面插入一个节点
    * */
    public boolean insertNode(int val){
        TreeNode node = new TreeNode(val);
        if(root == null){
            root = node;
            return true;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null){
            if(cur.val > val){
                pre = cur;
                cur = cur.left;
            }else if(cur.val < val){
                pre = cur;
                cur = cur.right;
            }else{
                return false;
            }
        }
        if(pre.val > val){
            pre.left = node;
        }else{
            pre.right = node;
        }
        return true;
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /*
    * 删除节点函数
    * */
    public void remove(int val){
        if(root == null){
            return;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur  != null){//先找到你要删除的节点
            if(cur.val < val){
                pre = cur;
                cur = cur.right;
            }else if(cur.val > val){
                pre = cur;
                cur = cur.left;
            }else{
                //到这里就说明找到了，开始删除
                removeNode(pre,cur);
                return;//这里要return，不然死循环
            }
        }
    }
    private void removeNode(TreeNode parent,TreeNode cur){
        if(cur.left == null){
            if(cur == root){
                root = root.right;
            }else if(parent.left == cur){
                parent.left = cur.right;
            }else{
                parent.right = cur.right;
            }
        }else if(cur.right == null){
            if(cur == root){
                root = root.left;
            }else if(parent.left == cur){
                parent.left = cur.left;
            }else{
                parent.right = cur.left;
            }
        }else{
            //替换法删除,去左边找最大值
            TreeNode tP = cur;
            TreeNode t = cur.left;
            while(t.right != null){//一直往右边走找最大值
                tP = t;
                t = t.right;
            }
            //出来了就说明找到了
            cur.val = t.val;//先把值替换,然后删除t
            if(tP.left == t){
                tP.left = t.left;
            }else{
                tP.right = t.left;
            }
        }
    }
}
