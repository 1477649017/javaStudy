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
 * Date: 2022-11-19
 * Time: 11:02
 */
@WebServlet("/test")
public class HelloTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("UTF-8");//设置服务器这边字符集是utf8
//        resp.setHeader("Content-type","text/html;charset=utf-8");//设置响应header中的Content-type为utf8，告诉网页要怎么解析响应

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("根据Get请求写回的响应");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("根据Post请求写回的响应");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("根据Delete请求写回的响应");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("根据Put请求写回的响应");
    }
}
