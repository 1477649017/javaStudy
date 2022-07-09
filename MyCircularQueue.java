public class MyCircularQueue {
    public int[] elem;
    public int UsedSize;//计数
    public int front;//队头下标
    public int rear;//队尾下标

    public MyCircularQueue(int k) {
        elem = new int[k + 1];
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            //return false;
            //或者扩容
            int[] tmp = new int[2* elem.length];
            if(front == 0){
                System.arraycopy(elem,front,tmp,front,elem.length - 1);
                elem = tmp;
            }else{
                System.arraycopy(elem,front,tmp,front,elem.length - front);
                System.arraycopy(elem,0,tmp,elem.length,front-1);
                rear = front + elem.length - 1;
                elem = tmp;
            }
        }
        elem[rear] = value;
        rear = (rear + 1)% elem.length;//因为考虑到下标会从末尾直接到0
        UsedSize++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1)% elem.length;
        UsedSize--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;//队列空就返回-1
        }
        return elem[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        int index = (rear == 0) ? elem.length - 1 : rear - 1;//不能直接-1，rear = 0的情况不符合
        return elem[index];
    }
    
    public boolean isEmpty() {
        //return UsedSize == 0;
        return front == rear;
    }
    
    public boolean isFull() {
        //return UsedSize == elem.length;
        return (rear + 1)% elem.length == front;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(4);
        myCircularQueue.enQueue(10);
        myCircularQueue.enQueue(20);
        myCircularQueue.enQueue(30);
        myCircularQueue.enQueue(40);

    }
}

