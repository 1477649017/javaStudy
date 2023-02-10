#  Spring

#  一，Spring是什么？

> 我们通常说的Spring指的是Spring Framework，也就是Spring框架。它是一个开源的框架，有着活跃而庞大的社区，所以可以经久不衰。
>
> **如果结合Spring的核心思想给出一个简单明了的定义就是 ： Spring是一个拥有众多工具方法的IoC容器。**
>
> 这里也引出了两个问题需要我们重点关注：什么是容器 ？ 什么是IoC?

***

##  1.1，容器的概念

> 在日常的生活中，例如水杯等等这些都是容器，容器的作用就是用来容纳某种物品。那么抽象到计算机里面，容器中容纳可以是数据，方法，或者是网站等等
>
> ***
>
> 例如我们前面学过集合的概念，List/Set/Queue/Map之类的，就是数据存储容器，Tomcat是用来部署网站的，那么Tomcat就可以认为是web容器。

***

##  1.2，IoC

> 我们说Spring是一个容器，IoC是这个容器的限定词，相当于说明了这个容器的功能是干什么的。
>
> IoC(Inversion of Control  )  翻译过来就是**“控制反转”**，它是一种设计思想。

> 现在用一个例子初步的来呈现 “控制反转”的思想，假设我们要编写一个构造一辆车的程序，车大体我们分为车身，底盘，轮胎这几个部件，并且各个部件之间存在依赖关系。

> **1，传统的程序开发方式**
>
> ![image-20230111185315979](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230111185315979.png) 
>
> ***
>
> ````java
> package Traditional;
> 
> public class Car {
>     private FrameWork frameWork;
>     public Car(int size){
>         frameWork = new FrameWork(size);//创建一个车身对象
>     }
>     public void init(){
>         System.out.println("执行Car的init方法");
>         //需要依赖车身
>         frameWork.init();
>     }
> }
> ******************************************************
> package Traditional;
> 
> public class FrameWork {
>     private Bottom bottom;
>     public FrameWork(int size){
>         bottom = new Bottom(size);
>     }
>     public void init(){
>         System.out.println("执行FrameWork的init方法");
>         //依赖底盘
>         bottom.init();
>     }
> }
> *******************************************************
> package Traditional;
> 
> public class Bottom {
>     private Tire tire;
> 
>     public Bottom(int size){
>         tire = new Tire(size);
>     }
>     public void init(){
>         System.out.println("执行Bottom的init方法");
>         //依赖轮胎
>         tire.init();
>     }
> }
> *******************************************************
> package Traditional;
> 
> public class Tire {
>     private int size;
> 
>     public Tire(int size){
>         this.size = size;
>     }
> 
>     public void init(){
>         System.out.println("执行Tire的init方法");
>         System.out.println("车的轮胎的尺寸为：" + size);
>     }
> }
> *******************************************************
> package Traditional;
> 
> public class App {
>     //测试类
>     public static void main(String[] args) {
>         Car car = new Car(25);
>         car.init();
>     }
> }
> ````
>
> 运行截图：
>
> > ![image-20230111195705065](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230111195705065.png) 
>
> ****
>
> > 这种传统方式实现的程序，存在一个很大的缺陷，就是代码的耦合度太高。因为各个类之间的关联性太强。
> >
> > ![image-20230111200655909](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230111200655909.png) 
> >
> > 现在假如最后Tire类需要增加参数，那么这个时候这条调用链上的所有的构造方法的参数都需要进行变化，如果调用链很长，那么代码的改动将会是一个大工程。
> >
> > 那么问题怎么解决呢？就是接下来将要介绍的 “控制反转” 思想。

> 2，控制反转式程序开发
>
> ![image-20230111223809052](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230111223809052.png) 
>
> ***
>
> ```java
> package IoC;
> 
> public class Car {
>     private FrameWork frameWork;
>     public Car(FrameWork frameWork){
>         this.frameWork = frameWork;
>     }
>     public void init(){
>         System.out.println("执行Car的init方法");
>         //依赖FrameWork
>         frameWork.init();
>     }
> }
> ***********************************************
> package IoC;
> 
> public class FrameWork {
>     private Bottom bottom;
>     public FrameWork(Bottom bottom){
>         this.bottom = bottom;
>     }
>     public void init(){
>         System.out.println("执行FrameWork的init方法");
>         //依赖Bottom
>         bottom.init();
>     }
> }
> ***********************************************
> package IoC;
> 
> public class Bottom {
>     private Tire tire;
>     public Bottom(Tire tire){
>         this.tire = tire;
>     }
>     public void init(){
>         System.out.println("执行Bottom的init方法");
>         //依赖Tire
>         tire.init();
>     }
> }
> ***********************************************
> package IoC;
> 
> public class Tire {
>     private int size;
>     public Tire(int size){
>         this.size = size;
>     }
>     public void init(){
>         System.out.println("执行Tire的init方法");
>         System.out.println("车轮的尺寸是：" + size);
>     }
> }
> ***********************************************
> package IoC;
> 
> public class App {
>     public static void main(String[] args) {
>         Tire tire = new Tire(15);
>         Bottom bottom = new Bottom(tire);
>         FrameWork frameWork = new FrameWork(bottom);
>         Car car = new Car(frameWork);
>         car.init();
>     }
> }
> ```
>
> 运行截图：
>
> > ![image-20230111224049672](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230111224049672.png) 
>
> ****
>
> > 相对于传统方式实现的代码，利用控制反转思想设计出的代码的耦合性就会很低。
> >
> > ![image-20230111225752867](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230111225752867.png) 
> >
> > 

> 两种方式的对比：
>
> 通过代码的实现我们可以看到，两种方式的创建对象的顺序是反的，传统的是Car控制并创建了FrameWork对象，FrameWork控制并创建了Bottom对象，然后依次往下。但是通过控制反转思想设计出来的代码对象的创建顺序刚好是反的，不再是上级对象控制并创建下级对象了，而是将下级对象注入当前上级对象，这样下级对象的控制权就不再由上级对象控制了，这样即使下级类发生任何的更改，当前类都是不受任何影响的，因为下级类发生改变默认传入的对象肯定是随之改变的，但是传统方法是需要上级类去构造下级类对象，如果下级类发生改变，那么当前上级类就必须发生改变来进行应对，例如需要另外传入参数等等，这样整个调用链都需要发生变化。

