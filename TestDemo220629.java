import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-29
 * Time: 8:26
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> ret = new ArrayList<>();

        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[(nums[i] - 1) % n] += n;
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 2 * n) ret.add(i+1);
        }
        return ret;
    }
}
public class TestDemo220629 {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] array = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> ret = sl.findDuplicates(array);
        System.out.println(ret);
    }
}
