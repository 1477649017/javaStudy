#  Java运算符

#  一，什么是运算符

**定义：对操作数进行操作时的符号成为运算符。**

**Java的运算符分类：**

**算术运算符(+ - * /)、关系运算符(< > ==)、逻辑运算符、位运算符、移位运算符以及条件运算符等。**

****



#  二，算数运算符

##  2.1，基本四则运算符：加减乘除模(+ - * / %)

**这里只重点说两个，除/ 与 求模%**

###  2.1.1，/运算符

```
public class TestDemo220422 {
    public static void main(String[] args) {
//        int/int 结果还是整形
        int a = 5;
        int b = 2;
        System.out.println(a/b);
        int c = 0;
        System.out.println(a/c);
    }
}

```

**程序运行截图：**

![image-20220422093802687](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220422093802687.png) 

**注意：**

![image-20220422094211121](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220422094211121.png) 

****

###  2.1.2，%运算符

```
public class TestDemo220422 {
    public static void main(String[] args) {
        System.out.println(10%3);
        System.out.println(10%-3);
        System.out.println(-10%3);
        System.out.println(-10%-3);
    }
}
```

**程序运行截图：**

![image-20220422094930993](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220422094930993.png) 

**注意：**

**负数的模运算的原理其实和正数是一样的，当然也是有公式的 ：a % b = a - (int)(a)/b * b ,因为有时候有可能a是一个浮点数，这个时候记得后面需要强转为int一下。(在Java中浮点数也是可以取模运算的)**

****



##  2.2，增量运算符 += -= *= %=

**增量运算符其实也就是我们所说的复合赋值运算符。**

````
public class TestDemo220422 {
    public static void main(String[] args) {
        int a = 1;
        a += 2; // 相当于 a = a + 2
        System.out.println(a); // 输出3

//        易错点注意
        short b = 1;
//        b = b + 1;这么写肯定是报错，因为类型不兼容
        b += 1;//但是这么写就可以，因为这里其实有一个自动的强制类型的转换
        System.out.println(b);
    }
}
````

**程序运行截图：**

![image-20220422101208717](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220422101208717.png) 

****





## 2.3，自增自减运算符

一般使用：

```
int a = 1;
a++; // 后置++ 表示给a的值加1，此时a的值为2
System.out.println(a++); // 注意：后置++是先使用变量原来值，表示式结束时给变量+1，因此输出2
System.out.println(a); // 输出3

++a; // 前置++ 表示给a的值加1
System.out.println(++a); // 注意：前置++是先给变量+1，然后使用变量中的值，因此输出5
System.out.println(a); // 输出5
```

**注意：**

1. 如果单独使用，【前置++】和【后置++】没有任何区别 
2. 如果混合使用，【前置++】先+1，然后使用变量+1之后的值，【后置++】先使用变量原来的值，表达式 结束时给变量+1
3.  只有变量才能使用自增/自减运算符，常量不能使用，因为常量不允许被修改

****



**特别提醒：**

在Java里面，有一个关于自增自减运算符的坑，很容易踩，这里给大家介绍下：

```
public class TestDemo220421 {
    /**
     * Java前置自增以及后置自增中的坑
     * @param args
     */
    public static void main(String[] args) {
        int i = 1;
        i = ++i;
        System.out.println(i);//输出2

        int j = 1;
        j = j++;
        System.out.println(j);
    }
}
```

大家觉得会输出什么，如果按照C语言中的了解的话，我肯定会说这么简单，不就是2 ,2嘛，没什么难的，但事实是，大家看运行结果......

**程序运行截图：**

![image-20220421145654828](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220421145654828.png) 



是不是惊了，结果竟然是2，1 ，那是为什么呢？因为这里要理解很清楚的话，得需要理解Java的底层汇编知识，所以这里给大家一种低配版的理解方式。

```
j = j++;//这里的实际过程是有一个中间量 temp = j -> j = j+1 -> j = temp 所以最后结果还是初始值
i = ++i;// i = i + 1 -> temp = i -> i = temp 前置自增你如果是为了得到正确的结果按平常的理解方法也是没有问题的
```



#  三，关系运算符

**关系运算符主要有六个: == != < > <= >= ，其计算结果是 true 或者 false 。**

