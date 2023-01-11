package Traditional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-11
 * Time: 19:08
 */
public class Bottom {
    private Tire tire;

    public Bottom(int size){
        tire = new Tire(size);
    }
    public void init(){
        System.out.println("执行Bottom的init方法");
        //依赖轮胎
        tire.init();
    }
}
