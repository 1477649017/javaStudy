import java.util.Arrays;

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

}
