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
        resp.setContentType("application/json;charset=utf8");
        //现在有个问题就是博客详情页 博客列表页都要使用get请求，所以在这个方法里面需要我们去做出区分 区分的依据就是query string
        String blogId = req.getParameter("blogId");
        if(blogId == null){
            //就是博客列表页
            List<Blog> blogs = blogDao.selectAll();//获取所有的博客
            resp.getWriter().write(objectMapper.writeValueAsString(blogs));
        }else{
            //博客详情页
            Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
            resp.getWriter().write(objectMapper.writeValueAsString(blog));
        }

    }
}
