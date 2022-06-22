/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-22
 * Time: 8:46
 */
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


class Myarray2<T extends Number>{
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

//写一个函数，可以进行一个泛型数组找出最大值
class Alg<T extends Comparable<T>>{
    public T[] array;
    public Alg(Class<T> clazz, int capacity) {
        array = (T[]) Array.newInstance(clazz, capacity);
    }

    public void setArray(int pos,T num) {
        this.array[pos] = num;
    }

    public T findMax(){
        T max = array[0];
        for(int i = 1;i < array.length;i++){
            if(array[i].compareTo(max) > 0){
                max = array[i];
            }
        }
        return max;
    }
}


class Alg2{
    public static<T extends Comparable<T>> T findMax(T[] array){
        T max = array[0];
        for(int i = 1;i < array.length;i++){
            if(array[i].compareTo(max) > 0){
                max = array[i];
            }
        }
        return max;
    }
}


class Test<T>{

}
public class TestDemo220622 {
    public static void main(String[] args) {
        Test<Integer> t1 = new Test<Integer>();
        System.out.println(t1);
        Test<String> t2 = new Test<String>();
        System.out.println(t2);
    }
    public static void main3(String[] args) {
//        这个时候就不需要定义对象了
        Integer[] array = {1,2,3,4,5};
        //Integer ret = Alg2.findMax(array);//T会根据你传入的变量进行类型的推导
        Integer ret = Alg2.<Integer>findMax(array);
        System.out.println(ret);
    }
    public static void main2(String[] args) {
        Alg<Integer> alg = new Alg<Integer>(Integer.class,3);
        alg.setArray(0,10);
        alg.setArray(1,5);
        alg.setArray(2,20);
        Integer ret = alg.findMax();
        System.out.println(ret);

    }
    public static void main1(String[] args) {
        Myarray2<Integer> ay = new Myarray2<Integer>(Integer.class, 10);
        ay.setVal(0, 10);

        Myarray2<Double> ay1 = new Myarray2<Double>(Double.class,10);
        ay1.setVal(0,1.68);

    }
}
