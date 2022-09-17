/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-17
 * Time: 9:37
 */

class SingletonLazy{
    //懒汉模式实现单例模式
    private volatile static SingletonLazy instance = null;//这里没有马上new对象

    public static SingletonLazy getInstance() {
        if(instance == null){
            synchronized (SingletonLazy.class){//锁对象是类对象
                if(instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    private SingletonLazy(){};
}
public class Demo2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            SingletonLazy instance = SingletonLazy.getInstance();
            System.out.println(instance);
        });

        Thread t2 = new Thread(()->{
            SingletonLazy instance = SingletonLazy.getInstance();
            System.out.println(instance);
        });

        t1.start();
        t2.start();
    }
}
