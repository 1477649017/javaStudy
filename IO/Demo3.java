import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-28
 * Time: 16:58
 */
public class Demo3 {
    public static void main(String[] args) {
        //删除文件
        File file = new File("./TestDemo.txt");
        file.delete();
        //file.deleteOnExit();//进程退出时删除文件
    }
}
