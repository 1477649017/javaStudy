package Test.Service;

import Test.Controller.User;
import Test.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Controller.User: 14776
 * Date: 2023-02-07
 * Time: 22:34
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(){
        return userRepository.getUser();
    }
}
