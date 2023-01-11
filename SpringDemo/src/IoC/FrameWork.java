package IoC;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-11
 * Time: 21:10
 */
public class FrameWork {
    private Bottom bottom;
    public FrameWork(Bottom bottom){
        this.bottom = bottom;
    }
    public void init(){
        System.out.println("执行FrameWork的init方法");
        //依赖Bottom
        bottom.init();
    }
}
