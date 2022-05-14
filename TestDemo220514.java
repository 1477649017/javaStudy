public class TestDemo220514 {
    static int cnt = 6;
    public int tmp = 1;
    {
        tmp = 10;
        System.out.println(tmp);
    }
    static{
        System.out.println("调用静态代码块1");
        cnt += 9;
    }
    {
        System.out.println("调用实例代码块");
    }
    public void func(){
        System.out.println("调用实例的方法");
    }
    public TestDemo220514(){
        System.out.println("调用构造方法");
    }
    public static void main(String[] args) {
        System.out.println("调用主函数");
        TestDemo220514 test = new TestDemo220514();
        test.func();
        System.out.println(cnt);
        TestDemo220514.func1();
    }
    static{
        System.out.println("调用静态代码块2");
        cnt /= 3;
    }
    public static void func1(){
        System.out.println("加载静态的方法");
        cnt += 2;
    }
}
