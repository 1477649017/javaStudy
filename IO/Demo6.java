import java.io.File;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-28
 * Time: 19:48
 */
public class Demo6 {
    public static void main(String[] args) {
        File file = new File("./dirCreate");
        String[] ret = file.list();//返回当前file对象代表的目录下的所有文件
        System.out.println(Arrays.toString(ret));
    }
}
