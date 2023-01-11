package IoC;



/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-11
 * Time: 21:10
 */
public class Car {
    private FrameWork frameWork;
    public Car(FrameWork frameWork){
        this.frameWork = frameWork;
    }
    public void init(){
        System.out.println("执行Car的init方法");
        //依赖FrameWork
        frameWork.init();
    }
}
