package operation;

import BookDao.BookDao;
import book.Book;


import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 18:12
 */
public class BorrowOperation implements Ibookoperatortion{
    @Override
    public void doBook() {
        System.out.println("请输入您想要借阅的图书的名字>>");
        Scanner scan = new Scanner(System.in);
        String bookName = scan.nextLine();
        BookDao bookDao = new BookDao();
        Book book = bookDao.SelectOneBook(bookName);
        if(book.isBorrowed()){
            System.out.println("该书已经借出,无法进行借阅!");
        }else {
            System.out.println("借阅成功!");
            //修改数据库信息
            bookDao.updateInfo(bookName,"true");
        }
    }
}
