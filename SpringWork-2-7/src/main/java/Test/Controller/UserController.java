package Test.Controller;

import Test.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Controller.User: 14776
 * Date: 2023-02-07
 * Time: 22:33
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public User getUser(){
        return userService.getUser();
    }
}
