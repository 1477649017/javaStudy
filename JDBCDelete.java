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
 * Date: 2022-08-09
 * Time: 21:25
 */
public class JDBCDelete {
    public static void main(String[] args) throws SQLException {
        //创建数组源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/javaTest?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("88888888");

        //建立连接
        Connection connection = dataSource.getConnection();

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入要删除学生的id:");
        int id = scan.nextInt();


        //构造要执行的sql
        String sql = "delete from student where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        //执行
        int ret = preparedStatement.executeUpdate();
        System.out.println(ret);

        //关闭资源
        preparedStatement.close();
        connection.close();
    }
}
