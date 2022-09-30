package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-30
 * Time: 15:08
 */
public class Demo10 {
    public static void main(String[] args) throws IOException {
        Writer writer = null;
        try{
            writer = new FileWriter("./test2.txt");
            String s = "Java is the best programing language in the world!";
//            writer.write(s);

            //writer.write(97);//写入一个字符

            char[] ch = new char[]{'a','b','c'};
            writer.write(ch);//将字符数组的内容写入

            writer.write(ch,0,3);//范围型写入
            writer.write(s,0,3);


        }finally {
            writer.close();
        }
    }
}
