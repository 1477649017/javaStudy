#  Java 实现几大基础问题(必会)

#  一，素数求解的n种境界

##  1.1，暴力循环求解

```
public class TestDemo220427 {
    public static void main(String[] args) {
//        这里以求取1~100之间的素数为例
        for(int i = 2;i <= 100;i++){//素数从2开始,所以从2开始产生到100的数
            int flg = 1;//假设是素数
            for(int j = 2;j < i;j++){
                if(i%j == 0){
                    flg = 0;
                }
            }
            if(flg == 1){
                System.out.println(i + "是素数！");
            }
        }
    }
}
```

****

##  1.2，试除前一半数

````
public class TestDemo220427 {
    public static void main(String[] args) {
//        这里以求取1~100之间的素数为例
        for(int i = 2;i <= 100;i++){//素数从2开始,所以从2开始产生到100的数
            int flg = 1;//假设是素数
            for(int j = 2;j < i/2;j++){
                if(i%j == 0){
                    flg = 0;
                }
            }
            if(flg == 1){
                System.out.println(i + "是素数！");
            }
        }
    }
}
````

**可以发现，我们一个数都是可以拆成两个数的乘法的，比如 16：可以是 1* 16,2 * 8，4*4，可以看到，前半部分的数都是小于其自身的一半的，所以我们只需要检测这前半部分数能否被其自身整除了，因为只要前半部分有的话，后半部分肯定有一个数与之对应相乘能够得到自身，所以这就又减少了一半的工作量。**

****

##  1.3，试除小于自身开根号的数

```
import java.lang.Math;
public class TestDemo220427 {
    public static void main(String[] args) {
//        这里以求取1~100之间的素数为例
        for(int i = 2;i <= 100;i++){//素数从2开始,所以从2开始产生到100的数
            int flg = 1;//假设是素数
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
}
```

**还是刚才差不多的原理，只不过把范围又缩小了，因为一个数拆分成两个数的乘积的形式的话，前面的那个数不仅仅只是小于其自身的一半，其实根本上是不可能大于其开平方的值的，就比如16，其实前半部分的数不会大于4，因为大于4后可以看到不可能会有某个数能够与另一个数乘了等于16了，当然2 * 8，8 * 2这只算前面一种就好了**

****

##  1.4，在奇数中寻找

````
import java.lang.Math;
public class TestDemo220427 {
    public static void main(String[] args) {
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
}
````

**我们知道，除了2这个特例，所有的偶数不可能是素数，因为最起码就能够被2整除，所以在范围内进行考虑的时候，就只需要检测奇数就好了，就把外层循环的次数减少了。**

**其实还有方法可以继续优化，这里就不再给大家一一列举了，如果大家有兴趣的话可以去查查，很多博主写的很详细深入！**

****



#  二，闰年问题

```
public class TestDemo220427 {
    public static boolean isleapYear(int year){
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            return true;
        } else{
            return false;
        }
    }
    public static void main(String[] args) {
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
}
```

**这里就只需要知道闰年的判断标准就可以很好的把题解出来。**

****



#  三，求最大公约数以及最小公倍数

##  3.1，求最大公约数

```
import java.util.Scanner;
public class TestDemo220427 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int m = 0;
        while((m = a%b) != 0){//辗转相除法
            a = b;
            b = m;
        }
        System.out.println(b);
    }
}
```

****

##  3.2，求最小公倍数

````
````

```
import java.util.Scanner;
public class TestDemo220427 {
    public static void main(String[] args) {
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
}
```

****

**其实还有一个公式，假设最大公约数是m，则最小公倍数是 (a*b)/m。**

#  四，自幂数问题

````
import java.lang.Math;
public class TestDemo220427 {
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
    public static void main(String[] args) {
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
}
````

****



#  五，统计二进制位中1的个数

##  5.1，循环右移按位与1

````
import java.util.Scanner;
public class TestDemo220427 {
    public static int getOnecount(int num){
        int count = 0;
        while(num != 0){//右移后不为0就继续统计
            if((num& 1) == 1){
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scan.nextInt();
        int ret =  getOnecount(num);
        System.out.println(num + "的二进制位中1的个数 ：" + ret);
    }
}
````

****

**注意：这段代码是有bug的，因为对于负数是统计不了的，负数的二进制最高符号位为1，右移补符号位那就是一直在高位补1，那循环就死循环了。**

**解决方法：num = num >> 1 ===》 改成 num = num >>> 1，用无符号右移，这样高位就只会补0，对于正数负数都适用。**



**拓展：可能有人会问，既然可以右移，那为啥不能左移？**
**答案是 ： 确实可以左移，但是不推荐，效率太低。**

````
public class TestDemo220427 {
    public static int getOnecount(int num){
        int count = 0;
        for(int i = 0;i < 32;i++){
            if((num & (1 << i)) != 0){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scan.nextInt();
        int ret =  getOnecount(num);
        System.out.println(num + "的二进制位中1的个数 ：" + ret);
    }
}
````

这个时候就不是把这个数去左移了，而是把1左移，然后去与这个数按位与，因为这样的结果就只有可能是0或者非0，非0就表示1左移后的结果的1所在的位置对应的这个数的位置上是1，所以这个时候就统计一下。这样也可以解决问题，但是你必须得左移32次，因为你不知道这个数前面到底有多少1，只能所有的都比对完。

*****

##  5.2，n &(n-1)消除1的原理

```
import java.util.Scanner;
public class TestDemo220427 {
    public static int getOnecount(int num){
        int count = 0;
        while(num != 0){
            num = num&(num-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scan.nextInt();
        int ret =  getOnecount(num);
        System.out.println(num + "的二进制位中1的个数 ：" + ret);
    }
```

这种方法正数负数都可以用，并且效率很高，每次按位与num-1 一次，就会消掉一个1。



扩展：用这个方法判断某一个数是不是2的k次方。

````
import java.util.Scanner;
public class TestDemo220427 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scan.nextInt();
        if((num & (num-1)) == 0){
            System.out.println("是2的k次方数！");
        }else{
            System.out.println("不是2的k次方数！");
        }
    }
}
````

