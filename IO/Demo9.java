package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-30
 * Time: 14:39
 */
public class Demo9 {
    public static void main(String[] args) throws IOException {
        //使用字符流读取数据
        Reader reader =  null;
        Reader reader1 =  null;
        try{
            reader = new FileReader("./test2.txt");
//            while(true){
//                int ret = reader.read();//一个字符一个字符的读
//                if(ret == -1){
//                    //读完了
//                    break;
//                }
//                char ch = (char)ret;
//                System.out.print(ch + " ");
//            }

            char[] ret = new char[9];
            reader.read(ret);//读取的内容放到字符数组中
            System.out.println(Arrays.toString(ret));

            reader1 = new FileReader("./test2.txt");
            char[] ret1 = new char[9];
            reader1.read(ret1,1,3);//相当于从off开始，一共读取3个字节
            System.out.println(Arrays.toString(ret1));
        }finally {
            reader.close();
        }
    }
}
