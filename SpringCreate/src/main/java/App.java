import Test.test.BController;
import Test.test.BeanLifeComponent;
import Test.test.Component.AComponent;
import Test.test.Controller.StudentController;
import Test.test.Controller.UserController1;
import Test.test.Controller.UserController2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-12
 * Time: 22:21
 */
public class App {
    //这是一个测试启动类
    public static void main1(String[] args) {
        //1 获取Spring的上下文对象
//        ApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("SpringConfig.xml");
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("SpringConfig.xml"));
        //2 从Spring上下文对象中获取Bean对象
//        Demo demo1 = (Demo) applicationContext.getBean("demo1");
//        Demo demo2 = (Demo) applicationContext.getBean("demo2");
        //3 使用Bean对象 可选
//        System.out.println(demo1.func());
//        System.out.println(demo2.func());
//        System.out.println(demo1==demo2);

        //Demo demo1 = (Demo) applicationContext.getBean("demo1");
//        Demo demo2 = applicationContext.getBean(Demo.class);
//        System.out.println(demo1==demo2);

        //Demo demo2 = applicationContext.getBean("demo1",Demo.class);



    }

    public static void main2(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("SpringConfig.xml"));
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringConfig.xml");
        BController bController = beanFactory.getBean("Test.test.BController", BController.class);
        bController.func();

//        AComponent aComponent = beanFactory.getBean("Test.test.AComponent",AComponent.class);
//        aComponent.func();
    }

    public static void main3(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("SpringConfig.xml"));
        Demo demo1 = beanFactory.getBean("demo1", Demo.class);
    }

    public static void main4(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringConfig.xml");
//        Student student = applicationContext.getBean("getStudent", Student.class);
//        System.out.println(student);
//        Student student1 = applicationContext.getBean("stu1", Student.class);
//        Student student2 = applicationContext.getBean("stu2", Student.class);
//        System.out.println(student1);
//        System.out.println(student2);
    }

    public static void main5(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringConfig.xml");
        StudentController studentController = applicationContext.getBean("studentController",StudentController.class);
        studentController.func();
    }

    public static void main6(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        UserController1 userController1 = context.getBean("userController1",UserController1.class);
        UserController2 userController2 = context.getBean("userController2",UserController2.class);
        userController1.fun1();
        userController2.fun2();
    }

    public static void main7(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        BeanLifeComponent beanLifeComponent = context.getBean("beanLifeComponent",BeanLifeComponent.class);
        System.out.println("使用Bean");
        context.destroy();//为了能观察到Bean销毁的过程 这是直接将容器销毁
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        AComponent aComponent = context.getBean("AComponent",AComponent.class);
    }

}
