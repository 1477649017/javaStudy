package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-10-01
 * Time: 10:42
 */
public class Demo15 {
    public static void main(String[] args) throws IOException {
        //首先用户输入信息
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入您想要扫描的路径: ");
        File file = new File(scan.next());
        if(!file.isDirectory()){
            System.out.println("您输入的路径有误!");
            return;
        }
        System.out.println("请输入想要扫描的关键字: ");
        String target = scan.next();
        //开始扫描路径
        scanDir(file,target);
    }

    private static void scanDir(File file, String target) throws IOException {
        //需要递归的扫描路径
        File[] ret = file.listFiles();
        if(ret == null){
            return;
        }
        for (File f:ret) {
            if(f.isDirectory()){
                //是目录就要继续往下递归
                scanDir(f,target);
            }else{
                //是文件就要开始检查
                check(f,target);
            }
        }
    }

    private static void check(File f, String target) throws IOException {
        //首先判断文件名
        if(f.getName().contains(target)){
            System.out.println("该路径 " + f.getCanonicalPath() + " 包含了关键字 " + target);
        }
        //再检查文件内容
        try(InputStream inputStream = new FileInputStream(f)){
            StringBuilder stringBuilder = new StringBuilder();
            Scanner scanner = new Scanner(inputStream);
            //利用Scanner来读取文件
            while(scanner.hasNextLine()){//按行一行行的读取文件
                stringBuilder.append(scanner.nextLine() + "\n");
            }
            if(stringBuilder.indexOf(target) > -1){
                //检查文件中是不是包含关键字
                System.out.println("该文件 " + f.getName() + "内容中包含了关键字 " + target);
            }
        }
    }
}
