package operation;

import BookDao.BookDao;
import book.Book;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 18:06
 */
public class FindOperation implements Ibookoperatortion{
    @Override
    public void doBook() {
        System.out.println("请输入您想要查找的图书的名字>>");
        Scanner scan = new Scanner(System.in);
        String bookName = scan.nextLine();
        BookDao bookDao = new BookDao();
        Book book = bookDao.SelectOneBook(bookName);
        if(book == null){
            System.out.println("抱歉! 您查找的书籍不存在");
        }else{
            System.out.println("查询到图书，信息如下：");
            System.out.println(book);
        }
    }
}
