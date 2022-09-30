package IO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-30
 * Time: 21:22
 */
public class Demo13 {
    public static void main(String[] args) throws IOException {
        //1,用户输入信息
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你想要扫描的路径: ");
        String path = scan.next();
        File file = new File(path);//建立File对象，进行文件系统的操作
        if(!file.isDirectory()){
            //如果输入路径都不是目录，那么则判定输入操作
            System.out.println("您的路径输入有误！");
        }
        //如果是目录，则去进行扫描
        System.out.println("请输入你想要搜索的关键字: ");
        String target = scan.next();
        scanDir(file,target);
    }

    private static void scanDir(File file, String target) throws IOException {
        //进行扫描的时候需要借助一个方法listFiles(),它可以列出当前目录下的文件和子目录，但是不能列出子目录的子目录
        File[] ret = file.listFiles();
        System.out.println("当前所在目录: " + file.getCanonicalPath());
        if(ret == null){
            //如果扫描结果为空，就说明当前目录下不存在文件
            return;
        }
        //如果不是空，就一个个检查
        for (File f:ret) {
            if(f.isDirectory()){
                //如果当前元素是目录，那就要继续往下递归搜索
                scanDir(f,target);
            }else{
                //如果是文件，那就可以直接检查是否包含关键字
                check(f,target);
            }
        }
    }

    private static void check(File f, String target) throws IOException {
        if(f.getName().contains(target)){
            //如果文件名字中包含关键字
            System.out.println("该文件名" + f.getCanonicalPath() + " 中包含了关键字 " +target + ",是否要进行删除? <Y/N>");
            Scanner scan = new Scanner(System.in);
            String choice = scan.next();
            if(choice.equals("Y") || choice.equals("y")){
                f.delete();//进行删除
                System.out.println("删除成功！");
            }
        }
    }
}
