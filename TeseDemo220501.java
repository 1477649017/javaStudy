import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-01
 * Time: 10:07
 */
public class TeseDemo220501 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            // 3,双指针，借助一个中间数组
            int p1 = 0;
            int p2 = 0;
            int p3 = 0;
            int[] tmp = Arrays.copyOf(nums1,m+n);
            while(p3 < m + n || p2 < n){
                if(tmp[p1] <= nums2[p2]){
                    nums1[p3++] = tmp[p1++];
                }else{
                    nums1[p3++] = nums2[p2++];
                }

            }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    public static int[] getSingledog2(int[] array){
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            tmp ^= array[i];
        }
        int j = 0;
        for(j = 0;j < 32;j++){
            if(((tmp>>>j) & 1) == 1){
                break;
            }
        }
        int ret1 = 0;
        int ret2 = 0;
        for(int i = 0;i < array.length;i++){
            if(((array[i] >>> j)&1) == 1){
                ret1 ^= array[i];
            }else{
                ret2 ^= array[i];
            }
        }
        int[] singledog = new int[2];
        singledog[0] = ret1;
        singledog[1] = ret2;
        return singledog;//两个单身狗
    }
    public static int getSingledog1(int[] array) {//这只能找出一个单身狗
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            tmp ^= array[i];
        }
        return tmp;
    }

    public static void main4(String[] args) {
        int[] array = {1, 2, 1, 5, 3, 3, 4, 4};
        //int ret = getSingledog1(array);
        int[] ret = getSingledog2(array);
        System.out.println(Arrays.toString(ret));
    }
}
