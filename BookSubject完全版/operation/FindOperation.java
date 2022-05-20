package operation;

import book.BookList;

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
    public void doBook(BookList booklist) {
        System.out.println("请输入您想要查找的图书的名字>>");
        Scanner scan = new Scanner(System.in);
        String bookName = scan.nextLine();
        int i;
        for( i = 0;i < booklist.getUsedSize();i++){
            if(booklist.getBook(i).getName().equals(bookName)){
                System.out.println("查找成功,图书信息如下：");
                System.out.println(booklist.getBook(i));
                break;
            }
        }
        if(i == booklist.getUsedSize()){
            System.out.println("经过查找，该书不存在！");
        }

    }
}