****

【总结：】

> 深入理解IoC:
>
> 前面通过简单的示例初步了解了以下"控制反转的思想"，那么IoC的思想到底具体指的什么？控制反转控制的是什么？反转的又是什么？

> 1，IoC的思想
>
> > IoC意味着将我们设计好的对象交给容器去控制(这里的容器也就是指的Spring)，不再是由程序员去手动new对象
>
> 2，控制的是什么？
>
> > 控制指的是控制对象的生命周期，即对象的创建，初始化，销毁。创建对象，原来是通过new关键字手动构造出一个对象，现在是交给Spring去创建。初始化，如果说A对象的创建依赖B对象，原来是在A的构造方法中去new一个B对象，现在是交由Spring自动注入了。销毁，原来是将对象直接将引用置为null或者交予JVM去进行回收，现在是Spring来负责对象的销毁。
>
> 3，反转的是什么？
>
> > 反转指的是控制权的反转。在之前对象的生命周期都是掌握在程序员自己手中的，但是现在我们的对象生命周期的控制权交予了Spring。

****

##  1.3，Spring IoC

> 前面已经介绍过了容器与IoC的概念，我们说Spring是一个具有众多工具方法的IoC容器。其实简单点定义就是Spring是一个可以帮助我们托管对象的容器，Spring将原本是掌握在程序员手中的对象的控制权拿走了，它的最大的好处就是可以实现代码上的解耦，让我们在编写代码的时候不再需要去考虑对象的生命周期以及对象的属性等等，只用在需要的时候将对象从Spring中引入就好，简单而言就是Spring给我什么我就用什么。

> 既然Spring是容器，那么最核心的功能就是：将对象存入Spring，将对象从Spring中取出。

****

##  1.4，DI的概念

> DI是Dependency Injection的缩写，也就是"依赖注入"。
>
> 那么理解DI就是从两个方面入手，什么是依赖?，什么是注入？
>
> ****
>
> 1，什么是依赖
>
> > 对象运行所需要的外部资源，例如另一个对象，数据等等就是依赖，没有这些东西不能完成正常的业务逻辑。
>
> 2，什么是注入
>
> > 注入就是将容器中加载好的对象，数据，资源等等引入到当前对象中，好让其完成业务逻辑。

> 与IoC的区别：
>
> > 其实解释完依赖注入，我们可以发现DI与IoC在广义上是一个意思，但实际又存在区别，二者属于是在不同的维度上去描述同一个问题。IoC强调的是对象的生命周期的控制权的反转，DI强调的是对象所需要的依赖由容器进行注入。IoC是一种思想，而DI是这种思想的一个具体的实现，我们通过引入IoC容器来管理对象的生命周期，然后采用依赖注入的手法，实现了对象之间的解耦。

***

#  二，Spring的创建与使用

##  2.1，创建Spring项目

> Spring项目的创建总体分为三步：
>
> 1，创建一个普通的Maven项目
>
> 2，添加Spring框架支持(spring-context、spring-beans )
>
> 3，添加启动类

对于第一个步骤，创建一个普通的Maven项目这里就不做具体演示了，和创建普通的Java项目差别不大，重点是关注第二个步骤。

> 添加Spring框架支持
>
> 在创建好的Maven项目中的pom.xml中，添加如下代码：
>
> ```
> <dependencies>
>    <dependency>
>         <groupId>org.springframework</groupId>
>         <artifactId>spring-context</artifactId>
>         <version>5.2.3.RELEASE</version>
>     </dependency>
>   
>     <dependency>
>         <groupId>org.springframework</groupId>
>         <artifactId>spring-beans</artifactId>
>         <version>5.2.3.RELEASE</version>
>     </dependency>
> </dependencies>
> ```
>
> ![image-20230112164905846](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230112164905846.png) 
>
> ***
>
>  [补充]Maven配置国内源
>
> 1，点开settings
>
> > ![image-20230112191542980](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230112191542980.png) 
>
> 2，进行设置
>
> > ![image-20230112191626885](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230112191626885.png) 
>
> 3，打开settings.xml进行国内源的配置
>
> > ![image-20230112191712804](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230112191712804.png) 
>
> 4，重新点击reload，看是否会报错。如果不报错就说明正确配置成功。当前项目配置完之后，还要讲新建项目的也要进行同样的配置
>
> > 如果说第四步这里发现下载还是会报错，那么就删除文件夹repository中的本地存储的jar包，全部删除之后回到idea中点击reload重新进行下载，如果还是出现问题，那么可能就是网络环境的问题，多尝试几次，最后如果尝试多次之后还是有问题，那么可能就是网络运营商的问题，尝试切换热点，或者等待一段时间之后再来进行设置。

****

##  2.2，存储Bean对象

> 存储Bean对象分为两步：
>
> 1，首先要创建出一个Bean
>
> 2，将创建好的Bean注册到Spring容器

****

**1，创建Bean**

> 所谓的Bean就是一个普通的对象，这里创建Bean其实要创建一个对象对应的基本类，因为对象是类的实例。

```java
public class Demo {
    public String func(){
        return "hello java";
    }
}
```

***

**2，将Bean注册到容器**

