package Test.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-02-08
 * Time: 15:50
 */
@Controller
public class UserController1 {
    @Autowired
    private User user;
    public void fun1(){
        User user1 = user;//把获取到的user对象赋值给user1
        System.out.println(user1);
        user1.setName("李四");
        user1.setId(1);
        System.out.println(user1);
    }
}
