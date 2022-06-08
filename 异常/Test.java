import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-08
 * Time: 15:41
 */
class myException extends RuntimeException{
    public myException() {
    }

    public myException(String message) {
        super(message);//可能会需要输出异常的具体信息，所以要有一个有参的构造
    }
}

public class Test {
    public static void isLegal(String s){
        if(s.length() > 5){
            throw new myException("用户名长度超过限制！");
        }else{
            System.out.println("登录成功！");
        }
    }
    public static void main(String[] args) {
        //    模拟设置用户名中的异常
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        try{
            isLegal(s);
        }catch (myException e){
            e.printStackTrace();
        }finally {
            scan.close();
        }

    }

}
