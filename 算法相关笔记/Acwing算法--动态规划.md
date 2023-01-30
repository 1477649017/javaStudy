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

***

> 0 1背包问题进行优化：
>
> 对于0 1背包问题而言，我们还可以将其优化为一个一维的问题，也就是使用一个一维数组来进行计算。
>
> 没有优化之前，状态转移方程：F(i , j) = Max( F(i-1 , j) ,F(i-1 , j - V[i]) + W[i] )，从这里可以看到，其实F(i , j)是根据第 i-1件物品的状态值转移计算过来的，所以其实我们可以只使用一个一维数组，然后每一次的计算都在其前一个物品的所得到的一维数组上面进行计算修改就好了。你可以理解成原来是二维数组，现在每次计算都把上一行的值拷贝下来，然后在上面进行计算修改，这样整个过程就只涉及到一个一维数组，这样的数组也叫做滚动数组。最后的状态转移方程：**F(j) = Max(F(j) , F( j - V[i]) + W[i])**   j表示的还是容量大小
>
> 我们以上面的题来进行过程的分析：
>
> |       | 体积 | 价值 |
> | ----- | ---- | ---- |
> | 物品1 | 1    | 2    |
> | 物品2 | 2    | 4    |
> | 物品3 | 3    | 4    |
> | 物品4 | 4    | 5    |
>
> ***
>
> ![image-20221220151412339](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221220151412339.png) 
>
> 其实通过图示可以发现，说到底两种方法是没有区别的，只不过二维的方式是上一次的结果是单独在一行存储着，但是对于一维的解法来说，就只是在一个数组中进行修改，数组中每次就会保存着上次的结果。参照二维来讲，这里的F(j)就是F(i-1,j)，F(j - V[i]) + W[i]就是F(i-1,j - V[i]) + W[i]，在一个新的i的时候，数组中保存的就是上一次i-1的结果，所以这里可以从二维降到一维。
>
> 不过要注意，既然是只使用一个一维数组进行保存结果，然后下次会利用上次的值，所以不像二维那样，两次的运算数值之间不会存在有啥干扰，因为只有一个数组保存，你在这次计算的时候可能会把之前的值给覆盖掉，那么最后肯定是有问题的。对于这种会覆盖掉上一次的值的问题，我们的解决办法就是从后往前遍历，也就是F(5) -> F(0) 这么逆序的计算，就不会涉及到覆盖值的问题。
>
> 比如，正序遍历计算：
>
> ![image-20221220154354967](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221220154354967.png)  

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//物品数量
        int v = scan.nextInt();//背包体积
        //利用数组保存每个物品的价值和体积
        int[] V = new int[n + 1];//存储物品体积的数组
        int[] W = new int[n + 1];//存储物品价值的数组
        for(int i = 1;i <= n;i++){
            V[i] = scan.nextInt();
            W[i] = scan.nextInt();
        }
     
        int[] dp = new int[v+1];//浪费一个位置 让下标可以直接和背包容量对应起来
        for(int i = 1;i <= n;i++){
            for(int j = v;j >= V[i];j--){ //倒序计算的时候发现 j - V[i] < 0了就可以不用继续让j--计算了
                dp[j] = Math.max(dp[j] , dp[j - V[i]] + W[i]);
            }
        }
        System.out.println(dp[v]);
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
> ![image-20221220165647268](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221220165647268.png)   

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

***

>同理0 1背包的问题，这里的二维自然也是可以降到一维的：

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
        
        int[] dp = new int[v+1];
        for(int i = 1;i <= n;i++){
            for(int j = V[i];j <= v;j++){ //循环直接从V[i]开始 可以减少掉一次if判断 最起码要放得下i才开始放
                dp[j] = Math.max(dp[j],dp[j - V[i]] + W[i]);
            }
        }
        System.out.println(dp[v]);
    }
}
```

***

##  1.3 完全背包、0 1背包对比

>可能细心的同学已经发现了，在**都优化为一维之后，可以发现两个问题的状态转移方程式是完全一样的，都是 dp[j] = Math.max(dp[j] , dp[j - V[i]] + W[i]) ，唯一一点不同的就是0 1背包问题计算的时候是逆序的遍历，但是完全背包问题是正序的遍历进行计算。**
>
>![image-20221220173638955](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221220173638955.png)
>
>模拟计算过程如下，对于完全背包问题，我们对于每一个物品，我们求取的是在不超过当前背包容量的情况下，物品i使用不同次数的时候所能带来的最大价值的问题，所以在每一个i下，不同的j的时候，我们需要使用到的是它的新值，也就是i已经放入一定次数之后，有一个最大价值，然后我们在这个基础之上，再增加使用次数，再来求取一个最大价值。 
>
>![image-20221220173616092](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20221220173616092.png)



 
