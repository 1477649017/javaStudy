#  Java核心技术卷 1（看书的点）

#  1，Console类

在利用Scanner类进行获取输入的时候，它是可见的，所以就不易于从控制台读取输入的密码。Java6引入了Console类。

```
import java.io.*;
public class TeseDemo220424 {
    public static void main(String[] args) {
        Console cons = System.console();

        if (cons == null) {
            System.out.println(
                    "No console available");
            return;
        }
        char[] password = cons.readPassword("Passwoed:");
    }
}
```

**在IDEA下的运行截图：**

![image-20220424222648471](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220424222648471.png) 

表示无可用控制台，如果不进行判空就会直接报空指针异常，那是为什么呢？

使用Eclipse等IDE运行以上代码时Console中将会为null。　表示Java程序无法获得Console实例，是因为**JVM不是在命令行中被调用的**，或者输入输出被重定向了。在Eclipse诸如类似的IDE工具中运行Console类。如果没有对Console实例判空操作，结果使用了该实例会抛出java.lang.NullPointerException异常。只好去控制台运行这个代码或者在linux下运行。

****

控制台下运行：

![image-20220424222907370](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220424222907370.png) 