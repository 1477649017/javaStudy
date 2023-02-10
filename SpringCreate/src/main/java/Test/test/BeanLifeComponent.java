package Test.test;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-02-09
 * Time: 15:20
 */
@Component
public class BeanLifeComponent implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println("执行通知");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("执行PostConstruct");
    }

    public void init(){
        System.out.println("执行init方法");
    }

    public void destory(){
        System.out.println("执行destory方法");
    }

    @PreDestroy
    public void PreDestory(){
        System.out.println("执行PreDestory方法");
    }
}