> 在resources目录下创建Spring的配置文件，例如如下的SpringConfig.xml，配置文件代码如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
</beans>
```

> Spring配置文件的代码是一成不变的，所以不需要刻意的记忆，在本地或者云端仓库保存即可。

***

> 然后再将Bean对象配置到配置文件当中，这样当Spring启动之后，就会加载配置文件中的Bean对象将其放到容器中

```xml
<bean id="demo" class="Demo"></bean>
```

> 在之前的配置文件中加入这么一行代码，其中id相当于就是这个Bean对象的代号，Class就是这个Bean对象对应的基本类，注意这里要具体到是哪个包下的哪个类，这里不存在包所以直接类名即可。
>
> 配置文件的作用其实就是告诉Spring容器要干嘛，比如Spring容器需要加载哪些Bean对象。将Bean对象添加到xml中只是逻辑层面的存储，相当于只是一个声明，真正的Bean对象存储到容器中是等到创建了Spring对象才会。

***

##  2.3，获取并使用Bean对象

> 获取就是从Spring容器中去获取一个Bean对象，它是我们之前指定类的实例。
>
> 主体步骤分为三步：
>
> 1，首先获取到Spring上下文对象，因为对象是托管给了Spring，你的Bean对象需要通过Spring的上下文对象去获取
>
> 2，通过Spring上下文对象，去获取一个指定的Bean对象
>
> 3，使用Bean对象

***

**1，创建Spring上下文对象**

> ![image-20230113151259421](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230113151259421.png)

> 上面图片中获取Spring上下文对象使用的接口是ApplicationContext，这是目前使用的方法。在早期的时候，使用的是BeanFactory这个接口，达到的效果和ApplicationContext是一样的，ApplicationContext继承自BeanFactory，并且添加了一些新的功能。
>
> ```java
> BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("SpringConfig.xml"));
> ```

> 现在主要关注的点是二者之间的区别：
>
> **相同点：**
>
> > 1，都可以得到Spring的上下文对象
> >
> > 2，都是来自Spring的顶级接口
>
> **不同点：**
>
> > 1，继承关系与功能
> >
> > > ApplicationContext继承自BeanFactory。对于BeanFactory而言，它比较古老，所以只是实现了最基础的访问Bean的功能，但是对于ApplicationContext而言，功能会更加的强大，例如国际化支持，资源访问，事件传播等等
> >
> > 2，性能
> >
> > > 对于ApplicationContext而言，它是典型的饿汉模式，也就是在初始化Spring容器的时候会直接一次性将所有的Bean对象都加载，典型的通过空间来换取时间，后面访问Bean对象的速度会很快。但是对于BeanFactory而言，就是懒汉模式，当某个Bean对象被需要的时候才会去加载Bean对象。
> > >
> > > ![image-20230113192332279](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230113192332279.png) 
> > >
> > > 但是对于Spring而言，现在都是十分的智能的，虽然ApplicationContext说是饿汉模式，会在一开始就加载所有的Bean对象，但是这个是基于你的硬件环境的，如果当前资源内存都充足，那么就会一次性加载所有的Bean对象，但是如果Spring检测到当前明显的内存资源都不够用，那肯定是不会一次性所有的加载，需要什么就加载什么。

***

**2，通过Spring上下文对象获取Bean对象**

```java
//2 从Spring上下文对象中获取Bean对象
Demo demo = (Demo) applicationContext.getBean("demo");
```

> getBean()通过id来获取Bean对象，返回的是一个Object类型的对象，所以需要进行向下转型。

***

**3，使用Bean对象**

```java
//3 使用Bean对象 可选
System.out.println(demo.func());
```

> ![image-20230113154316671](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230113154316671.png) 

***

##  2.4，一些使用细节

> 1，将Bean对象注册到容器中的时候，注意id不要重复，也不要不写id
>
> ![image-20230113160430511](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230113160430511.png) 
>
> 如果不写id的话，相当于Spring容器中存储着这个Bean对象，但是知不道这个Bean对象是谁，你也拿不到这个对象。
>
> ***
>
> 对于同一个类的不同Bean对象，可以在容器中注册多次，只要注意id要不一样，这个是不同的Bean对象区分的标识
>
> ![image-20230113161607247](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230113161607247.png) 
>
> 可以发现根据不同的id，获取到的Demo类的Bean对象是不一样的。

> 2，不同的获取Bean对象的方法
>
> > 1，首先就是上面说的通过id来获取Bean对象
> >
> > ```java
> > Demo demo1 = (Demo) applicationContext.getBean("demo1");
> > ```
> >
> > 但是这种方法，首先是要注意配置文件中的id不能够重复，另外就是如果id不存在，那么你肯定是获取不到Bean对象的，也就是null，但是你还在进行强制类型转换的操作，所以肯定会报异常。再就是你返回的对象与你的强制类型转换的对象就步兼容。
>
> > 2，通过Bean类型获取
> >
> > ![image-20230113171233987](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230113171233987.png) 
> >
> > 这个时候获取到的Bean对象就是同一个Bean对象。
> >
> > 但是这种获取方法有一个问题就是，当一个类型的Bean对象在容器中注入了多次的时候，那么你再只是通过Bean类型获取，指向就不明确了。
> >
> > ![image-20230113171719241](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230113171719241.png) 
> >
> > 这个就比较容器出问题了，比如当前你自己知道这个类型的Bean对象只注册了一个，所以你当前用Bean类型获取没有什么问题，但是如果后面有人不知道，也需要使用这个类型的Bean对象，所以也注册了一次，那么后面你上面的代码获取Bean就肯定会出问题了。
>
> > 3，通过id + Bean类型来获取
> >
> > **这种方式是上面两种的结合版，也是日常使用的最多的，因为风险最小，出现问题的概率最小**
> >
> > ```java
> > Demo demo2 = applicationContext.getBean("demo1",Demo.class);
> > ```
> >
> > 同时指明要获取的Bean对象的id,以及类型，这样既可以保证指向的准确性，也可以保证不出现强制类型转换的一些问题，因为大不了最后就是获取不到这个一个Bean对象，赋值给demo2是null罢了

***

#  三，更加简单的读取和存储对象

> 前面我们已经可以实现对于对象的存储和读取，但是想要加入一个对象到容器中，就需要在xml中进行声明，那么如果对象很多，就会十分的麻烦。所以现在我们希冀可以有一个更简单的读取和存储对象的方法(通过注解实现)

##  3.1，存储对象

###  3.1.1，前置工作：扫描路径的配置

> 当我们配置好扫描路径之后，那么在这个扫描路径下的所有类，只要添加了注解的就会被识别并添加到Spring当中。相对于之前一个个对象的声明，这种方式会简便很多。

> 在配置文件中进行如下配置：可以将之前的配置文件直接替换掉
>
> ```java
> <?xml version="1.0" encoding="UTF-8"?>
> <beans xmlns="http://www.springframework.org/schema/beans"
>        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>        xmlns:content="http://www.springframework.org/schema/context"
>        xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
>        <content:component-scan base-package=""></content:component-scan>
> </beans>
> ```
>
> 最下面的content标签中的component-scan base-package=""中放入你想要扫描的路径

> 这里补充一个知识，有可能有的同学在多级包的时候会发现包之间是平铺的，无法打开，这里只需要一个简单的设置即可
>
> ![image-20230113211729188](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230113211729188.png) 

***

###   3.1.2，添加注解存储Bean对象

> 存在两种注解，类注解和方法注解
>
> 类注解：@Controller、@Service、@Repository、@Component、@Configuration
>
> 方法注解：@Bean 

>先以Controller为例，进行一次存取对象的操作：
>
>![image-20230116143858781](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230116143858781.png) 
>
>我们可以看到，在使用注解的方式添加对象到Spring中的时候，是不存在id这个概念的，那么我们后面如何可以精准的取到一个Bean对象呢？这就是我们接下来要说的几个默认的取用规则（与Bean对应类的类名有关）：
>
>***
>
>1，如果Bean对象对应类的类名是小写，那么我们怎么取？
>
>> 类的首字母本身就是小写，那么和首字母是大写的类的情况一样，都是把类的首字母转换为小写之后，依次作为依据去取Bean对象。
>
>2，如果Bean对象对应类的类名首字母和第二个字母都是大写怎么办？
>
>> 类的首字母与第二个字母都是大写的话，不需要做出任何的改变，直接以原类名作为依据去取用Bean对象。
>
>***
>
>上面是直接给出了结果，那么为何是这样，则需要从源码中去寻找答案了，如下：
>
>![image-20230116153500701](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230116153500701.png) 
>
>总结：使用五大类注解将对象加入Spring之后，想要取用Bean对象的时候，依据就是类名，如果该类名前两个字母不是同时是大写，那么都是类名第一个字母转换为小写作为BeanName，否则如果前两个字母都是大写，那么就是原类名不做任何处理
>
>***
>
>现在还存在一个比较偏门的问题，假如项目中的文件都直接放在java的根路径下，那么怎么去取Bean对象呢？虽然这种情况在工作中肯定是不被允许的，对于定位依据还是类名，但是配置文件中的扫描路径是需要做出更改的
>
>![image-20230116161926720](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230116161926720.png) 
>
>这个问题只是做了解，因为在正常的代码规范下是不能这样写的，并且将类直接放在根路径下，使用**去扫描的过程很慢，效率很低，并且在这种情况下，你创建Spring容器只能用BeanFactory，不然后面获取Bean对象会报错

****

###  3.1.3，为什么需要这么多类注解

> 对于当前的Spring核心项目，也就是相当于普通的项目，类注解的作用其实是一样的，也就是帮助存储Bean对象到Spring容器中，但是，既然作用都是一样的，那么为啥还需要有五个？
>
> 首先，不同的类注解它的含义是不一样的，功能也不一样，虽然当前还没有比较深刻的体会，不同的类注解就表明了当前类的功能是干啥的，它的用途是啥，这个在后面引入web模块后讲解SpringBoot、SpringMVC就会有更加全面的理解了

> 1，@Controller(控制器)：归属于业务逻辑层，用来控制用户的行为，例如检查前端传来的用户参数的有效性
>
> 2，@Service(服务)：归属于服务层，用来进行服务的安排与调度，根据不同的服务去调用相应的持久层的代码来完成功能(不直接与数据库打交道)
>
> 3，@Repository(仓库)：归属于持久层，也就是直接与数据库交互的层级。一般来说，一个数据库的表就对应着一个持久层的类，负责当前表的CRUD
>
> 4，@Configuration(配置)：归属于配置曾，用来描述当前项目的一些配置信息
>
> 5，@Component(组件)：归属于公共工具类，主要是提供一些公共的方法
>
> ***
>
> 【图示：】
>
> ![image-20230116180129433](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230116180129433.png) 

***

###  3.1.4，五大类注解之间的关系

> 在当前Spring核心项目中，不考虑太多，这五大类注解在功能上是一样的，那么背后肯定是存在着千丝万缕的联系，查看源码如下：
>
> ![image-20230116194333170](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230116194333170.png) 
>
> 通过源码可以发现，在@Controller,@Service,@Configuration,@Repository的实现中，都含有@Component的注解，所以可以说，@Component是其他四个注解的父类

###   3.1.5，方法注解Bean

> 前面介绍了类注解，但是对于类注解而言，我们想要达到将一个类型的Bean对象加入多次就是做不到的。这就需要用到我们的方法注解，将一个方法的返回对象加入Spring，这样只要这个方法返回的是你想要的Bean对象，这样调用多次就可以做到将一个类型的Bean对象加入多次

> ```java
> package Test;
> public class Student {
>     public int id;
>     public String name;
> 
>     public void setId(int id) {
>         this.id = id;
>     }
> 
>     public void setName(String name) {
>         this.name = name;
>     }
> 
>     @Override
>     public String toString() {
>         return "Test.Student{" +
>                 "id=" + id +
>                 ", name='" + name + '\'' +
>                 '}';
>     }
> }
> 
> ```
>
> ```java
> package Test.test;
> 
> import Test.Student;
> import org.springframework.context.annotation.Bean;
> 
> public class StudentBeans {
>     @Bean
>     public Student getStudent(){
>         //这里是伪代码 真实是不会new对象的 一般是查询数据库返回对象
>         Student stu = new Student();
>         stu.setId(1);
>         stu.setName("张三");
>         return stu;
>     }
> }
> 
> ```
>
> ```java
> import Test.Student;
> import Test.test.AComponent;
> import Test.test.BController;
> import org.springframework.beans.factory.BeanFactory;
> import org.springframework.beans.factory.xml.XmlBeanFactory;
> import org.springframework.context.ApplicationContext;
> import org.springframework.context.support.ClassPathXmlApplicationContext;
> import org.springframework.core.io.ClassPathResource;
> 
> public class App {
>     //这是一个测试启动类
> 
>     public static void main(String[] args) {
>         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringConfig.xml");
>         Student student = applicationContext.getBean("getStudent", Student.class);
>         System.out.println(student);
>     }
> }
> ```
>
>  ![image-20230116212431452](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230116212431452.png) 
>
> 但是对于上面的代码，我们运行之后会发现，报了NoSuchBean的异常，也就是没有找到这个Bean对象。这里就需要说到一个点了，因为Bean是方法注解，那么一个项目里面的方法是非常非常多的，所以你一个个方法的去找Bean注解，然后将方法返回对象加入Spring，那么效率会非常低，所以Spring规定了，@Bean必须和五大类注解配合使用，否则就是无效的注解。因为类肯定会好找很多。
>
> ****
>
> ```java
> @Component
> public class StudentBeans {
>     @Bean
>     public Student getStudent(){
>         //这里是伪代码 真实是不会new对象的 一般是查询数据库返回对象
>         Student stu = new Student();
>         stu.setId(1);
>         stu.setName("张三");
>         return stu;
>     }
> }
> ```
>
> ![image-20230116212830699](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230116212830699.png) 

> **重命名Bean:**
>
> ![image-20230117103014493](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230117103014493.png) 
>
> 在Bean注解的默认规则下，我们取用这个Bean对象的时候，依据的就是方法名。但是存在一个问题，就是方法是可以重复的，所以当存在多个相同的方法的时候，你在依据方法名去取对象，那就不行了。
>
> ![image-20230117103441732](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230117103441732.png) 
>
> 这里虽然说没有报错，但是会发现结果就不确定了，为啥一定要是返回的李四，为什么不可以是张三，我就想要取用张三怎么办？
>
> 这里就要使用Bean的重命名了，单独给每一个Bean注解取一个名字，这样即使是两个同名方法返回的对象也可以区分开了。
>
> ```java
> package Test.test;
> 
> import Test.Student;
> import org.springframework.context.annotation.Bean;
> import org.springframework.stereotype.Component;
> 
> @Component
> public class StudentBeans {
>     @Bean(name = {"stu1","stu2"})
>     //@Bean({"stu1","stu2"}) 简写版本
>     public Student getStudent(){
>         //这里是伪代码 真实是不会new对象的 一般是查询数据库返回对象
>         Student stu = new Student();
>         stu.setId(1);
>         stu.setName("张三");
>         return stu;
>     }
> }
> 
> ```
>
> 这样后面取用对象的时候就可以通过name来取用了，可以做到精确的取到你想要的对象。
>
> 但是这里注意到一个点，一旦你给Bean注解进行了重命名，那么原来默认的使用方法名就不可以了，无法再找到Bean对象。
>
> ![image-20230117104354750](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230117104354750.png) 

***

##  3.2，获取对象

> 获取Bean对象又叫做对象装配，是把对象取出来放到某个类中进行使用，也叫做对象注入，有以下三种方法：
>
> 1，属性注入
>
> 2，构造方法注入
>
> 3，Setter注入

###   3.2.1，属性注入

> 属性注入是利用@Autowired  实现的
>
> ![image-20230117111208105](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230117111208105.png) 
>
> 可以看到，使用属性注入的方式获取到StudentService对象就方便多了，不需要再和之前一样先获取Spring上下文对象，然后再用getBean方法获取。但是也注意一点，在main方法中是无法使用属性注入的，所以获取StudentController对象还是用的上下文的方法获取的。

> 优缺点分析：
>
> 1，优点
>
> > 属性注入的最大优点就是使用简单，只需要通过@Autowried就可以实现特定对象的注入
>
> 2，缺点
>
> > 属性注入简单，但是随之而来的问题也存在很多，Spring官方也是不推荐使用属性注入的方式来注入对象，缺点主要如下：
> >
> > > - 功能性问题：无法注入final修饰的不可变对象
> > >
> > > ![image-20230207155424997](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230207155424997.png) 
> > >
> > > 对于final修饰的变量而言，java规定了这类变量必须在定义的时候就初始化或者是在构造方法中进行初始化，但是显然属性注入这两个点都没满足，所以也就办不到注入不可变对象，这也就是为什么后面构造方法注入存在的意义了
> > >
> > > ****
> > >
> > > - 通用性问题
> > >
> > > 属性注入的方式是IoC容器中独有的，也就是只是在Spring的环境下才会有效，一旦代码移植到其他非IoC容器中，就必须通过构造方法或者是代码块来对对象进行初始化了，否则就是null了。
> > >
> > > ***
> > >
> > > - 设计原则问题
> > >
> > > 属性注入的方式更容易违背单一设计原则。
> > >
> > > > 我们知道设计模式，各种设计模式是需要遵守6大设计原则的，其中就有单一设计原则。
> > > >
> > > > 单一设计原则指的是应该只存在一个原因引起类的变更。比如一个类就负责某一个业务，其中的一个方法针对一个功能进行实现，将耦合降低到最低，这样就算其中一处代码改动不会影响其它方法和代码逻辑。
> > >
> > > 那为什么说属性注入更容易违背单一设计原则呢？注意是更容易，不是一定违背，因为属性注入足够简单，这就会导致我们在写代码的时候滥用的可能性更大，比如在一个类中注入多个无关对象等等，注入的这些对象是否有用，是否会对单一设计原则造成破坏等等的问题就会随之而来。

***

###  3.2.2，Setter注入

```java
package Test.test.Controller;
import Test.test.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
    //set注入
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void sayHi(){
        //要去调用Service的sayHi方法 所以这里必须获取到Service层的对象
        studentService.sayHi();
    }
}

