package MethodTest;

import sun.security.jgss.HttpCaller;

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
 * Date: 2022-11-21
 * Time: 22:39
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置重定向
        //方法1，设置header中的Location的值
//        resp.setStatus(302);//重定向状态码
//        resp.setHeader("Location","http://www.baidu.com");
        //方法2，sendRedirect()直接发送重定向响应到客户端
        resp.sendRedirect("http://www.baidu.com");
    }
}
