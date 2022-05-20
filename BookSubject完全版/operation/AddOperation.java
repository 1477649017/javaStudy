package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 18:07
 */
public class AddOperation implements Ibookoperatortion{
    @Override
    public void doBook(BookList booklist) {
        System.out.println("请输入你要添加的书的名字>>");
        Scanner scan1 = new Scanner(System.in);
        String name = scan1.nextLine();

        System.out.println("请输入你要添加的书的作者>>");
        Scanner scan2 = new Scanner(System.in);
        String author = scan2.nextLine();

        System.out.println("请输入你要添加的书的价格>>");
        Scanner scan3 = new Scanner(System.in);
        int price = scan3.nextInt();

        System.out.println("请输入你要添加的书的类型>>");
        Scanner scan4 = new Scanner(System.in);
        String type = scan4.nextLine();

        Book book = new Book(name,author,price,type);//new一个book对象
        int currentSize = booklist.getUsedSize();//获取当前UsedSize
        booklist.setBook(currentSize,book);//将书放进当前的位置
        booklist.setUsedSize(currentSize + 1);//将UsedSize + 1
        System.out.println("添加成功！");
    }
}
