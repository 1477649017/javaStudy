package IO;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-30
 * Time: 14:12
 */
public class Demo8 {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = null;
        try{
            //打开文件，在进行写入之前，会把文件内容先清空
            outputStream = new FileOutputStream("./test2.txt");
//            outputStream.write(97);//代表的ASCII码值，字符在硬盘上就是这么存储的
//            outputStream.write(98);
//            outputStream.write(99);

            byte[] b = new byte[]{97,98,99,100,101};
            outputStream.write(b);
            outputStream.write(b,1,4);//左闭右闭的区间范围

            outputStream.flush();//刷新一下缓冲区，保证缓冲区中所有的内容都会被写入到文件中

        }finally {
            outputStream.close();//确保能够关闭流
        }
    }
}
