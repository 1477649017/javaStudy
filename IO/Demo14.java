package IO;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-09-30
 * Time: 22:09
 */
public class Demo14 {
    public static void main(String[] args) {
        //普通文件的复制
        //输入你想要复制的源文件，然后你想要复制到哪去，文件名是啥
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入源文件(路径+文件名): ");//形如 d:/test.txt
        File srcFile = new File(scan.next());
        System.out.println("请输入目标文件(路径+文件名):");//形如 d:/test2.txt
        File destFile = new File(scan.next());
        if(!srcFile.isFile()){
            System.out.println("源文件输入有误!");
            return;
        }
        if(!destFile.getParentFile().isDirectory()){
            System.out.println("目标文件输入有误!");
            return;
        }

        //打开源文件，然后按字节一个个读取，进行复制
        try(InputStream inputStream = new FileInputStream(srcFile);
        OutputStream outputStream = new FileOutputStream(destFile)){
            while (true){
                int b = inputStream.read();
                if(b == -1){
                    break;//已经读完了
                }
                outputStream.write(b);//写文件的时候就会顺便创建文件
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
