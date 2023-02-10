package Test.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-02-09
 * Time: 16:12
 */
//@Component
//public class MyBeanPostProcessor implements BeanPostProcessor {
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if (beanName.equals("beanLifeComponent")) {//过滤一下
//            System.out.println("执行初始化前置方法");
//        }
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if (beanName.equals("beanLifeComponent")) {
//            System.out.println("执行初始化后置方法");
//        }
//        return bean;
//    }
//}
