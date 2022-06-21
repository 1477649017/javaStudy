import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-21
 * Time: 8:39
 */
class MyArray<T>{//T是一个占位符，标识当前类是一个泛型类
    //<>里面指定了类型，那么这个时候就确定了这个类里面就只能放这个类型的数据
    public T[] array = (T[])new Object[10];
//    public T[] array = new T[10];这是不行的

    public T getArray(int pos) {
        return array[pos];
    }

    public void setArray(int pos,T num) {
        this.array[pos] = num;
    }

    public T[] getArrays(){
        return this.array;
    }
}


class Myarray2<T>{
    public T[] array2;//只进行声明
    public Myarray2(Class<T> clazz, int capacity) {
        array2 = (T[]) Array.newInstance(clazz, capacity);//clazz是你的数组的类型，后面是数组的大小
    }
    public T getPos(int pos) {
        return this.array2[pos];
    }
    public void setVal(int pos,T val) {
        this.array2[pos] = val;
    }

    public T[] getArray() {
        return array2;
    }
}


public class TestDemo220621 {
    public static void main(String[] args) {
        Myarray2<String> ay = new Myarray2<String>(String.class,10);
        ay.setVal(0,"abcd");
        String[] tmp = ay.getArray();
        System.out.println(Arrays.toString(tmp));
    }

    public static void main2(String[] args) {
        MyArray<String> ay = new MyArray<String>();
        ay.setArray(0,"abcd");
        String[] tmp = ay.getArrays();

    }
    public static void main1(String[] args) {
//        现在数组里面只能放String类型
        MyArray<String> ay = new MyArray<String>();
        ay.setArray(0,"abcd");
        ay.setArray(1,"hello");
        String s = ay.getArray(0);
        System.out.println(s);
    }
}



