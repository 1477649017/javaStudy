package Test.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-02-08
 * Time: 15:56
 */
@Controller
public class UserController2 {
    @Autowired
    private User user;
    public void fun2(){
        System.out.println(user);
    }
}
