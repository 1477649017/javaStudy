package Traditional;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-11
 * Time: 19:08
 */

public class Tire {
    private int size;

    public Tire(int size){
        this.size = size;
    }

    public void init(){
        System.out.println("执行Tire的init方法");
        System.out.println("车的轮胎的尺寸为：" + size);
    }
}
