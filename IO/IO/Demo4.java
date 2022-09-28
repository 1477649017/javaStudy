package IO;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-28
 * Time: 17:06
 */
public class Demo4 {
    public static void main(String[] args) {
        File file = new File("./dirCreate/aaa/bbb");
        //file.mkdir();//这是创建单层目录
        file.mkdirs();//创建多级目录
    }
}
