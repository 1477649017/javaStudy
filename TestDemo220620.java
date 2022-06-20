/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-20
 * Time: 7:41
 */
class MyArray<T,K>{
    public T[] array = (T[])new Object[10];
    public K[] array1 = (K[])new Object[10];
    public T getArray(int pos) {
        return array[pos];
    }

    public void setArray(int pos,T num) {
        this.array[pos] = num;
    }

    public K getArray1(int pos) {
        return array1[pos];
    }

    public void setArray1(int pos,K num1) {
        this.array1[pos] = num1;
    }
}
public class TestDemo220620 {
    public static void main(String[] args) {
//        现在数组里面只能放String类型
        MyArray<String,Integer> ay = new MyArray<String,Integer>();
        ay.setArray(0,"abcd");
        String s = ay.getArray(0);
        System.out.println(s);

        ay.setArray1(0,100);
        int ret = ay.getArray1(0);
        System.out.println(ret);
    }
}
