package IO;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-28
 * Time: 16:15
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //文件到底存不存在不影响构造File对象
        //File file = new File("D:/test.txt");//这里的路径用绝对路径或者是相对路径都可以
        File file = new File("./test.txt");
        System.out.println(file.getParent());//获取File对象父目录路径
        System.out.println(file.getName());//获取File对象文件名称
        System.out.println(file.getPath());//获取File对象的文件路径
        System.out.println(file.getAbsoluteFile());//获取File对象的绝对路径
        System.out.println(file.getCanonicalFile());//获取File对象的修饰过的绝对路径

    }
}
