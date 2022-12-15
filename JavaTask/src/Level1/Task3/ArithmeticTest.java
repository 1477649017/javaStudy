package Level1.Task3;

import java.util.Random;
import java.util.Scanner;

//算数运算测试
//规定 十道题 一道十分 满分100分
public class ArithmeticTest {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int score = 0;//用来统计最后的分数结果
        System.out.println("开始计算题目>>");
        for(int i = 0;i < 10;i++){
            //生成运算数
            int num1 = random.nextInt(100);//生成[0,100)的整数
            int num2 = random.nextInt(100);
            //生成运算符
            String[] operator = new String[]{"+","-"};
            int index = random.nextInt(2);
            int ret = 0;//用来保存计算结果
            if(operator[index].equals("+")){
                System.out.print(num1  + " + " + num2 + " = >请输入结果: " );
                ret = num1 + num2;
                int userRet = scanner.nextInt();
                if(ret == userRet){
                    System.out.println("回答正确,加10分!");
                    score += 10;
                }else{
                    System.out.println("回答错误,不计分!");
                }
            }else{
                System.out.print(num1  + " - " + num2 + " = >请输入结果: " );
                ret = num1 - num2;
                int userRet = scanner.nextInt();
                if(ret == userRet){
                    System.out.println("回答正确,加10分!");
                    score += 10;
                }else{
                    System.out.println("回答错误,不计分!");
                }
            }
        }

        System.out.println("===============");
        System.out.println("最终得分：" + score);
    }
}
