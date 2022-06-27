import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-27
 * Time: 9:25
 */
class Card{
    public int rank;//牌面值
    public String suit;//花色

    public Card(int rank, String suit) {//构造方法
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suit + ":" + rank;
    }
}
public class CardDemo {
//    首先我们肯定要先生成一副牌，但是不包括大小王
    List<Card> list = new ArrayList<>();//将我们生成好的牌放到List中
//    定义一个花色的数组
    public static final String[] suits = {"♥","♠","♣","♦"};
//    定义一个生成牌的函数
    public List<Card> creatingCard(){
        for(int i = 1;i <= 13;i++){
            for(int j = 0;j < suits.length;j++){
                Card card = new Card(i,suits[j]);
                list.add(card);
            }
        }
        return list;
    }

//    定义一个洗牌的函数
    public void shuffle(List<Card> tmpCard){
//        思路是从后往前开始遍历，然后在前面找一个数与之进行交换
        for (int i = tmpCard.size() - 1; i > 0; i--) {
            Random random = new Random();
            int index = random.nextInt(i);//产生一个[0,i)的随机数
//            进行交换
            Card tmp = tmpCard.get(i);
            tmpCard.set(i,tmpCard.get(index));
            tmpCard.set(index,tmp);
        }
    }

//    定义一个发牌的函数
//    开始发牌，四个人，每个人13张牌，一共52张
    public List<List<Card>> dealCard(List<Card> tmpCard){
//        其实发牌的过程就是一个删除的过程
        List<Card> hand1 = new ArrayList<>();//第一个人
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();
        List<Card> hand4 = new ArrayList<>();
//      定义一个嵌套的List，把每个人组织起来
        List<List<Card>> hands = new ArrayList<>();//其中每一个元素又是一个List<Card>,其实就是相当于一个二维数组
//        然后把人放进去
        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);
        hands.add(hand4);


        for(int i = 0;i < 13;i++){
            for(int j = 0;j < 4;j++){
                Card getscard = tmpCard.remove(0);//删除0下标处的牌
                hands.get(j).add(getscard);//把这张牌加到每个人的手中
            }
        }
        return hands;
    }

}
