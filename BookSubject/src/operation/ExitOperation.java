package operation;

import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 18:18
 */
public class ExitOperation implements Ibookoperatortion{
    @Override
    public void doBook(BookList booklist) {
        System.out.println("退出成功！");
        System.exit(0);//0代表程序正常结束
    }
}
