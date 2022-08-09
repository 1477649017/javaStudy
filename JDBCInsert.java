import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-08
 * Time: 14:46
 */

//jdbc:mysql://127.0.0.1:3306/javaTest?characterEncoding=utf8&useSSL=false
public class JDBCInsert {
    //通过JDBC来操作数据库，往数据库里面插入一条数据
    //数据库 javaTest 表 student
    public static void main(String[] args) throws SQLException {
        //1，创建数据源对象。数据源对象描述了我们的数据库是哪一个，在哪
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/javaTest?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("88888888");

        //2，让代码与我们的数据库建立连接
        Connection connection = dataSource.getConnection();
        //System.out.println(connection);

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你想要插入的学生的id:");
        int id = scan.nextInt();
        System.out.println("请输入你想要插入的学生的name:");
        String name = scan.next();

        //3，构造要执行的sql语句
        String sql1 = "insert into student values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        int result = preparedStatement.executeUpdate();
        System.out.println(result);

        //4，释放相关资源
        preparedStatement.close();
        connection.close();

    }
}
