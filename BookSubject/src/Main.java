import book.Book;
import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;
import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 18:27
 */
public class Main {//进行逻辑的整合，整个程序的入口
    public static User login(){
        System.out.println("请输入你的姓名>>");
        Scanner scan1 = new Scanner(System.in);
        String name = scan1.nextLine();
        System.out.println("请选择您的身份:>> 1,管理员 0,普通用户");
        Scanner scan2 = new Scanner(System.in);
        int choice = scan2.nextInt();
        if(choice == 1){
            return new AdminUser(name);
        }else{
            return new NormalUser(name);
        }

    }
    public static void main(String[] args) {
        BookList booklist = new BookList();// new一个书架对象，走构造方法，先把默认的三本书准备好
        User user = login();
        while(true){
            int choice = user.menu();//输出菜单,进行选择
            user.doOperation(choice,booklist);
        }

    }
}
