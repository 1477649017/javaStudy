import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-11-22
 * Time: 10:22
 */
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();//无论是读取数据还是写回数据都要用到
    // private List<Message> list = new ArrayList<>();//创建一个list来保存每一条数据 把数据保存在数据库就不需要这个了

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //负责返回数据给前端
        resp.setContentType("application/json;charset=utf8");
        List<Message> list = null;//从数据库加载数据
        try {
            list = load();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String mes = objectMapper.writeValueAsString(list);//将list中保存的数据转换成json字符串
        resp.getWriter().write(mes);//把响应写回给前端
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //负责接收前端提交过来的数据
        req.setCharacterEncoding("utf8");
        Message message = objectMapper.readValue(req.getInputStream(),Message.class);//读取提交的数据并且转换为java对象
        //list.add(message);//保存每一个数据对象
        try {
            save(message);//把数据保存进数据库
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setStatus(200);//给响应设置一下状态码，表示提交成功了 这里的响应不需要包含啥数据
        System.out.println("提交数据成功! from:" + message.from + " to:" + message.to + " message:" + message.message);
    }

    private void save(Message list) throws SQLException {
        //将数据保存进数据库
        //1 创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/servlet?characterEncoding=utf8&useSSL=false");
        //2 设置用户名密码
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");

        //3 创建连接 Connection使用java.sql中的
        Connection connection = dataSource.getConnection();

        //4 构造sql
        String sql = "insert into message values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,list.from);
        preparedStatement.setString(2,list.to);
        preparedStatement.setString(3,list.message);

        //5 执行sql
        int result = preparedStatement.executeUpdate();
        System.out.println("result = " + result);

        //6 关闭连接
        preparedStatement.close();
        connection.close();
    }

    private List<Message> load() throws SQLException {
        //从数据库中查询出数据
        //1 创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/servlet?characterEncoding=utf8&useSSL=false");
        //2 设置用户名密码
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");

        //3 创建连接 Connection使用java.sql中的
        Connection connection = dataSource.getConnection();

        String sql = "select * from message";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        //遍历结果集
        List<Message> ret = new ArrayList<>();
        while (resultSet.next()){
            //获取数据并设置对象属性
            Message mes = new Message();
            mes.from = resultSet.getString("from");
            mes.to = resultSet.getString("to");
            mes.message = resultSet.getString("message");
            ret.add(mes);
        }

        //关闭连接
        preparedStatement.close();
        connection.close();
        return ret;//返回结果
    }
}
