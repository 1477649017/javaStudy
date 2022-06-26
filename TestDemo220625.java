/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-25
 * Time: 8:41
 */


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-24
 * Time: 7:47
 */

//模拟一个顺序表
import javax.print.DocFlavor;
import java.util.*;

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
//    数据结构是一门严谨的学科，所以需要我们去分析好每一种情况
    private void CheckAddPos(int pos){
        if(pos < 0 || pos > this.UsedSize){//当pos == Usedsize时就是尾部插入，但是不能跳着插入，大于就不行了
            throw new AddPosLegalException("pos不合法！插入元素过程");
        }
    }
    public void add(int pos, int data) {
//        判断我们的pos下标是否合法
        try{
            CheckAddPos(pos);
            //        首先判断数组是否满了
            if(isFull()){
                this.elem = this.elem = Arrays.copyOf(elem,2*elem.length);
            }

            for(int i = this.UsedSize - 1;i >= pos;i--){
                this.elem[i+1] = this.elem[i];
            }
            this.elem[pos] = data;//移动完元素后把data放到pos位置处
            this.UsedSize++;
        }catch (AddPosLegalException e){
            e.printStackTrace();
        }
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for(int i = 0;i < this.UsedSize;i++){//不需要判断顺序表是否为空，因为空的时候for循环进不去
            if(this.elem[i] == toFind){
                return true;//找到了就返回true
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for(int i = 0;i < this.UsedSize;i++){//不需要判断顺序表是否为空，因为空的时候for循环进不去
            if(this.elem[i] == toFind){
                return i;//找到了就返回下标i
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    private void CheckGetPos(int pos){
        if(pos < 0 || pos >= this.UsedSize){
            throw new GetPosLegalException("pos位置不合法！取元素过程");
        }
    }
    public int get(int pos) {
//       首先也是判断pos是否合法，不过这个pos的合法条件与add的是不同的
        try{
            CheckGetPos(pos);
        }catch (GetPosLegalException e){
            e.printStackTrace();
        }
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void set(int pos, int value) {
        //首先检查pos位置的合法性
        CheckGetPos(pos);//有异常直接扔给JVM
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int key) {
        //先找到key的位置
        int pos = indexOf(key);
        if(pos == -1){
            System.out.println("顺序表中没有你想要删除的元素！");
            return;
        }
        for(int i = pos;i < this.UsedSize - 1;i++){
            this.elem[i] = this.elem[i+1];
        }
//      this.elem[UsedSize] = null;如果说数组中是引用类型的话，你删除后最后一个元素需要手动置为空，防止内存泄漏
        this.UsedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.UsedSize;
    }
    // 清空顺序表
    public void clear() {
        this.UsedSize = 0;
    }


}
public class TestDemo220625 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

//        sout直接输出
        System.out.println(list);
//        for循环遍历输出
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
//        foreach循环遍历输出
        for (Integer tmp:list) {
            System.out.print(tmp + " ");
        }
        System.out.println();
//        迭代器1
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
//        迭代器2
        ListIterator<Integer> it1 = list.listIterator();
        while(it1.hasNext()){
            System.out.print(it1.next() + " ");
        }

    }
    public static void main4(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("haha");
        list1.add("hehe");
        list1.add("hoho");
        list1.add("huhu");
        List<String> ret = list1.subList(1,3);
        System.out.println(ret);
        ret.set(0,"haha");
        System.out.println(list1);
        System.out.println(ret);
    }
    public static void main3(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(15);
        arrayList1.add(10);
        System.out.println(arrayList1);
        ArrayList<Integer> arrayList2 = new ArrayList<>(arrayList1);
        System.out.println(arrayList2);
    }
    public static void main2(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        System.out.println(arrayList);
    }
    public static void main1(String[] args) {
        MyArraylist myArraylist = new MyArraylist();
        myArraylist.add(1);
        myArraylist.add(2);
        myArraylist.add(3);
        myArraylist.display();
        myArraylist.add(1,10);
        myArraylist.display();
        System.out.println(myArraylist.contains(10));
        System.out.println(myArraylist.get(2));
        myArraylist.set(0,100);
        myArraylist.display();

        

    }
}

