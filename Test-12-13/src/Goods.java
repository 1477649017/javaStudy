/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-12-13
 * Time: 17:22
 */
class Goods{
    private int number;
    private String name;
    private int amount;

    public Goods(int number,String name,int amount){
        this.number=number;
        this.name=name;
        this.amount=amount;
    }

    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }
    public int getAmount(){
        return amount;
    }
}