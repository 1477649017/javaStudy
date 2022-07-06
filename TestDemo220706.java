/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-06
 * Time: 8:44
 */
class SingleList {
    static class Node{//内部类，节点类
        public int val;
        public Node next;//next指向下一个节点

        public Node(int val) {
            this.val = val;
        }
    }
    public Node head;//存储头结点的引用

    public void createList(){
        //创建四个节点，只赋值
        Node node1 = new Node(10);
        Node node2 = new Node(10);
        Node node3 = new Node(10);
        Node node4 = new Node(40);
        //下面把各个节点串起来
        node1.next = node2;//node2就是第二个节点的地址
        node2.next = node3;
        node3.next = node4;
        head = node1;
    }

    public void displayList(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //头插法  时间复杂度O(1)
    public void addFirst(int data){
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
//        当你的链表里面没有元素时，头插其实也满足，因为空的时候head = null
    };
    //尾插法    时间复杂度O(n) 最坏情况下需要找到尾巴
    public void addLast(int data){
        Node node = new Node(data);
        if(this.head == null){
            head = node;
        }else{
            Node cur = this.head;
            //        先将cur移动到尾部
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }

    };
    //任意位置插入,第一个数据节点为0号下标
//    private boolean checkIndex(int index){
//        if(index < 0 || index > size()){
//            throw new IndexLegalException("插入下标不合法！");
//        }
//        return true;
//    }

    private Node findIndexSubOne(int index){
//        找到index-1的节点
        Node cur = this.head;
        while(index - 1 != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }
//    public void addIndex(int index,int data){
////        其他位置，先检验下标合法性
//        try{
//            //checkIndex(index);
//            if(index == 0){
////        那就是头插
//                addFirst(data);
//                return;
//            }
//            if(index == size()){
////            那就是尾插
//                addLast(data);
//                return;
//            }
////            中间插入
//            Node cur = findIndexSubOne(index);//找到index - 1位置的节点
//            Node node = new Node(data);
//            node.next = cur.next;
//            cur.next = node;
//
//        }catch (IndexLegalException e){
//            e.printStackTrace();
//        }
//
//    };
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    };
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null){
            return;
        }
        if(this.head.val == key){
            head = head.next;
            return;//必须要return
        }
        Node cur = searchPrevOfKey(key);
        if(cur == null){
            return;//cur == null 就说明没有找到这么一个key值节点
        }
        cur.next = cur.next.next;
    };

    private Node searchPrevOfKey(int key) {
//        找到key值这个节点的前一个节点
        Node cur = this.head;
        while(cur.next != null){//遍历链表
            if(cur.next.val == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(this.head == null){
            return;//链表为空
        }
        Node node = new Node(-1);//虚拟节点
        node.next = this.head;
        Node prev = node;
        Node cur = this.head;
//        Node prev = this.head;
//        Node cur = this.head.next;
        while(cur != null){
            if(cur.val == key){
                cur = cur.next;
                prev.next = cur;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        this.head = node.next;
        //特殊情况，头节点也为key
//        if(this.head.val == key){
//            head = head.next;
//        }
    };
    //得到单链表的长度
    public int size(){
        int count = 0;
        Node cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    };
    public void clear(){
        this.head = null;//直接把头干掉，那么后续节点就没人引用，就连锁反应，一个个被回收
        //也可以遍历，一个个的置为null，但是相对比较麻烦，不是很有必要
    };

    public void deleteDuplicates(Node head) {
        if(head == null){
            return;
        }

        Node pre = head;
        Node cur = head.next;

        while(cur != null){
            while(pre.val == cur.val){
                cur = cur.next;
            }

            pre.next = cur;
            pre = cur;
            if(cur != null){
                cur = cur.next;
            }
        }

    }
}

public class TestDemo220706 {
    public static void main(String[] args) {
        SingleList sl = new SingleList();
        sl.addLast(1);
        sl.addLast(1);
        sl.addLast(2);
        sl.addLast(3);
        sl.addLast(3);

        sl.deleteDuplicates(sl.head);
        sl.displayList();
    }
}
