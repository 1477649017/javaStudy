package user;

import operation.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 18:25
 */
public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        this.ioperation = new Ibookoperatortion[]{
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }

    public int menu(){
        System.out.println(this.name + " 你好~，欢迎使用图书管理系统！");
        System.out.println("1,查找图书>>");
        System.out.println("2,借阅图书>>");
        System.out.println("3,归还图书>>");
        System.out.println("0,退出系统>>");
        System.out.println("请您进行操作的选择>>");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        return choice;
    }

}
