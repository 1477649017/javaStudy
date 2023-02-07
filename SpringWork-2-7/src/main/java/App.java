import Test.Controller.User;
import Test.Controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Controller.User: 14776
 * Date: 2023-02-07
 * Time: 21:55
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringConfig.xml");
        UserController userController = applicationContext.getBean("userController",UserController.class);
        User user = userController.getUser();
        System.out.println(user);
    }
}
