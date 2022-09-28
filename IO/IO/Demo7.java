package IO;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-28
 * Time: 20:27
 */
public class Demo7 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("./test2.txt");//打开文件
        while(true){
            int b = inputStream.read();
            if(b == -1){
                break;
            }
            System.out.print(b +" ");
        }
        inputStream.close();//关闭流
    }
}
