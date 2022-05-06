import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-06
 * Time: 22:10
 */
public class TestDemo220506 {
    public static String myToString(int[] array){
        String tmp = "[";
        for(int i = 0;i < array.length;i++){
            tmp += array[i];
            if(i != array.length - 1){
                tmp += ",";
            }
            if(i == array.length - 1){
                tmp += "]";
            }
        }
        return tmp;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3};
        String ret = myToString(array);
        System.out.println(ret);
    }
    public static int[] copyArray(int[] array){
        int[] tmp = new int[array.length];
        for(int i = 0;i < array.length;i++){
            tmp[i] = array[i];
        }
        return tmp;
    }
    public static void main7(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] ret = copyArray(array);
        System.out.println(Arrays.toString(ret));
    }
    public static int find1(int[] arr,int key){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
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
    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你要查找的数：");
        int key = scan.nextInt();
        int[] arr = {1,2,3,4,5};
        int ret = find1(arr,key);
        if(ret != -1){
            System.out.println("找到了，下标为：" + ret);
        }else{
            System.out.println("未找到！");
        }
    }
    public static boolean isOrder(int[] nums){
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > nums[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[4];
        int i = 0;
        System.out.println("请为数组赋值：");
        while(i < nums.length){
            nums[i] = scan.nextInt();
            i++;
        }
        boolean ret = isOrder(nums);
        if(ret == false){
            System.out.println("无序！");
        }else{
            System.out.println("有序！");
        }
    }
    public static void bubbleSort(int[] array){
        for(int i = 0;i < array.length - 1;i++){
            int flg = 1;
            for(int j = 0;j < array.length - 1 - i;j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = -1;
                }
            }
            if(flg == 1){
                break;
            }
        }
    }
    public static void main4(String[] args) {
        int[] array = new int[]{5,4,7,2,8};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static int[] twoSum(int[] nums,int target){
        int dest1 = 0;
        int dest2 = 1;
        int[] ret = new int[2];
        label:
        for(int i = 0;i < nums.length;i++){
            while(dest2 < nums.length){
                if(nums[dest1] + nums[dest2] == target){
                    ret[0] = dest1;
                    ret[1] = dest2;
                    break label;
                }
                dest2++;
            }
            dest1++;
            dest2 = dest1 + 1;
        }
        return ret;
    }
    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[4];
        int i = 0;
        System.out.println("请为数组赋值：");
        while(i < nums.length){
            nums[i] = scan.nextInt();
            i++;
        }
        System.out.println("请输入目标和：");
        int target = scan.nextInt();
        int[] ret = new int[2];
        ret = twoSum(nums,target);
        System.out.println(Arrays.toString(ret));
    }
    public static void setNum(int[] array){
        for(int i = 0;i < array.length;i++){
            array[i] = i + 1;
        }
    }
    public static void main2(String[] args) {
        int[] array = new int[100];
        setNum(array);
        System.out.println(Arrays.toString(array));
    }
    public static void transform(int[] array){
        for(int i = 0;i < array.length;i++){
            array[i] *= 2;
        }
    }
    public static void main1(String[] args) {
        int[] array = new int[]{1,2,3};
        transform(array);
        System.out.println(Arrays.toString(array));

    }
}
