package operation;

import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 18:13
 */
public class ReturnOperation implements Ibookoperatortion{
    @Override
    public void doBook(BookList booklist) {
        System.out.println("请输入您想要归还的图书的名字>>");
        Scanner scan = new Scanner(System.in);
        String bookName = scan.nextLine();
        for(int i = 0;i < booklist.getUsedSize();i++){
            if(booklist.getBook(i).getName().equals(bookName)){
                booklist.getBook(i).setBorrowed(false);
                System.out.println("归还成功！");
                return;
            }
        }

    }
}
