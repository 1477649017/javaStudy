#  笔试强训--day01

##  一，选择题

1，

![image-20221012162706168](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221012162706168.png) 

***

![image-20221012162734269](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221012162734269.png) 

***

方法注意是存储在方法区，方法里面的局部变量是存储在栈上。

***

##  二，编程题

[组队竞赛](https://www.nowcoder.com/questionTerminal/6736cc3ffd1444a4a0057dee89be789b?orderByHotValue=1&page=1&onlyReference=false)

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            int n = scan.nextInt();
            int[] arr = new int[3*n];
            for(int i = 0;i < arr.length;i++){
                arr[i] = scan.nextInt();
            }
            Arrays.sort(arr);
            long sum = 0;
            for(int i = 0;i < n;i++){
                sum += arr[arr.length - 2*(i+1)];
            }
            System.out.println(sum);
        }
    }
}
```

利用贪心算法。理解起来也比较容易，你把数组排序之后，那么如果想要每一组的均值都最大，那肯定是倒数第一，倒数第二分一组，这样这一组中间值就是倒数第二个数，这样同理，倒数第四个数就是第二组的最大中间值。

***

[删除公共字符](https://www.nowcoder.com/practice/f0db4c36573d459cae44ac90b90c6212?tpId=85&&tqId=29868&rp=1&ru=/activity/oj&qru=/ta/2017test/question-ranking)

```java
import java.util.Scanner;
import java.util.HashMap;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        //可以利用哈希的思想
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        //遍历s2，把字符出现次数统计一下
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s2.length();i++){
            if(s2.charAt(i) == ' '){
                continue;//如果空格，直接跳过
            }
            if(map.get(s2.charAt(i)) == null){//这里你是去直接取值了，当键不存在，值肯定是null，所以不能与0比较
                map.put(s2.charAt(i),1);
            }else{
                int val = map.get(s2.charAt(i));
                map.put(s2.charAt(i),val + 1);
            }
        }

        String ret = "";
        for(int i = 0;i < s1.length();i++){
            if(map.get(s1.charAt(i)) == null){
                //说明s1的这个字符在s2中是不存在的
                ret += s1.charAt(i);
            }
        }
        System.out.println(ret);
    }
}
```

这个题的方法还有一些，不过大体思路都是一样的。遍历，查看是否在s2中存在，然后不存在的字符就拼接起来。

***

