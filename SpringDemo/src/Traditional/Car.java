package Traditional;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-11
 * Time: 19:08
 */

public class Car {
    private FrameWork frameWork;
    public Car(int size){
        frameWork = new FrameWork(size);//创建一个车身对象
    }
    public void init(){
        System.out.println("执行Car的init方法");
        //需要依赖车身
        frameWork.init();
    }
}
