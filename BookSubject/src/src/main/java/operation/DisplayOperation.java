package operation;

import BookDao.BookDao;
import book.Book;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 18:09
 */
public class DisplayOperation implements Ibookoperatortion{
    @Override
    public void doBook() {
        System.out.println("显示成功，所有图书信息如下：");
        BookDao bookDao = new BookDao();
        List<Book> list = bookDao.SelectAllBook();
        for( int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
