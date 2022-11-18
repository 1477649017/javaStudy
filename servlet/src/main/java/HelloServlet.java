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
 * Date: 2022-11-15
 * Time: 20:24
 */


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这个自动生成的调用父类doGet方法的代码一定要注释掉，不然就会出问题
        //super.doGet(req, resp);

        //Tomcat中打印一个日志
        System.out.println("hello world");
        //给客户端写回一个响应
        resp.getWriter().write("hello world");
    }

}