```

> 注意Setter方法实质上也就是平常我们用来设置成员属性的Setter方法，但是这里要配合@Autowried注解使用，告诉Setter方法设置的值要从是Spring容器中取。

> 优缺点分析：
>
> 1，优点
>
> > 对于Setter注入方式，硬是要挑出一个优点来的话，那就是它会更加符合单一设计原则，因为一个Setter方法只针对一个对象。
> >
> > 单一设计原则，存在两个级别：类级别，方法级别。
> >
> > 对于属性注入而言，就是站在类级别，对于Setter注入而言就是站在方法的级别，因为一个方法只针对一个属性进行注入赋值，这样就更加符合单一设计原则；另外如果说硬是要和属性注入对比的话，因为针对一个对象的注入Setter会更加复杂，所以对于这个类而言注入其他无关对象的概率就会相对低，所以在类的级别上也是更加符合单一设计原则。
>
> ****
>
> 2，缺点
>
> > - 不能注入final修饰的不可变对象
> >
> > ![image-20230207172426993](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230207172426993.png) 
> >
> > 前面我们说过，final修饰的变量要么直接定义就赋值，要么在构造方法中去赋值，所以在Setter这里是没有办法对final进行注入赋值的。
> >
> > ***
> >
> > - 注入的对象存在被修改的风险
> >
> > ![image-20230207172825850](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230207172825850.png) 
> >
> > 针对Setter方法而言是可以被多次调用的，所以你注入的对象的值是随时可以被修改的。

****

###  3.2.3，构造方法注入

> 构造方法注入是Spring 4.x之后官方推荐使用的注入方式，实现代码如下：
>
> ```java
> package Test.test.Controller;
> import Test.test.AComponent;
> import Test.test.Service.StudentService;
> import org.springframework.beans.factory.annotation.Autowired;
> import org.springframework.context.annotation.Bean;
> import org.springframework.stereotype.Controller;
> 
> @Controller
> public class StudentController {
>     //构造方法注入
>     private StudentService studentService;
>     //@Autowired 这个注解可以省略
>     public StudentController(StudentService studentService) {
>         this.studentService = studentService;
>     }
> 
>     public void sayHi(){
>         //要去调用Service的sayHi方法 所以这里必须获取到Service层的对象
>         studentService.sayHi();
>     }
> }
> 
> ```
>
> 既然是官方推荐使用的方法，所以必然做出了相应的优化策略，也就是当类中只存在一个构造方法的时候，这个时候就是可以将@Autowried省略的。
>
> 但是当类中存在多个构造方法的时候，就不能省略了，因为多个构造方法，Spring就不知道针对哪个构造方法进行注入，也不清楚需要注入哪些对象。
>
> ![image-20230207190354755](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230207190354755.png) 

> 优缺点分析：
>
> 1，优点
>
> > - 可注入不可变对象
> >
> > final修饰的不可变对象，可以使用构造方法进行初始化，所以自然可以通过构造方法进行注入
> >
> > - 注入对象不能被修改
> >
> > > 首先，因为可以注入final修饰的对象，final修饰的对象自然无法修改。另外，构造方法只会在类加载的时候执行一次，所以不存在调用多次导致的修改问题。
> >
> > - 注入的对象会被完全初始化
> >
> > > 因为构造方法是在对象创建之初执行的，所以在注入的对象被使用之前会被完全初始化
> >
> > - 通用性更好
> >
> > > 想对于属性注入，构造方法注入通用性就更好，无论是IoC容器还是非IoC容器都是可用的。
>
> 2，缺点
>
> 相对于属性注入，那使用自然是相对繁琐一些。

**总结**

> 三种注入方式，总体上来说，在现在的工作环境下，还是属性注入使用的最多，因为基本上没有企业不使用Spring，另外使用也更简单，属性注入的方式的问题可以人为尽量规避。构造方法注入的方式毕竟是官方推荐的，所以使用也会有一些，Setter注入的方式使用会相对少一些。

***

###  3.2.4，@Resource 另一种注入注解

> 在进行对象注入的时候，出了可以使用@Autowried之外，还可以使用@Resource进行注入。
>
> ```java
> package Test.test.Controller;
> import Test.test.AComponent;
> import Test.test.Service.StudentService;
> import org.springframework.beans.factory.annotation.Autowired;
> import org.springframework.context.annotation.Bean;
> import org.springframework.stereotype.Controller;
> 
> import javax.annotation.Resource;
> @Controller
> public class StudentController {
>     //@Resuorce注入
> //    @Resource
>     private StudentService studentService;
> 
>     @Resource
>     public void setStudentService(StudentService studentService) {
>         this.studentService = studentService;
>     }
>     public void sayHi(){
>         studentService.sayHi();
>     }
> }
> ```

> @Autowried与@Resource的区别：
>
> 相同点：都可以实现依赖注入
>
> 不同点：
>
> > 1，功能支持不同：@Autowried支持属性注入，Setter方法注入，构造方法注入；但是@Resource只支持属性注入以及Setter方法注入
> >
> > > 至于为什么@Resource不支持构造方法注入，可能是因为jdk提供的基本功能支持中并没有解决构造方法中可能存在的循环依赖的问题，这点Spring是解决了的，并且Spring 6.x之后已经不支持循环依赖了。
> >
> > 2，出身不同：@Autowried来自于Spring框架，@Resource来自于JDK
> >
> > 3，参数支持不同，@Resource支持的更多的参数设置，例如name属性，而@Autowried只支持required参数。

###  3.2.5，同类型多个@Bean报错问题

> ![image-20230207214012577](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230207214012577.png)
>
> 通过方法注解我们在Spring中存入了两个Student对象，后面其实无论我们是通过@Autowried还是@Resource其实都是无法直接注入Student对象的，因为指向不明确，检测到多个符合的Bean对象，使用方法注解的话我们在获取对应的Bean对象的时候其实默认是按照方法名去获取的，这里如果说将我们的变量名和方法名统一起来，也是可以解决问题的，例如：
>
> ```java
> @Resource
> private Student student1;
> public void func(){
>     System.out.println(student1);
> }
> ```
>
>  但是这样变量名就需要和方法名去挂钩了，总归还是不太好，如果说即想要使用自己定义的变量名，又可以保证成功匹配注入，有两种方法：
>
> 1，@Resource结合其name属性
>
> ```java
> @Resource(name = "student1")
> private Student student;
> public void func(){
>     System.out.println(student);
> }
> ```
>
> name属性的名称和对应的方法名对应，这样注入的就是该方法返回的对象。
>
> ***
>
> 2，@Autowried搭配@Qualifier使用，相当于过滤的作用
>
> ```java
> @Autowired
> @Qualifier("student1")
> private Student student;
> public void func(){
>     System.out.println(student);
> }
> ```

#  四，Bean的作用域与生命周期

##   4.1，作用域的定义

> 以前我们聊起作用域，就是针对变量，对象等其所在的可用范围就被称之为作用域。但是这里，**Bean的作用域指的是Bean在Spring中的某种行为模式**。比如Bean的单例作用域，表示Bean对象在整个Spring中只存在一份，是全局共享的，这就是一种行为模式。

> 单通过定义，相信很多人不明白，因为概念说的很晦涩难懂，那么下面就通过一个简单的案例来体会一下Bean的一种作用域。

> 补充：lombok的使用
>
> 这里先补充一下lombok的使用，lombok也是框架，它的作用主要是为了简化一些java开发中的必要且重复冗余的代码的编写，例如对于一个类的属性的getter与setter方法，以及equals()，hashcode()，有参构造，无参构造方法等等，都可以通过lombok的注解简单实现。
>
> ***
>
> lombok使用：
>
> > 1，首先引入lombok依赖
> >
> > ```java
> > <dependencies>
> >     <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
> >     <dependency>
> >         <groupId>org.projectlombok</groupId>
> >         <artifactId>lombok</artifactId>
> >         <version>1.18.26</version>
> >         <scope>provided</scope>
> >     </dependency>
> > </dependencies>
> > ```
> >
> > ***
> >
> > 2，安装lombok插件
> >
> > ![image-20230208161417113](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230208161417113.png)
> >
> > 这里记得一定要装lombok的插件，单纯只是引入了lombok的依赖你还是用不了的。
>
> ***
>
> ```java
> package Test.test.Controller;
> import lombok.Data;
> @Data
> public class User {
>     public int id;
>     public String name;
> }
> ```
>
> ```java
> package Test.test.Controller;
> import org.springframework.beans.factory.annotation.Autowired;
> import org.springframework.stereotype.Controller;
> @Controller
> public class UserController1 {
>     @Autowired
>     private User user;
>     public void fun1(){
>         User user1 = user;//把获取到的user对象赋值给user1
>         System.out.println(user1);
>         user1.setName("李四");
>         user1.setId(1);
>         System.out.println(user1);
>     }
> }
> ```
>
> 可以看到，我们的User类中是没有写任何的set方法的，只是用了@Data注解作为代替，让它替我们完成了这些工作。@Data注解是一个复合注解，它包含了@Getter，@Setter，@toString注解等等基本注解，使用起来会更方便。

> 示例：
>
> 被修改的Bean案例
>
> ![image-20230208162517487](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230208162517487.png) 
>
> > 可以看到，最后的结果是输出(张三，李四，李四)，而不是(张三，李四，张三)。因为Bean默认是单例作用域，也就是所有人取到的Bean对象都是同一份，所以在fun1中后面改了user1的属性，其实相当于Spring容器中的那个user对象的属性也随之改变了，所以在fun2中取用到的自然是修改后的结果。

***

##  4.2，Bean的6种作用域

###  singleton

> 单例作用域，该作用域下的Bean在IoC容器中只存在一个实例。也是Spring的默认作用域。

***

###  prototype

> 原型作用域，或者说是多例作用域，该作用域下的Bean的请求都会创建新的实例，也就是请求注入对象的时候获取到的是IoC容器中的对象的副本。

***

###  request

> 请求作用域，在每次的http请求下都会创建一个新的Bean实例，请求与响应共享一个Bean对象，限定于SpringMVC中使用。

***

###  session

> 会话作用域，在一个session中定义一个Bean实例，在这一个会话中共享，限定于SpringMVC中使用。

***

###  application

> 全局作用域，在一个servlet Context中定义一个Bean实例，限定于SpringMVC中使用。

***

###   webSocket

> 在一个http websocket的生命周期中定义一个Bean实例，限定于Spring WebSocket中使用。

***

> singleton与application比较：
>
> 1，singleton是Spring Core下的作用域，application是Spring Web中的作用域。
>
> 2，singleton限定于IoC容器，而application限定于Servlet容器。

***

##  4.3，设置Bean的作用域

> 使用@Scope注解来声明Bean的作用域
>
> ```java
> @Controller
> public class UserBeans {
>     //@Scope("prototype")
>     @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
>     @Bean
>     public User getUser(){
>         User user = new User();
>         user.setId(1);
>         user.setName("张三");
>         return user;
>     }
> }
> ```

> 有两种设置方式：
>
> 1，通过全局变量的方式设置，例如@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
>
> 2，直接设置值，例如@Scope("prototype")
>
> 其实两种方式是一样的，全局变量ConfigurableBeanFactory.SCOPE_PROTOTYPE的值其实就是"prototype"
>
> ![image-20230208202525151](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230208202525151.png) 

****

#  五，Spring的执行流程与Bean的生命周期

##  5.1，Spring的执行流程

> 1. 首先启动容器，也就是项目启动
> 2. 读取配置文件，根据配置文件中的信息(直接注册了Bean对象或者是配置了扫描路径)，初始化Bean对象
> 3. 将实例化好的Bean对象存储到Spring容器(存对象)
> 4. 将Bean对象装配到需要的类中(取对象)

***

##  5.2，Bean的生命周期

>Bean的生命周期指的是一个Bean对象从诞生到销毁的整个生命过程，这样的一整个过程称之为Bean的生命周期

> Bean的生命周期分为以下五个部分：
>
> - 实例化Bean(单纯为Bean分配内存空间，类似有JVM的类加载过程，都是完全的从无到有的一个过程)   【例如：买了一个毛坯房】
> - 设置属性(Bean注入和装配，对Bean对象的各个属性值进行设置) 【例如：购买房子的各种所需的装修材料】
> - Bean初始化 【例如：装修房子】
> - 使用Bean 【例如：入住房子】
> - 销毁Bean【例如：卖掉房子】

> 这里重点说一下Bean的初始化，又分为几个步骤，不过注意区分Bean的实例化与初始化，Bean的实例化只是分配了内存空间，相当于就是一个空壳
>
> - 执行各种Aware通知方法，例如BeanNameAware等的接口方法，相当于通知可以开始各种工作 【例如：打电话通知各个装修师傅可以准备工作，电工，水工等等】
>
> - 执行BeanPostProcessor初始化前置方法，也就是前置工作 【例如：装修师傅到地勘察，指定合理的装修计划】
>
> - 执行初始化方法 【例如：开始进行装修，只不过有两种师傅，一种是借助现代工具的，一种是利用老方法的装修师傅】
>
>   > 这里的初始化方法有两种，一种是使用现代化的@PostConstruct注解来进行初始化，或者使用老式的xml 执行自己指定的init-method方法进行初始化
>
> - 执行BeanPostProcessor初始化后置方法，也即是对象初始化好之后的后置工作  【例如：装修完成之后打扫房子】

> 单纯通过文字描述，难以描述清除过程，那么下面通过简单的代码验证以下过程：
>
> ```xml
> <?xml version="1.0" encoding="UTF-8"?>
> <beans xmlns="http://www.springframework.org/schema/beans"
>        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>        xmlns:content="http://www.springframework.org/schema/context"
>        xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
> <!--       <content:component-scan base-package="Test.test"></content:component-scan>-->
>        <bean id="beanLifeComponent" class="Test.test.BeanLifeComponent" init-method="init" destroy-method="destory" ></bean>
>        <bean id="myBeanPostProcessor" class="Test.test.MyBeanPostProcessor"></bean>
> </beans>
> ```
>
> ```java
> package Test.test;
> 
> import org.springframework.beans.factory.BeanNameAware;
> import org.springframework.stereotype.Component;
> 
> import javax.annotation.PostConstruct;
> import javax.annotation.PreDestroy;
> 
> @Component
> public class BeanLifeComponent implements BeanNameAware {
>     @Override
>     public void setBeanName(String s) {
>         System.out.println("执行通知");
>     }
> 
>     @PostConstruct
>     public void postConstruct(){
>         System.out.println("执行PostConstruct");
>     }
> 
>     public void init(){
>         System.out.println("执行init方法");
>     }
> 
>     public void destory(){
>         System.out.println("执行destory方法");
>     }
> 
>     @PreDestroy
>     public void PreDestory(){
>         System.out.println("执行PreDestory方法");
>     }
> }
> ```
>
> ```java
> package Test.test;
> 
> import org.springframework.beans.BeansException;
> import org.springframework.beans.factory.config.BeanPostProcessor;
> import org.springframework.stereotype.Component;
> @Component
> public class MyBeanPostProcessor implements BeanPostProcessor {
>     @Override
>     public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
>         if (beanName.equals("beanLifeComponent")) {//过滤一下
>             System.out.println("执行初始化前置方法");
>         }
>         return bean;
>     }
> 
>     @Override
>     public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
>         if (beanName.equals("beanLifeComponent")) {
>             System.out.println("执行初始化后置方法");
>         }
>         return bean;
>     }
> }
> 
> //这里注意，初始化的前置与后置方法是为所有的Bean对象服务的，所以需要一个单独的类来执行前置，后置方法。不能将其放在一个具体的Bean对象的类中
> ```
>
> ```java
> public class App {
>     //这是一个测试启动类
>     public static void main(String[] args) {
>         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
>         //ClassPathXmlApplicationContext 是ApplicationContext的子类，它有销毁容器的方法 可以帮助我们观察Bean的销毁
>         BeanLifeComponent beanLifeComponent = context.getBean("beanLifeComponent",BeanLifeComponent.class);
>         System.out.println("使用Bean");
>         context.destroy();//为了能观察到Bean销毁的过程 这是直接将容器销毁
>     }
> }
> ```
>
> 启动App类，我们就可以观察到一个BeanLifeComponent的Bean对象的整个创建到销毁的过程，如下：
>
> ![image-20230209163402211](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230209163402211.png) 
>
> 可以看到最终的结果，通过xml直接注册对象，指明自己定义的init-method与destory-method方法的结果与通过配置扫描路径，使用注解 @PostConstruct,@PreDestroy的方式的结果是不一样的，主要是在初始化方法以及最终销毁Bean执行的方法上不一样，其实这两种方式都可以达到最终的效果，只是技术的一个更迭而已，使用注解的方式无疑是更方便。

> 问题：设置属性为什么是先于初始化，二者能调换吗？
>
> ```java
> package Test.test.Component;
> import org.springframework.beans.factory.annotation.Autowired;
> import org.springframework.stereotype.Component;
> import javax.annotation.PostConstruct;
> 
> @Component
> public class AComponent {
>     @Autowired
>     private BComponent bComponent;
>     @PostConstruct
>     public void postConstruct(){
>         System.out.println("执行了AComponent的初始化方法");
>     }
> }
> ```
>
> ```java
> package Test.test.Component;
> import org.springframework.beans.factory.annotation.Autowired;
> import org.springframework.stereotype.Component;
> import javax.annotation.PostConstruct;
> 
> @Component
> public class BComponent {
>     @Autowired
>     private CComponent cComponent;
>     @PostConstruct
>     public void postConstruct(){
>         System.out.println("执行了BComponent的初始化方法");
>     }
> }
> ```
>
> ```java
> package Test.test.Component;
> import org.springframework.stereotype.Component;
> import javax.annotation.PostConstruct;
> 
> @Component
> public class CComponent {
>     @PostConstruct
>     public void postConstruct(){
>         System.out.println("执行了CComponent的初始化方法");
>     }
> }
> ```
>
> ```java
> public class App {
>     //这是一个测试启动类
>     public static void main(String[] args) {
>         ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
>         AComponent aComponent = context.getBean("AComponent",AComponent.class);
>     }
> }
> ```
>
> ![image-20230209171346941](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20230209171346941.png) 
>
> ***
>
> 可以看到，最终的结果是先执行了CComponent的初始化，然后是BComponent的初始化，最后才是AComponent。其实这就说明了是先设置属性，再执行的初始化，针对属性而言，它是属于这个Bean对象的，但是在这个Bean的构造过程中，是有可能会使用到该属性的，所以一定先把属性设置好了，才会去执行它的初始化，二者如果调换，那么当构造的时候使用到了属性就会报错了。
