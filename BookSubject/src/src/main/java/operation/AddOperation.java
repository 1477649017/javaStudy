package operation;

import BookDao.BookDao;
import book.Book;


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
    public void doBook() {
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

        Book book = new Book(name,author,price,type,false);//new一个book对象
        BookDao bookDao = new BookDao();
        bookDao.insertBook(book);

    }
}
