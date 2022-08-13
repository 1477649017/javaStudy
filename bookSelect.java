import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bookSelect {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/JDBC?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("88888888");

        Connection connection = dataSource.getConnection();

        String sql = "select publishTime from book where bookName = 'vvv'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            java.sql.Timestamp date1 = resultSet.getTimestamp("publishTime");
            java.sql.Date date2 = resultSet.getDate("publishTime");
            System.out.println(date1);
            System.out.println(date2);

        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
