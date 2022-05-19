package operation;

import book.Book;
import book.BookList;

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
    public void doBook(BookList booklist) {
        System.out.println("请输入您想要删除的图书的名字>>");
        Scanner scan = new Scanner(System.in);
        String bookName = scan.nextLine();
        int set = 0;//先找到你要删除的书的位置
        for(int i = 0;i < booklist.getUsedSize();i++){
            if(booklist.getBook(i).getName().equals(bookName)){
                set = i;
            }
        }
        for(int j = set;j < booklist.getUsedSize() - 1;j++){
            Book tmpBook = booklist.getBook(j+1);
            booklist.setBook(j,tmpBook);
        }

        int currentSize = booklist.getUsedSize();
        booklist.setUsedSize(currentSize - 1);
        System.out.println("删除成功！");
    }
}
