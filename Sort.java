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
    * 直接选择排序
    * */
    public static void selectSort(int[] array) {
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

    private static void swap(int[] array,int index1,int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}
