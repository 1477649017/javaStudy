import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-27
 * Time: 9:14
 */
class Solution {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i < numRows;i++){
            list.add(new ArrayList<>());
            for(int j = 0;j <= i;j++){
                if(j == 0 || j == i){
                    list.get(i).add(1);
                }else{
                    int num = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
                    list.get(i).add(num);
                }
            }
        }
        return list;
    }
}
public class TestDemo220627 {
    public static void main(String[] args) {
        Solution sl = new Solution();
        List<List<Integer>> ret = sl.generate(5);
        for (List<Integer> tmp:ret) {
            System.out.println(tmp);
        }
    }
    public static void main1(String[] args) {
        CardDemo cardDemo = new CardDemo();
        List<Card> ret = cardDemo.creatingCard();
        System.out.println(ret);
        System.out.println("洗牌后：");
        cardDemo.shuffle(ret);
        System.out.println(ret);
        System.out.println("====开始发牌>>>====");
        List<List<Card>> ret1 = cardDemo.dealCard(ret);
        for(int i = 0;i < ret1.size();i++){
            int peopleNum = i + 1;
            System.out.println("第" + peopleNum + "个的牌：" + ret1.get(i));
        }
    }
}
