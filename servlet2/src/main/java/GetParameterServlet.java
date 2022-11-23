import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-11-21
 * Time: 11:20
 */
@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {
    //Get请求的参数一般都是放在query string 这里我们重点关注query string中的内容
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取query string中的键值对
        //加入query string形如 ?courseId=1&&courseName=高数
        String courseId = req.getParameter("courseId");
        String courseName =req.getParameter("courseName");
        System.out.println(courseId);
        System.out.println(courseName);
        resp.setContentType("text/html;charset=utf8");//设置一下数据格式与字符集,告诉浏览器要怎么解析数据
        resp.getWriter().write(courseId + " : " + courseName);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取body中的键值对信息
        req.setCharacterEncoding("utf8");
        String courseId = req.getParameter("courseId");
        String courseName =req.getParameter("courseName");
        System.out.println(courseId);
        System.out.println(courseName);
        resp.setContentType("text/html;charset=utf8");//设置一下数据格式与字符集,告诉浏览器要怎么解析数据
        resp.getWriter().write(courseId + " : " + courseName);
    }
}