```
nt a = 10;
int b = 20;
// 注意：在Java中 = 表示赋值，要与数学中的含义区分
// 在Java中 == 表示相等
System.out.println(a == b); // false
System.out.println(a != b); // true
System.out.println(a < b); // true
System.out.println(a > b); // false
System.out.println(a <= b); // true
System.out.println(a >= b); // false
```

**注意：当需要多次判断时，不能连着写，比如：3 < a < 5，Java程序与数学中是有区别的**

****



#  四，逻辑运算符

**逻辑运算符主要有三个: && || ! ，运算结果都是 boolean类型**

###  4.1，逻辑与

语法规则：表达式1 && 表达式2，**左右表达式必须是boolean类型的结果。**两个表达式都为真，结果才是真，只要有一个是假，结果就是假。

![image-20220422105551052](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220422105551052.png) 

****

###  4.2，逻辑或

语法规则：表达式1 || 表达式2，**左右表达式必须是boolean类型的结果。**两个表达式，有真则结果为真。

![image-20220422110201232](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220422110201232.png) 

****



**注意：在Java里面，！运算符只能作用于boolean类型，没有C语言中的作用于int的用法。**

```
public class TestDemo220421 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(!(a < b));
//        System.out.println(!a);错误的，没有说什么a非0，然后前面加上！就表示结果为假
    }
}
```

这里的逻辑与，逻辑或都是含有短路的性质的。

逻辑与(短路与) ：在表达式一为假的情况下，整个逻辑表达式的结果为false，表达式二不会执行。

逻辑或(短路或) ：在表达式一为真的情况下，整个逻辑表达式的结果为true，表达式二不会执行。



****

#  五，位运算符

**位运算符主要有四个: & | ~ ^ ，除 ~ 是一元运算符外，其余都是二元运算符。(位运算符操作的都是二进制位)**

1. 按位与 &: 如果两个二进制位都是 1, 则结果为 1, 否则结果为 0。
2. 按位或 |: 如果两个二进制位中有一个为1，那么结果则为1，否则结果都为0。
3. 按位异或 ^ : 对于两个二进制位，相同为0，相异则为1。
4. 按位取反 ~：把一个数的二进制中的1变为0，0变为1。

****



#  六，移位运算

**移位运算符有三个: << >> >>> ，都是二元运算符，且都是按照二进制比特位来运算的。**

```
public class TestDemo220422 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a<<1);
        System.out.println(a>>1);

        int b = -1;
        System.out.println(b>>>1);//11111111 >>> 01111111
    }
}
```

**程序运行截图：**

![image-20220422114413765](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220422114413765.png) 

<< 左移：左侧丢弃，右边补上0。

\>>右移：右侧丢弃，左侧补上符号位。

\>>> 无符号右移：右侧丢弃，左侧只补0。

****

注意：

1. 左移 1 位, 相当于原数字 * 2. 左移 N 位, 相当于原数字 * 2 的N次方.(只针对正数成立)
2. 右移 1 位, 相当于原数字 / 2. 右移 N 位, 相当于原数字 / 2 的N次方.(只针对正数成立)
3. 由于计算机计算移位效率高于计算乘除, 当某个代码正好乘除 2 的N次方的时候可以用移位运算代替.
4. 移动负数位或者移位位数过大都没有意义.
4. 没有无符号左移这种运算符<<<.

****



#  七，条件运算符

**条件运算符只有一个: 表达式1 ? 表达式2 : 表达式3**
当 表达式1 的值为 true 时, 整个表达式的值为 表达式2 的值;当 表达式1 的值为 false 时, 整个表达式的值为 表达式3 的值.也是 Java 中唯一的一个 三目运算符, 是条件判断语句的简化写法.

**注意：**

1. 表达式2和表达式3的结果要是**同类型的**，除非能发生类型隐式类型转换

   ```
   public class TestDemo220422 {
       public static void main(String[] args) {
           int a = 10;
           int b = 20;
   //        int ret = a > b ? 1:1.2;错误的!!!!
       }
   }
   ```

   因为我们是要用int 类型的ret来接收结果，所以你后面的结果也必须是整形的。当然如果你直接用输出语句来接受的话那就是没有问题的。

2. 表达式不能单独存在，其产生的结果必须要被使用。

   ```
   public class TestDemo220422 {
       public static void main(String[] args) {
           int a = 10;
           int b = 20;
           a > b? a : b; // 报错：Error:(15, 14) java: 不是语句
       }
   }
   ```

****



