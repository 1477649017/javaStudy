import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-17
 * Time: 8:05
 */
public class Sort {
    /*
     * 1,直接插入排序
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * */
    public void inserSort(int[] array){
        array = Arrays.copyOf(array,array.length);//拷贝一份
        for(int i = 1;i < array.length;i++){
            int tmp = array[i];//相当于把每次摸到的牌进行保存
            int j = 0;
            for(j = i -1;j >= 0;j--){
                if(array[j] > tmp){//这个地方如果给到等号了，那就是不稳定的
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            //跳出循环说明已经不需要再移动元素了
            array[j + 1] = tmp;
        }
    }

    /*
    * 2,希尔排序
    * 时间复杂度：
    * 空间复杂度：
    *稳定性：
    * */
    public static void shell(int[] array,int gap){

        for(int i = gap;i < array.length;i++){
            int tmp = array[i];//相当于把每次摸到的牌进行保存
            int j = 0;
            for(j = i -gap;j >= 0;j -= gap){
                if(array[j] > tmp){//这个地方如果给到等号了，那就是不稳定的
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            //跳出循环说明已经不需要再移动元素了
            array[j + gap] = tmp;
        }
    }
    public static void shellSort(int[] array){
        array = Arrays.copyOf(array,array.length);//拷贝一份
        int gap = array.length;
        while(gap > 1){
            shell(array,gap);
            gap /= 2;
        }
        shell(array,1);//gap = 1单独排序一次
    }


    /*
    * 直接选择排序
    * */
    public static void selectSort(int[] array) {
        array = Arrays.copyOf(array,array.length);//拷贝一份
        for(int i = 0;i < array.length;i++){
            int minIndex = i;
            for(int j = i+1;j < array.length;j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            //进行值的交换
            swap(array,i,minIndex);
        }
    }

    /*
    * 直接选择排序优化
    * */
    public static void selectSort2(int[] array) {
        array = Arrays.copyOf(array,array.length);//拷贝一份
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int minIndex = left;
            int maxIndex = left;//初始都在left处
            for(int i = left + 1;i <= right;i++){
                if(array[i] > array[maxIndex]){
                    maxIndex = i;
                }
                if(array[i] < array[minIndex]){
                    minIndex = i;
                }
            }
            //每一轮都会找到一个最大值，最小值
            swap(array,left,minIndex);
            if(maxIndex == left){//防止最大值在left处，前面交换了直接把最大值移走了
                maxIndex = minIndex;
            }
            swap(array,right,maxIndex);
            left++;
            right--;
        }
    }

    private static void swap(int[] array,int index1,int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    /*
    * 堆排序
    * */

    public static void createBigHeap(int[] array){
        for(int parent = (array.length-1-1)/2;parent >= 0;parent--){
            shiftDown(array,parent, array.length);
        }
    }

    public static void shiftDown(int[] array,int parent,int len){
        int child = parent*2 + 1;
        while(child < len){//起码有左孩子
            if(child + 1 < len && array[child] < array[child + 1]){
                child++;//找到较大的孩子的下标
            }
            if(array[child] > array[parent]){
                swap(array,child,parent);//进行交换
                parent = child;
                child = 2*parent + 1;
            }else{
                break;
            }
        }
    }
    public static void heapSort(int[] array){
        array = Arrays.copyOf(array,array.length);//拷贝一份
        createBigHeap(array);//创建大根堆
        int end = array.length - 1;
        while(end > 0){
            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }

    }


    /*
    * 冒泡排序
    * */
    public static void bubbleSort(int[] array){
        for(int i = 0;i < array.length -1;i++){
            boolean flg = true;//假设有序了
            for(int j = 0;j < array.length - 1 -i;j++){
                if(array[j] > array[j+1]){
                    swap(array,j,j+1);
                    flg = false;
                }
            }
            if(flg == true){
                return ;
            }
        }
    }

    /*
    * 快速排序
    * */
    //1,Hoare的分割交换函数
    private static int partion(int[] array,int start,int end){//在[start,right]去寻找下一个分割点
        int keyIndex = start;//记录下最初start的位置
        int key = array[start];//每次的基准值等于左边1第一个元素
        //并进行元素的交换
        while(start < end){
            //先走右边
            while(start < end && array[end] >= key){
                end--;
            }
            //走左边
            while(start < end && array[start] <= key){
                start++;
            }
            swap(array,start,end);
        }
        swap(array,keyIndex,start);//把最后相遇点的元素与基准值交换
        return start;//返回我们的相遇点，也就是下一次的分割点下标
    }

    //2,挖坑法的分割交换函数
    private static int partion1(int[] array,int start,int end){//在[start,right]去寻找下一个分割点
        int key = array[start];//拿出左边元素形成一个坑位
        //并进行元素的交换
        while(start < end){
            //先走右边
            while(start < end && array[end] >= key){
                end--;
            }
            array[start] = array[end];//后面找到了小于基准值的元素就换到前面来把坑填上，并且后面end处形成新的坑位
            //走左边
            while(start < end && array[start] <= key){
                start++;
            }
            array[end] = array[start];
        }
        array[start] = key;//最后相遇了把key放到这个坑位
        return start;//返回我们的相遇点，也就是下一次的分割点下标
    }


    //3,前后指针法
    private static int partion2(int[] array,int start,int end){//在[start,right]去寻找下一个分割点
        int key = array[start];//拿出左边元素形成一个坑位
        //并进行元素的交换
        int prev = start;
        int cur = start+1;
        while(cur <= end){
           if(array[cur] < array[start] && array[++prev] != array[cur] ){
               swap(array,prev,cur);
           }
           cur++;
        }
        swap(array,start,prev);
        return prev;//返回我们的相遇点，也就是下一次的分割点下标
    }

    private static void quick(int[] array,int left,int right){//在[left,right]去进行分割
        if(left >= right){
            return ;
        }
        int divIndex = partion2(array,left,right);
        quick(array,left,divIndex - 1);//递归对左半部分，右半部分进行分割
        quick(array,divIndex + 1,right);
    }
    public static void quickSort(int[] array){
        array = Arrays.copyOf(array,array.length);//拷贝一份
        quick(array,0, array.length-1);
    }
}
