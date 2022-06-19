/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-22
 * Time: 21:29
 */
import java.lang.Math;
class Base implements {

    private int x;
    private int y;

    public Base(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final int sum() {
        return getX() + getY();
    }

}

class Sub extends Base {

    public Sub(int x, int y) {
        super(x, y);
    }


}
public class TestDemo {

    public static void main(String[] args) {
    }
}
