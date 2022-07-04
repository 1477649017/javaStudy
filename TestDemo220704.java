import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-04
 * Time: 7:36
 */

class MyLinkedList{
    static class ListNode{//内部节点类
        public int val;
        public ListNode prev;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public ListNode head;//头节点
    public ListNode last;//尾节点

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;//原链表为空的情况下，头节点，尾节点都是node
            last = node;
        }else{
//            链表不为空的情况下，头插，node的prev为null，不需要考虑
            node.next = head;
            head.prev = node;
            head = node;//把head更新一下,尾节点是不需要更新的
        }


    };
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(head == null){//如果刚开始链表就为null
            head = node;
            last = node;
        }else{
            last.next = node;
            node.prev = last;
            last = node;
        }
    }
    private boolean checkAddIndex(int index){
        if(index < 0 || index > size()){
            throw new IndexException("index不合法！");
        }
        return true;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
//        先检查index的合法性
        try{
            checkAddIndex(index);
            ListNode node = new ListNode(data);
//        先找到index的元素
            if(index == 0){
                addFirst(data);
                return;//如果index == 0就是头插
            }
            if(index == size()){
                addLast(data);
                return;//就是尾插
            }
//        中间插入
            ListNode cur = head;
            while(index != 0){//cur往后走index步，找到index位置的元素
                cur = cur.next;
                index--;
            }
            node.next = cur;
            node.prev = cur.prev;
            cur.prev.next = node;
            cur.prev = node;
        }catch (IndexException e){
            e.printStackTrace();
        }
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = head;
        while(cur != null){
            if(cur.val == key){
                cur.next.prev = cur.prev;
                cur.prev.next = cur.next;
                return;
            }
            cur = cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){

    }
    //得到单链表的长度
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public void clear(){

    }

}

public class TestDemo220704 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(20);
        myLinkedList.addFirst(30);
        myLinkedList.addLast(40);
        myLinkedList.addIndex(0,60);
        myLinkedList.addIndex(5,70);

        myLinkedList.display();
    }
}
