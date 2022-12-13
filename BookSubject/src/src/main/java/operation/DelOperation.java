package operation;

import BookDao.BookDao;
import book.Book;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 18:08
 */
public class DelOperation implements Ibookoperatortion{
    @Override
    public void doBook() {
        System.out.println("请输入您想要删除的图书的名字>>");
        Scanner scan = new Scanner(System.in);
        String bookName = scan.nextLine();
        BookDao bookDao = new BookDao();
        bookDao.deleteBook(bookName);
    }
}
