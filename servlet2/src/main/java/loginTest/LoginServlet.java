package loginTest;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-11-23
 * Time: 21:45
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //这个类用来接收来自于login.html 的请求 登录请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从请求中获取到用户名与密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //假设这里规定用户名是张三 密码是1234
        if("张三".equals(username) && "1234".equals(password)){

        }
    }
}
