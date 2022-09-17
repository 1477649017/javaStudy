/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-17
 * Time: 8:59
 */

class Singleton{
    //这个作为一个单例类，只能有一个实例
    private static Singleton instance = new Singleton();//这个就是那个唯一实例，直接赋值好

    public static Singleton getInstance() {//提供一个静态的get方法让类外能够拿到这个实例,必须是静态的，不然类外不能new对象拿不到方法
        return instance;
    }

    private Singleton(){//将构造方法私有化，使得在类外不能new实例

    }
}
public class Demo1 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();//调用方法拿到这个唯一实例
    }
}
