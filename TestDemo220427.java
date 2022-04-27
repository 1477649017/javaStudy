/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-04-27
 * Time: 9:32
 */
import java.util.Scanner;
import java.lang.Math;
public class TestDemo220427 {

    public static void myprint(int num){
        if(num < 10){
            System.out.println(num%10);
            return;
        }
        myprint(num/10);
        System.out.println(num%10);
        return;
    }
    public static int mySum(int num){
        if(num < 10){
            return num;
        }
        return num%10 + mySum(num/10);
    }
    public static void main(String[] args) {
//        递归实现按顺序打印数字的每一位
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scan.nextInt();
        //myprint(num);
        int ret = mySum(num);
        System.out.println(ret);
    }
    public static  int func(int num){
        if(num == 1){
            return 1;
        }
        return num*func(num - 1);
    }
    public static void main8(String[] args) {
//        递归求阶乘
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scan.nextInt();
        int ret = func(num);
        System.out.println("阶乘为：" + ret);
    }
    public static void main7(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scan.nextInt();
        if((num & (num-1)) == 0){
            System.out.println("是2的k次方数！");
        }else{
            System.out.println("不是2的k次方数！");
        }
    }
    public static int getOnecount(int num){
        int count = 0;
        while(num != 0){
            num = num&(num-1);
            count++;
        }
        return count;
    }
    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scan.nextInt();
        int ret =  getOnecount(num);
        System.out.println(num + "的二进制位中1的个数 ：" + ret);
    }
    public static boolean isNarnum(int num,int count){
        int sum = 0;
        int tmp = num;
        while(tmp != 0){
            sum += Math.pow(tmp%10,count);
            tmp /= 10;
        }
        if(sum == num){
            return true;
        }else{
            return false;
        }
    }
    public static void main5(String[] args) {
//        判断一个数是不是自幂数
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scan.nextInt();
        int count = 0;
        int tmp = num;
        while(tmp != 0){
            count++;
            tmp /= 10;
        }
        boolean ret = isNarnum(num,count);
        if(ret == true){
            System.out.println(num + "是一个" + count +"位自幂数！");
        }else{
            System.out.println(num + "不是自幂数！");
        }
    }
    public static void main4(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        for(int i = 1;i > 0;i++){
            if((a*i)%b == 0){
                System.out.println("最小公倍数：" + a*i);
                break;
            }
        }
    }
    public static boolean isleapYear(int year){
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            return true;
        } else{
            return false;
        }
    }
    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scan.nextInt();
        boolean ret = isleapYear(year);
        if(ret == true){
            System.out.println(year + "是闰年！");
        }else{
            System.out.println(year + "不是闰年！");
        }
    }
    public static void main2(String[] args) {
//        这里以求取1~100之间的素数为例
        for(int i = 1;i <= 100;i += 2){//从1开始,产生到100的奇数
            int flg = 1;//假设是素数
            if(i == 1){
                System.out.println((i+1) + "是素数！");//2这里需要单拎出来考虑，比较特殊
                continue;
            }
            for(int j = 2;j <= (int)(Math.sqrt(i));j++){
                if(i%j == 0){
                    flg = 0;
                }
            }
            if(flg == 1){
                System.out.println(i + "是素数！");
            }
        }
    }
    public static int findSingle_dog(int[] arr,int[] dog,int len){
//        进行排序
        for (int i = 0; i < len - 1; i++) {
            for(int j = 0;j < len - i - 1;j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
//        找单身狗
        int i = 0;
        int k = 0;
        while(i < len){
            if(arr[i] - arr[i + 1] == 0){
                i += 2;
            }else{
                dog[k] = arr[i];
                i += 1;
                k++;
                if(k == 2){
                    break;
                }
            }
        }
        return k;
    }
    public static void main1(String[] args) {
//        找出单身狗
        int[] arr = {1,1,3,3,2,6,8,8};
        int len = arr.length;
        int[] dog = new int[10];
        int ret = findSingle_dog(arr,dog,len);
        System.out.println("找到的单身狗，只出现一次的数为：");
        for(int j = 0;j < ret;j++){
            System.out.print(dog[j] + " ");
        }
    }
}
