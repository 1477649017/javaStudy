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
    public static void testShellSort(int[] array1){
        long startTime = System.currentTimeMillis();//开始时间
        Sort.shellSort(array1);
        long endTime = System.currentTimeMillis();//结束时间
        System.out.println("希尔排序用时：" + (endTime - startTime));

    }
    public static void testInsertSort(int[] array){
        long startTime = System.currentTimeMillis();//开始时间
        Sort sort = new Sort();
        sort.inserSort(array);
        long endTime = System.currentTimeMillis();//结束时间
        System.out.println("直接插入排序用时：" + (endTime - startTime));
    }

    public static void testSelectSort(int[] array){
        long startTime = System.currentTimeMillis();//开始时间
        Sort.selectSort(array);
        long endTime = System.currentTimeMillis();//结束时间
        System.out.println("直接选择排序用时：" + (endTime - startTime));
    }

    public static void testSelectSort2(int[] array){
        long startTime = System.currentTimeMillis();//开始时间
        Sort.selectSort2(array);
        long endTime = System.currentTimeMillis();//结束时间
        System.out.println("优化版直接选择排序用时：" + (endTime - startTime));
    }

    public static void testHeapSort(int[] array){
        long startTime = System.currentTimeMillis();//开始时间
        Sort.heapSort(array);
        long endTime = System.currentTimeMillis();//结束时间
        System.out.println("堆排序用时：" + (endTime - startTime));
    }

    public static void testBubbleSort(int[] array){
        long startTime = System.currentTimeMillis();//开始时间
        Sort.bubbleSort(array);
        long endTime = System.currentTimeMillis();//结束时间
        System.out.println("堆排序用时：" + (endTime - startTime));
    }

    public static void testQuickSort(int[] array){
        long startTime = System.currentTimeMillis();//开始时间
        Sort.quickSort(array);
        long endTime = System.currentTimeMillis();//结束时间
        System.out.println("快速排序用时：" + (endTime - startTime));
    }

    public static void initArrayOrder(int[] array){
        for(int i = 0;i < array.length;i++){
            array[i] = i;
        }
    }

    public static void initArrayNotOrder(int[] array){
        Random random = new Random(100000);//左闭右开
        for(int i = 0;i < array.length;i++){
            array[i] = random.nextInt();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100000];
        initArrayNotOrder(array);
        testInsertSort(array);
        testShellSort(array);
        testSelectSort(array);
        testSelectSort2(array);
        testHeapSort(array);

        int[] array1 = new int[]{1,2,3,4,5};
//        testBubbleSort(array1);//不要用太多数据测
//        System.out.println(Arrays.toString(array1));
//
        testQuickSort(array);


    }
}
