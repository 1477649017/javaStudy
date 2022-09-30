package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-30
 * Time: 17:34
 */
public class Demo12 {
    public static void main(String[] args) throws IOException {
        //针对写文本文件来说，还可以使用PrintWriter来简化
        try(OutputStream outputStream = new FileOutputStream("./test2.txt")){
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("Java");
            printWriter.flush();//不要忘记刷新缓冲区，不然不会写入到文件中
        }
    }
}
