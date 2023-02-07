package Test.Repository;

import Test.Controller.User;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Controller.User: 14776
 * Date: 2023-02-07
 * Time: 22:34
 */
@Repository
public class UserRepository {
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }
}
