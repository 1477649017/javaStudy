/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-27
 * Time: 17:09
 */
public class SingleList {
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
        Node node2 = new Node(20);
        Node node3 = new Node(30);
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
    public boolean addIndex(int index,int data){
        return false;
    };
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
    public void remove(int key){};
    //删除所有值为key的节点
    public void removeAllKey(int key){};
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
    public void clear(){};
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        //singleList.createList();
        singleList.displayList();
        System.out.println(singleList.contains(10));
        System.out.println(singleList.size());
        singleList.addLast(50);
    }
}

