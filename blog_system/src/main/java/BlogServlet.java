import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-11-25
 * Time: 18:45
 */
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private static ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BlogDao blogDao = new BlogDao();
        List<Blog> blogs = blogDao.selectAll();//获取所有的博客
        resp.setContentType("application/json;charset=utf8");
        //关闭时间戳功能
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //转换时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //让mapper指定时间日期格式为SimpleDateFormat
        objectMapper.setDateFormat(sdf);
        resp.getWriter().write(objectMapper.writeValueAsString(blogs));
    }
}
