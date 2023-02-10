package Test.test.Controller;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-02-08
 * Time: 15:51
 */
@Controller
public class UserBeans {
    //@Scope("prototype")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }
}
