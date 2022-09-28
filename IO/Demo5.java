import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-28
 * Time: 17:11
 */
public class Demo5 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("./test1.txt");
        File file2 = new File("./test2.txt");
        file1.renameTo(file2);//现在是没有什么效果的，因为文件都还不存在
        file1.createNewFile();//创建文件
        file1.renameTo(file2);//改名
    }
}
