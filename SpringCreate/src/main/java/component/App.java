package component;

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
//        component.Demo demo1 = (component.Demo) applicationContext.getBean("demo1");
//        component.Demo demo2 = (component.Demo) applicationContext.getBean("demo2");
        //3 使用Bean对象 可选
//        System.out.println(demo1.func());
//        System.out.println(demo2.func());
//        System.out.println(demo1==demo2);

        //component.Demo demo1 = (component.Demo) applicationContext.getBean("demo1");
//        component.Demo demo2 = applicationContext.getBean(component.Demo.class);
//        System.out.println(demo1==demo2);

        //component.Demo demo2 = applicationContext.getBean("demo1",component.Demo.class);



    }

    public static void main2(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringConfig.xml");
    }

    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("SpringConfig.xml"));
        Demo demo1 = beanFactory.getBean("demo1", Demo.class);
    }
}
