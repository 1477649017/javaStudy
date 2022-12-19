#  Acwing算法--动态规划

#  一，背包问题

***

##  1.1，0 1背包问题

> 特点：每件物品都有一定的价值，每件物品最多使用一次，在背包体积一定的情况下，求取所能取得的物品的价值最大化。 

***

>我们解决DP的问题，重点抓住两个点，状态的定义以及状态的计算(状态转移方程)，下面以 0 1背包问题举例来进行分析：
>
>![image-20221219102644138](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221219102644138.png) 
>
>![image-20221219102704087](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221219102704087.png) 
>
>***
>
>**这里要额外注意一个点，对于上面划分出的两个子集，包含第i个物品这一集不是一定存在的，必须满足背包容量j 要大于第i件物品的体积v ,也就是说j - v >= 0。**

>例题：
>
>![image-20221219113855085](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221219113855085.png) 

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//物品种数
        int v = scan.nextInt();//背包体积
        //利用数组保存每个物品的价值和体积
        int[] V = new int[n + 1];//存储物品体积的数组
        int[] W = new int[n + 1];//存储物品价值的数组
        for(int i = 1;i <= n;i++){
            V[i] = scan.nextInt();
            W[i] = scan.nextInt();
        }
        
        int[][] dp = new int[n + 1][v + 1];
        //多出一行一列 当i = 0 j= 0 的时候最大价值应该都是0 所以也不需要进行特别的初始化
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= v;j++){
                dp[i][j] = dp[i-1][j];//不取第i件物品
                if(j >= V[i]){
                    //取第i件物品
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j - V[i]] + W[i]);
                }
            }
        }，
        System.out.println(dp[n][v]);
    }
}
```

****

##  1.2，完全背包问题

> 完全背包问题，相对于0 1背包问题，完全背包问题的特殊点就在于物品使用次数是不限制的，求的是在背包的体积一定的情况下，各种物品使用次数不限制，然后选取物品装入的价值最大化。

>还是和上面一样，现在分析状态的定义以及状态计算：
>
>![image-20221219142705198](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221219142705198.png) 
>
>![image-20221219142718707](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221219142718707.png) 

> 例题：
>
> ![image-20221219142807432](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221219142807432.png) 

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//物品种数
        int v = scan.nextInt();//背包容量
        int[] V = new int[n+1];
        int[] W = new int[n+1];
        for(int i = 1;i <= n;i++){
            V[i] = scan.nextInt();
            W[i] = scan.nextInt();
        }
        
        int[][] dp = new int[n+1][v+1];
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= v;j++){
                for(int k = 0;k*V[i] <= j;k++){ //遍历枚举k的取值 也即是第i件物品使用次数 条件是不能超过了背包的容量
                    dp[i][j] = Math.max(dp[i][j] , dp[i-1][j - k*V[i]] + k*W[i]);
                }
            }
        }
        System.out.println(dp[n][v]);
    }
}
```

***

> 对于完全背包问题，上面的这种方法可以解决问题，但是三层for循环无疑时间复杂度有点高，下面我们将其进行优化：
>
> ![image-20221219165114194](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221219165114194.png)  

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//物品种数
        int v = scan.nextInt();//背包容量
        int[] V = new int[n+1];
        int[] W = new int[n+1];
        for(int i = 1;i <= n;i++){
            V[i] = scan.nextInt();
            W[i] = scan.nextInt();
        }
        
        int[][] dp = new int[n+1][v+1];
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= v;j++){
                //将dp[i][j] 优化后就只与两个状态值有关了 不需要再多加一层for循环
                dp[i][j] = dp[i-1][j];
                if(j - V[i] >= 0){
                    dp[i][j] = Math.max(dp[i][j],dp[i][j - V[i]] + W[i]);
                }
            }
        }
        System.out.println(dp[n][v]);
    }
}
```

