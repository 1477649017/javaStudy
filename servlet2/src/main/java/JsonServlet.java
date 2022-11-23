import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-11-21
 * Time: 18:39
 */
class Score {
    public ArrayList<Integer> scores;

    @Override
    public String toString() {
        return "scores : " + scores;
    }
}
class Course{
    //这个类的两个重点
    //这个类里面的属性务必是public或者是提供public的getter与setter，不然jackson就无法访问到这个对象属性
    //必须提供无参的构造方法
    public int courseId;
    public String courseName;
    public String teacherName;
    public Score score;
}
@WebServlet("/json")
public class JsonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //假设body中的数据形如{ "courseId" : 1 ,"courseName" : "英语"}
        //对于Jackson这个库，我们主要注意一个类和两个方法
        req.setCharacterEncoding("utf8");
        ObjectMapper objectMapper = new ObjectMapper();
        //readValue方法把json格式数据转化成java对象
        //writeValueAsString 把java对象转换成json格式的字符串
        Course course = objectMapper.readValue(req.getInputStream(),Course.class);
        System.out.println(course.courseId);
        System.out.println(course.courseName);


        //返回text/html格式
//        resp.setContentType("text/html;charSet=utf8");
//        resp.getWriter().write(course.courseId + " : " + course.courseName + " : " + course.score);

        //返回json格式的字符串
        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(objectMapper.writeValueAsString(course));
    }
}
