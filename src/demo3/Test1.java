package demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-15
 * Time: 9:42
 */
public class Test1 {
    public static Object object = new Object();
    public static Test1 test1 = new Test1();
    //wait方法是Object类的方法 而Object类是所有类的父类 所以任何类的对象都可以调用
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (object){
                System.out.println("wait开始之前");
                try {
                    test1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait开始之后");
            }
        });
        t1.start();
        t1.join();
    }
}
