import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);//从队尾入队
        queue.offer(2);
        queue.offer(3);

        int ret = queue.peek();//获取队头元素
        System.out.println(ret);

        int ret1 = queue.poll();//从队头出队，删除队头元素并返回
        System.out.println(ret1);

        boolean ret2 = queue.isEmpty();//判断队列是否为空
        System.out.println(ret2);

        int queuesize = queue.size();//返回队列中的有效元素个数
        System.out.println(queuesize);
    }
}
