package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-30
 * Time: 17:28
 */
public class Demo11 {
    public static void main(String[] args) throws IOException {
        //利用Scanner简化读取文本文件
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream("./test2.txt");
            Scanner scan = new Scanner(inputStream);
            while(scan.hasNext()){//hasNext()不读空格
                System.out.print(scan.next());
            }
        } finally {
            inputStream.close();
        }
    }
}
