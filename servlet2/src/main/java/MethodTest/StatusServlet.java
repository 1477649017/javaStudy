package MethodTest;

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
 * Time: 21:29
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //给响应设置状态码 假设我们约定根据query string中的type来决定
        String type = req.getParameter("type");
        if(type.equals("1")){
            resp.setStatus(200);
        }else if(type.equals("2")){
            resp.setStatus(400);
            resp.sendError(400);
        }else if(type.equals("3")){
            resp.setStatus(500);
        }
    }
}
