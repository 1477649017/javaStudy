package demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-14
 * Time: 21:19
 */
class RetTest{
    public int ret = 1;
}
public class Test {
    //public static int ret = 1;
    public static RetTest Ret = new RetTest();
    public static void main(String[] args) {
        int ret = 1;
        //final int ret = 1;
        Thread t1 = new Thread(){
            @Override
            public void run() {
                //ret = 2;
                System.out.println(ret);
                //System.out.println(Ret.ret);
            }
        };

    }
}
