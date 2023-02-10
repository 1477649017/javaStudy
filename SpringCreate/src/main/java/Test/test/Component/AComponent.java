package Test.test.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-02-09
 * Time: 16:46
 */
@Component
public class AComponent {
    @Autowired
    private BComponent bComponent;
    @PostConstruct
    public void postConstruct(){
        System.out.println("执行了AComponent的初始化方法");
    }
}
