import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-09
 * Time: 21:42
 */
public class JDBCSelect {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/javaTest?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("88888888");

        Connection connection = dataSource.getConnection();

        String sql = "select * from student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet set = preparedStatement.executeQuery();

        while(set.next()){
            int id = set.getInt("id");
            String name = set.getString("name");
            System.out.println("id = " + id + " " + "name = " + name);
        }

        preparedStatement.close();
        connection.close();
    }
}
