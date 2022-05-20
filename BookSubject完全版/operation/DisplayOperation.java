package operation;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 18:09
 */
public class DisplayOperation implements Ibookoperatortion{
    @Override
    public void doBook(BookList booklist) {
        System.out.println("显示成功，所有图书信息如下：");
        for( int i = 0;i < booklist.getUsedSize();i++){
            System.out.println(booklist.getBook(i));
        }
    }
}
