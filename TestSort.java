import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-17
 * Time: 8:05
 */
public class TestSort {
    public static void testInsertSort(int[] array){
        long startTime = System.currentTimeMillis();//开始时间
        Sort sort = new Sort();
        sort.inserSort(array);
        long endTime = System.currentTimeMillis();//结束时间
        System.out.println("直接插入排序用时：" + (endTime - startTime));
    }
    public static void initArrayOrder(int[] array){
        for(int i = 0;i < array.length;i++){
            array[i] = i;
        }
    }

    public static void initArrayNotOrder(int[] array){
        Random random = new Random(10000);//左闭右开
        for(int i = 0;i < array.length;i++){
            array[i] = random.nextInt();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10000];
        initArrayOrder(array);
        testInsertSort(array);
    }
}
