import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

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


    //三数取中,找到这个中间大小值的下标
    private static int getMidNum(int[] array,int left,int right){
        int mid = (left + right) >> 1;
        if(array[left] < array[right]){
            if(array[mid] < array[left]){
                return left;
            }else if(array[mid] > array[right]){
                return right;
            }else{
                return mid;
            }
        }else{
            if(array[mid] > array[left]){
                return left;
            }else if(array[mid] < array[right]){
                return right;
            }else{
                return mid;
            }
        }
    }


    public static void inserSort2(int[] array,int left,int right){
        for(int i = left + 1;i <= right;i++){//right是要取到的
            int tmp = array[i];
            int j = 0;
            for(j = i -1;j >= left;j--){
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    private static void quick(int[] array,int left,int right){//在[left,right]去进行分割
        if(left >= right){
            return ;
        }
        if(right - left + 1 <= 7){//区间内结点数小于规定值后选取直接插入排序
            inserSort2(array,left,right);
            return;
        }

        int midIndex = getMidNum(array,left,right);//找寻到中间大小元素的下标
        swap(array,left,midIndex);//把这个元素与left下标处的元素交换
        int divIndex = partion2(array,left,right);
        quick(array,left,divIndex - 1);//递归对左半部分，右半部分进行分割
        quick(array,divIndex + 1,right);
    }
    public static void quickSort(int[] array){
        array = Arrays.copyOf(array,array.length);//拷贝一份
        quick(array,0, array.length-1);
    }

    /*
    * 非递归实现快速排序
    * */

    public static void quickSort2(int[] array){
        array = Arrays.copyOf(array,array.length);//拷贝一份

        Stack<Integer> stack = new Stack<>();//利用栈来实现非递归
        int left = 0;
        int right = array.length - 1;

        int divIndex = partion1(array,left,right);//分割第一次，找到第一个分割点

        if(divIndex > left + 1){//分割点左边至少有两个元素才把两个边界入栈
            stack.push(left);
            stack.push(divIndex-1);
        }
        if(divIndex < right - 1){//分割点右边至少有两个元素才把两个边界入栈
            stack.push(divIndex + 1);
            stack.push(right);
        }

        //现在栈中存放的就是分割点两边的两个区间的边界
        while(!stack.empty()){
            right = stack.pop();//先弹出右边界值
            left = stack.pop();

            divIndex = partion1(array,left,right);//在这个新区间再去分割

            if(divIndex > left + 1){//分割点左边至少有两个元素才把两个边界入栈
                stack.push(left);
                stack.push(divIndex-1);
            }
            if(divIndex < right - 1){//分割点右边至少有两个元素才把两个边界入栈
                stack.push(divIndex + 1);
                stack.push(right);
            }

        }
    }

    /*
    * 归并排序
    * */
    private static void mergeFunc(int[] array,int left,int right){
        if(left >= right){
            return ;//大于是因为可能分不出子树的情况
        }

        int mid = (left + right)/2;
        //1,分解左边
        mergeFunc(array,left,mid);
        //2,分解右边
        mergeFunc(array,mid+1,right);
        //3,进行合并
        merge(array,left,right,mid);
    }

    private static void merge(int[] array,int start,int end,int midIndex){
        //首先得有一个临时的数组
        int[] tmp = new int[end-start+1];
        int k = 0;//记录这个数组的下标

        int s1 = start;
        int s2 = midIndex + 1;

        while (s1 <= midIndex && s2 <= end){//合并的前提是两个段都有数据
            if(array[s1] > array[s2]){
                tmp[k++] = array[s2++];
            }else{
                tmp[k++] = array[s1++];
            }
        }
        //有可能两个段中有一个先拿完，那么剩下的就是全部另一个段中的元素了
        while(s1 <= midIndex){
            tmp[k++] = array[s1++];
        }
        while(s2 <= end){
            tmp[k++] = array[s2++];
        }
        //现在tmp中是排序合并好了的数组，要拷贝到原来的array中
        for(int i = 0;i < k;i++){
            array[i + start] = tmp[i];
        }
    }
    public static void mergeSort(int[] array){
        array = Arrays.copyOf(array,array.length);//拷贝一份
        mergeFunc(array,0,array.length-1);
    }


    /*
    * 归并排序非递归实现
    *
    * */
    public static void mergeSort2(int[] array){
        //array = Arrays.copyOf(array,array.length);//拷贝一份

        int gap = 1;//每组数据个数
        while(gap < array.length){
            for(int i = 0;i < array.length-1;i += 2*gap){
                int s1 = i;
                int e1 = s1 + gap - 1;
                if(e1 >= array.length - 1){
                    e1 = array.length - 1;
                }
                int s2 = e1 + 1;
                if(s2 >= array.length - 1){
                    s2 = array.length - 1;
                }
                int e2 = s2 + gap - 1;
                if(e2 >= array.length - 1){
                    e2 = array.length - 1;
                }
                merge(array,s1,e2,e1);
            }
            gap *= 2;
        }
    }

    /*
    * 计数排序
    * */
    public static void countSort(int[] array){
        //先找到数组里面的最大值与最小值
        int min = array[0];
        int max = array[0];//假设0下标是最大值最小值
        for(int i = 0;i < array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        //new一个count数组
        int[] count = new int[max - min + 1];
        for(int i = 0;i < array.length;i++){
            //开始给每一个元素计数
            int val = array[i];
            count[val - min]++;
        }

        //开始排序
        int index = 0;
        for(int i = 0;i < count.length;i++){
            while(count[i] != 0){
                array[index] = i + min;
                index++;
                count[i]--;
            }
        }
    }
}
