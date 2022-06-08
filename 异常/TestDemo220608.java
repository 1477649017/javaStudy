import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-08
 * Time: 10:18
 */
class Person implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class TestDemo220608 {
    public static void func(){
        String s1 = null;
        s1.length();
    }
    public static void main(String[] args) {
        try{
            func();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void main4(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
//            这是可能会发生异常的程序主体
            String s1 = null;
            s1.length();
        }
        catch (NullPointerException e) {
//            这是对异常进行捕获并实际处理的部分
            e.printStackTrace();//将异常信息输出
            System.out.println("捕捉到一个空指针异常进行处理！");
            return;
        }finally{
            scan.close();
            System.out.println("在finally进行资源的关闭！");
        }
        System.out.println("这是其余的代码逻辑！");
    }
    public static void main3(String[] args) {
        try{
            Person p1 = new Person();
            Person p2 = (Person)p1.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    public static void main2(String[] args) {
        String s1 = null;
        try{
//            这是可能会发生异常的程序主体
            s1.length();
            System.out.println("hahahaha");
        }
        catch (NullPointerException e) {
//            这是对异常进行捕获并实际处理的部分
            e.printStackTrace();//将异常信息输出
            System.out.println("捕捉到一个空指针异常进行处理！");
        }catch (ArithmeticException e1) {
            e1.printStackTrace();
            System.out.println("捕获到一个算数异常进行处理！");
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println("捕捉到了除算数异常，空指针异常外的其他异常！");
        }
        System.out.println("这是其余的代码逻辑！");
    }
    public static void func(int a) throws Exception {
        if(a == 0){
            throw new CloneNotSupportedException();
        }
        if(a == 1){
            throw new FileNotFoundException();
        }
    }
    public static void main1(String[] args) throws Exception {
        int a = 0;
        func(a);
        System.out.println("这是异常后的逻辑部分");
    }
}
