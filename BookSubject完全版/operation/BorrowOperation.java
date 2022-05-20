package operation;

import book.BookList;

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
    public void doBook(BookList booklist) {
        System.out.println("请输入您想要借阅的图书的名字>>");
        Scanner scan = new Scanner(System.in);
        String bookName = scan.nextLine();
        for(int i = 0;i < booklist.getUsedSize();i++){
            if(booklist.getBook(i).getName().equals(bookName)){
                if(booklist.getBook(i).isBorrowed()){
                    System.out.println("对不起，该书已经借出，请重新进行选择！");
                    return;
                }
                booklist.getBook(i).setBorrowed(true);
                System.out.println("借阅成功！");
                return;
            }
        }

    }
}
