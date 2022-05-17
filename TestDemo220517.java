package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-17
 * Time: 14:21
 */
abstract class Sheap{
    public int sheapName;
    public static  void func(){

    }
    public abstract void draw();
}
class Circle extends Sheap{
    @Override
    public void draw() {
        System.out.println("画一个圆！");
    }

}
public class TestDemo220517 {
    public static void main(String[] args) {
    }
}
