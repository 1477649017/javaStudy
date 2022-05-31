/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-31
 * Time: 11:26
 */
//分区块类
public class Hole {

    private int head;       //分区块的起始地址
    private int size;       //分区块的大小
    private boolean isFree; //分区块的空闲状态

    public Hole(int head, int size) {
        this.head = head;
        this.size = size;
        this.isFree = true;
    }

    public Hole(int head, int size, boolean isFree) {
        this.head = head;
        this.size = size;
        this.isFree = isFree;
    }

//    打印输出的方法
    @Override
    public String toString() {
        return "Hole{" +
                "head=" + head +
                ", size=" + size +
                ", isFree=" + isFree +
                '}';
    }

//    get与set方法
    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}