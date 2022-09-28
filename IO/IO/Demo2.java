package IO;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-28
 * Time: 16:45
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("./TestDemo.txt");//文件存不存不知道

        //判定一下文件是否存在
        System.out.println(file.exists());
        //判定下是不是目录
        System.out.println(file.isDirectory());
        //判定是不是文件
        System.out.println(file.isFile());

        //没有把这个文件创建出来
        file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
    }
}
