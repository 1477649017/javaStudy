import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-24
 * Time: 7:47
 */

//模拟一个顺序表接口的实现

class MyArraylist{
//    以下是数组
    public int[] elem;
    public int UsedSize;//有效数据的个数
    public static final int CAPACITY = 10;//定义一个初始数组长度的值

    public MyArraylist(){
        this.elem = new int[CAPACITY];
    }
//    以下是操作方法
    // 打印顺序表
     public void display() {
         for (int i = 0; i < this.UsedSize; i++) {
             System.out.print(this.elem[i] + " ");
         }
         System.out.println();
     }
//     在数据结构中插入数据的时候必须有一个前驱的信息，不能跳着放
    // 新增元素,默认在数组最后新增
    public boolean isFull(){
        return this.elem.length == UsedSize;
    }
    public void add(int data) {
//        新增数据，必须要先检查我们的数组是不是满了
        if(isFull()){
            //确定是满了，就需要扩容
            this.elem = Arrays.copyOf(elem,2*elem.length);//将扩容的数组的引用还是赋值给elem
        }
        this.elem[UsedSize] = data;
        UsedSize++;
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) { }
    // 判定是否包含某个元素
    public boolean contains(int toFind) { return true; }
    // 查找某个元素对应的位置
    public int indexOf(int toFind) { return -1; }
    // 获取 pos 位置的元素
    public int get(int pos) { return -1; }
    // 给 pos 位置的元素设为 value
    public void set(int pos, int value) { }
    //删除第一次出现的关键字key
    public void remove(int toRemove) { }
    // 获取顺序表长度
    public int size() { return 0; }
    // 清空顺序表
    public void clear() { }


}
public class TestDemo220624 {
    public static void main(String[] args) {
//
    }
}
