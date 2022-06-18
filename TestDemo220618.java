import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-06-18
 * Time: 21:08
 */

class myloginException extends RuntimeException{
    public myloginException(String message) {
        super(message);
    }
}
public class TestDemo220618 {
    public static void islegal(String password){
        if(password.length() > 5){
            throw new myloginException("用户名超过长度限制！");
        }else{
            System.out.println("登录成功！");
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("请输入用户密码：");
            String password = scan.nextLine();
            islegal(password);
        }catch (myloginException e) {
            e.printStackTrace();
        }

    }
}
