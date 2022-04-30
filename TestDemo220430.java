

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-04-30
 * Time: 9:07
 */


import java.lang.System;
import java.util.Arrays;
import java.util.Scanner;
public class TestDemo220430 {
    public static int getSingledog(int[] array){
        int tmp = 0;
        for(int i = 0;i < array.length;i++){
            tmp ^= array[i];
        }
        return tmp;
    }
    public static void main(String[] args) {
        int[] array = {1,2,1,3,3,4,4};
        Arrays.sort(array);//先将array排序
        int ret = getSingledog(array);
        System.out.println(ret);

    }
    public static void main11(String[] args) {
        int[][] array = new int[2][];
        array[0] = new int[]{1,2,3};
        array[1] = new int[]{4,5};
        System.out.println(Arrays.deepToString(array));
    }
    public static void main10(String[] args) {
        int[][] array = new int[][]{{1,2,3},{4,5,6}};
        for(int i = 0;i < array.length;i++){
            for(int j = 0;j < array[i].length;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(array));

        for (int[] tmp:array) {
            for (int x:tmp) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public static void swap(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            while(left < right && arr[left]%2 == 0){
                left++;//偶数放前面，所以只要前面有偶数，left就往后走
            }//跳出就说明遇到奇数了
            while(left < right && arr[right]%2 != 0){
                right--;//奇数放后面，所以只要后面有奇数，right就往前走
            }//跳出就说明遇到偶数了
            if(left < right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
    }
    public static void main9(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        swap(arr);
        System.out.println(Arrays.toString(arr));



    }
    public static void reverse(int[] array){
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
    public static void main8(String[] args) {
//        数组的逆置
        int[] array = {1,2,3,4,5};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }
    public static void bubbleSort(int[] array){
        for(int i = 0;i < array.length - 1;i++){
            int flg = 1;//定义一个标签，默认每一轮是有序的
            for(int j = 0;j < array.length - 1 -i;j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = 0;//如果是if满足了，就说明是无序的，将flg = 0
                }
            }
            if(flg == 1){
                break;//如果比了一轮flg没变，就说明是有序的，不需要再比了
            }
        }
    }
    public static void main7(String[] args) {
        int[] array = {1,2,3,5,6,4};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static boolean isUp(int[] array){
        for(int i = 0;i < array.length;i++){
            if(array[i] > array[i + 1]){
                return false;
            }
        }
        return true;
    }
    public static void main6(String[] args) {
        int[] array = {2,3,1,4,6,8,7};
        boolean ret = isUp(array);
        System.out.println(ret);
    }
    public static int find1(int[] arr,int key){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)>>>1;
            if(arr[mid] > key){
                right = mid - 1;
            }else if(arr[mid] < key){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static int find(int[] arr,int key){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;//找不到就返回-1
    }
    public static void main5(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("请输入你要查找的数：");
//        int key = scan.nextInt();
        int[] arr = {1,2,3,4,5};
        int[] arr1 = {2,3,4,5,6};
//        int ret1 = Arrays.binarySearch(arr,1,3,key);
//        System.out.println("下标为：" + ret1);
//部分拷贝数组
        int[] ret2 = Arrays.copyOfRange(arr,1,4);
        System.out.println(Arrays.toString(ret2));
//检查两个数组是否相等
        boolean ret3 = Arrays.equals(arr,arr1);
        System.out.println(ret3);
//        填充数组
        int[] arr2 = new int[10];
        Arrays.fill(arr2,1,5,8);
        System.out.println(Arrays.toString(arr2));

//        排序数组
        int[] arr3 = {2,1,5,3,8,6};
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));


//        int ret = find1(arr,key);
//        if(ret != -1){
//            System.out.println("找到了，下标为：" + ret);
//        }else{
//            System.out.println("未找到！");
//        }
    }
    public static int getMaxnum(int[] array){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        return max;//最大值
        //return min // 最小值
    }
    public static void main3(String[] args) {
        int[] array = {12,13,4,5,6,88};
        int ret = getMaxnum(array);
        System.out.println("最大值是：" + ret);
    }
    public static void main2(String[] args) {
        //对于基本类型来说就是深拷贝
        int[] array = {1,2,3,4,5};
        int[] ret = new int[array.length];
        System.arraycopy(array,0,ret,0,array.length);
        ret[0] = 99;
        System.out.println(array[0]);
    }
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] ret = new int[array.length];
        ret = array.clone();
        //System.arraycopy(array,0,ret,0,array.length);
        //Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(ret));
    }
}
