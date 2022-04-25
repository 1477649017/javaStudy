#    一，初识Java的main方法

##   1.1，前期准备

###  1.1.1，下载jdk

&emsp;jdk是java的开发工具，我们一般推荐下载的都是企业级长期使用版本jdk8

****



###  1.1.2，配置环境变量

&emsp;因为后面会演示一个java程序的原始编译过程，所以这里并未直接使用集成开发环境，而是选择在dos环境下去运用指令对一个程序进行编译运行，配置环境变量的方法如下(**右击我的电脑选择属性，高级系统设置**)：

![image-20220417162643455](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220417162643455.png)

****



 :first_quarter_moon:CLASSPATH变量值:***.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar***（最前面有一个小.不能掉，也不能有空格）

  :first_quarter_moon:JAVA_HOME变量值:***C:\Program Files\Java\jdk1.8.0_192***（你自己jdk的安装路径）

  :first_quarter_moon:Path变量添加值:***%JAVA_HOME%\bin***

****



##  1.2，main方法示例

###  1.2.1，第一个Java程序

这里的代码编辑器我们先使用Sublime Test。

我们先来看一个简单的代码，当然是我们熟悉的hello world又回来了！

```java
public class HelloWorld{
	public static void main(String[] args){
		System.out.println("hello world");
	}

}
```

但是，这里可能会有疑惑了，Sublime就只是类似于一个文本编辑器，那么我们在磁盘上的源码文件要怎么跑起来呢？

****



**这里我们就要用到windows的dos指令了，由下图所示，这就是一个java程序的编译运行的大概流程**

![image-20220417172514358](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220417172514358.png)

**:question:这里提到了一个点，JVM，那么接下来就给大家介绍下JVM,JDK,JRE,到底是什么，以及他们三者的关系。**

  :first_quarter_moon:JDK:  Java Development Kit    java开发工具

  :first_quarter_moon:JRE:  Java Runtime Environment    java运行环境

  :first_quarter_moon:JVM:  Java Virtual Machine    java虚拟机

**图示：**

![image-20220417174349824](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220417174349824.png)

在这里补充一个点，就是对于一个java文件而言，在进行编译的时候，每一个类编译后都会对应一个字节码文件，例如：

![image-20220420093153601](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220420093153601.png)

****



###  1.2.2，细节解析

**一个类，方法的各个参数名字的含义解析：**

![image-20220417195832891](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220417195832891.png)

****



**有关字符串数组，运行时参数**

![image-20220417194349434](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220417194349434.png)





##   1.3，一个Java程序可能会遇到的问题

- 源文件名后缀不是.java
- 类名与文件名不一致
- main方法名字写错：mian
- 一个文件中可以没有public修饰的类，但是有就只能有一个
- 方法中语句没有以分号结尾
- 中文格式的分号
- JDK环境没有配置好，操作系统不能识别javac或者java命令

****



#  二，注释

##  2.1，基本规则

**Java中的注释主要分为以下三种** 

1. 单行注释：// 注释内容（用的最多） 

2. 多行注释：/* 注释内容*/（不推荐） 

3. 文档注释： **/ 文档注释 */（常见于方法和类之上描述方法和类的作用)，可以被javadoc工具解析，生 成一套以网页文件形式体现的程序说明文档**** 

   注意： 1. 多行注释不能嵌套使用         2. 不论是单行还是多行注释，都不参与编译，即编译之后生成的.class文件中不包含注释信息。

**代码演示：**

```java
/**
文档注释：
@version v1.0.0
@author xiaowang
作用HelloWorld类，入门第一个程序练习
*/

public class HelloWorld{
	public static void main(String[] args) {
		for(int i = 0;i < args.length;i++){
			System.out.println(args[i]);
		}
	}
	public static void func(String[] args){
		System.out.println("helloworld");//单行注释
		/*System.out.print("helloworld");
		System.out.printf("%d\n",10);*/ //多行注释
	}

}
```

**图示：**

![image-20220417204320161](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220417204320161.png)



****

##  2.2，注释规范

1. 内容准确: 注释内容要和代码一致, 匹配, 并在代码修改时及时更新.
2. 篇幅合理: 注释既不应该太精简, 也不应该长篇大论.
3. 使用中文: 一般中国公司都要求使用中文写注释, 外企另当别论.
4. 积极向上: 注释中不要包含负能量

****



#  三，标识符

**定义：在程序中由用户给类名、方法名或 者变量所取的名字。**

【硬性规则】

1.  标识符中可以包含：字母、数字以及 下划线和 $ 符号等等。
2.  注意：标识符不能以数字开头，也不能是关键字，且严格区分大小写。 

【软性建议】

1.  类名：每个单词的首字母大写(大驼峰) 
2. 方法名：首字母小写，后面每个单词的首字母大写(小驼峰)
3.  变量名：与方法名规则相同

**注意一个点：就是main作为变量名，它是合法的，但是不合理，不推荐这么去做。**

![image-20220417210617226](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220417210617226.png)



****



#  四，关键字

**关键字是由Java语言提前定义好的，有特殊含义的标识符，或者保留字。**

**注意：用户不能使用关键字定义标识符。**

![image-20220417211517408](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220417211517408.png)