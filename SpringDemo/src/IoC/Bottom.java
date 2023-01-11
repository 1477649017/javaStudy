package IoC;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-11
 * Time: 21:10
 */
public class Bottom {
    private Tire tire;
    public Bottom(Tire tire){
        this.tire = tire;
    }
    public void init(){
        System.out.println("执行Bottom的init方法");
        //依赖Tire
        tire.init();
    }
}
