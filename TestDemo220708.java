import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-08
 * Time: 7:52
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
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        //下面把各个节点串起来
        node1.next = node2;//node2就是第二个节点的地址
        node2.next = node3;
        node3.next = node4;
        head = node1;
    }

    //        递归实现逆序打印链表
    public void printList(Node head){
        if(head == null){
            return;
        }
        if(head.next == null){//说明是最后一个节点
            System.out.print(head.val + " ");
            return;
        }
        printList(head.next);
        System.out.print(head.val + " ");
    }

    //        循环思想，逆序打印链表
    public void printList1(){
        Stack<Node> stack = new Stack<>();
        Node cur = this.head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while(! stack.empty()){
            Node top = stack.pop();
            System.out.print(top.val + " ");
        }
    }

}
public class TestDemo220708 {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.createList();
        singleList.printList(singleList.head);
        System.out.println();
        singleList.printList1();


    }
}
