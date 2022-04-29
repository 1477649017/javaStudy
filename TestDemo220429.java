import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-04-29
 * Time: 9:43
 */
public class TestDemo220429 {
    public static int[] copyArray(int[] array){
        int[] tmp = new int[array.length];
        for(int i = 0;i < array.length;i++){
            tmp[i] = array[i];
        }
        return tmp;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] ret = copyArray(array);
        int[] ret1 = Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] getDouble(int[] array){
        for(int i = 0;i < array.length;i++){
            array[i] *= 2;
        }
        return array;
    }
    public static void main4(String[] args) {
        int[] array = {1,2,3};
        int[] ret = getDouble(array);
        System.out.println(Arrays.toString(ret));
    }
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
    public static void main5(String[] args) {
        int[] array = {1,2,3};
        String ret = myToString(array);
        System.out.println(ret);
    }
    public static void func1(int[] arr1){
        arr1 = new int[]{1,2,3};
    }
    public static void func2(int[] arr2){
        arr2[0] = 9;
    }
    public static void main2(String[] args) {
        int[] arr = {8,8,8};
        func1(arr);
        for (int x:arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        func2(arr);
        for (int x:arr) {
            System.out.print(x + " ");
        }
    }
    public static void main1(String[] args) {
        int[] array1 = {1,2,3};
        int[] array2 = {4,5,6};
        array2 = array1;
        for (int x:array2) {
            System.out.print(x + " ");
        }
        int[] arr = {1,2,3};
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for(int x:arr){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr3 = new int[5];
        int n = 10;
        int[] arr4 = new int[n];
        int[] arr5 = new int[0];


    }
}
