package Level1.Task2;



import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-12-15
 * Time: 14:52
 */
//定义一个名片类
class BusinessCard{
    public String name;
    public int age;
    public String gender;

    public BusinessCard(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
public class Test {
    //定义一个list来存储名片对象
    public static List<BusinessCard> list = new ArrayList<>();
    public static void init(){
        list.add(new BusinessCard("张三",20,"男"));
        list.add(new BusinessCard("李四",18,"男"));
        list.add(new BusinessCard("王五",22,"女"));
        list.add(new BusinessCard("赵六",29,"男"));
        list.add(new BusinessCard("钱七",20,"女"));
        list.add(new BusinessCard("张三",23,"女"));
        list.add(new BusinessCard("孙八",21,"男"));
        list.add(new BusinessCard("周九",17,"男"));
        list.add(new BusinessCard("吴十",20,"女"));
        list.add(new BusinessCard("郑帅",23,"男"));
    }

    public static void save(RandomAccessFile randomAccessFile) throws IOException {
        for(int i = 0;i < list.size();i++){
            BusinessCard businessCard = list.get(i);//拿到这个对象
            try {
                randomAccessFile.writeUTF(businessCard.name);//写入字符串信息
                randomAccessFile.writeInt(businessCard.age);
                randomAccessFile.writeUTF(businessCard.gender);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        randomAccessFile.close();
    }

    private static void load(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile = new RandomAccessFile("card.txt","r");
        while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {
            String name = randomAccessFile.readUTF();
            int age = randomAccessFile.readInt();
            String gender = randomAccessFile.readUTF();
            System.out.println("姓名：" + name + "，年龄：" + age + "，性别：" + gender);
        }
        randomAccessFile.close();
    }
    public static void main(String[] args) throws IOException {
        init();
        //开始将list中存储的信息进行打乱
        Collections.shuffle(list);
        //存入文件 利用RandomAccessFile
        RandomAccessFile randomAccessFile = new RandomAccessFile("card.txt","rw");
        save(randomAccessFile);
        load(randomAccessFile);
    }
}
