package MethodTest;

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
 * Date: 2022-11-20
 * Time: 22:02
 */
@WebServlet("/request")
public class GetRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //开始拆解请求中的信息
        StringBuilder stringBuilder = new StringBuilder();//利用一个stringBuilder来存储信息
        //1,获取协议名版本号
        stringBuilder.append(req.getProtocol());
        stringBuilder.append("\n");
        //2,获取方法名
        stringBuilder.append(req.getMethod());
        stringBuilder.append("\n");
        //3,获取URI
        stringBuilder.append(req.getRequestURI());
        stringBuilder.append("\n");
        //4,获取RUL 不包含参数
        stringBuilder.append(req.getRequestURL().toString());
        stringBuilder.append("\n");
        //5,获取Context-Path
        stringBuilder.append(req.getContextPath());
        stringBuilder.append("\n");
        //6,获取查询字符串
        stringBuilder.append(req.getQueryString());
        stringBuilder.append("\n");
        //7,更精细的获取查询字符串中的内容
        Enumeration<String> enumeration = req.getParameterNames();//以查询字符串中的键作为枚举对象
        while (enumeration.hasMoreElements()){
            String key = enumeration.nextElement();
            String value = req.getParameter(key);//根据键获取值
            //String[] value = req.getParameterValues(key);//如果一个键有多个值，那么就用这个返回一个字符串数组
            stringBuilder.append(key + " : " + value);
            stringBuilder.append("\n");
        }

        //8,获取header中的具体内容
        Enumeration<String> enumeration1 = req.getHeaderNames();//获取到一个枚举对象
        while (enumeration1.hasMoreElements()){
            String key = enumeration1.nextElement();
            String value = req.getHeader(key);
            stringBuilder.append(key + " : " + value);
            stringBuilder.append("\n");
        }

        //9,获取body中使用的字符编码集
        stringBuilder.append(req.getCharacterEncoding());
        stringBuilder.append("\n");
        //10,获取body中的数据类型
        stringBuilder.append(req.getContentType());
        stringBuilder.append("\n");
        //11,以字节为单位，获取请求body的长度
        stringBuilder.append(req.getContentLength());
        stringBuilder.append("\n");

        resp.getWriter().write(stringBuilder.toString());
    }
}
