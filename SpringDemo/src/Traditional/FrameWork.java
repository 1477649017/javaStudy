package Traditional;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-11
 * Time: 19:08
 */
public class FrameWork {
    private Bottom bottom;
    public FrameWork(int size){
        bottom = new Bottom(size);
    }
    public void init(){
        System.out.println("执行FrameWork的init方法");
        //依赖底盘
        bottom.init();
    }
}
