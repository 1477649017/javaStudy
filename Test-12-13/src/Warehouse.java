/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-12-13
 * Time: 17:22
 */
class Warehouse{
    private int number;
    private String name;
    private int capacity;

    public Warehouse(int number,String name,int capacity){
        this.number=number;
        this.name=name;
        this.capacity=capacity;
    }

    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }
    public int getCapacity(){
        return capacity;
    }
}
