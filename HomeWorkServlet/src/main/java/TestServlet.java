import com.fasterxml.jackson.databind.ObjectMapper;

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
 * Date: 2022-11-24
 * Time: 16:34
 */

class Data {
    public int a;
    public int b;
}
@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        ObjectMapper objectMapper = new ObjectMapper();
        Data data = objectMapper.readValue(req.getInputStream(),Data.class);
        System.out.println(data.a);
        System.out.println(data.b);
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write(data.a);
    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf8");
//        String a = req.getParameter("a");
//        String b = req.getParameter("b");
//        resp.setContentType("text/html;charset=utf8");
//        resp.getWriter().write(a + " : " + b);
//    }
}
