package BookDao;

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
 * Date: 2022-12-08
 * Time: 16:50
 */
public class DBUtil {
    //用来封装数据库的连接
    private static volatile DataSource dataSource = null;
    public static DataSource getDataSource(){
        if(dataSource == null){
            synchronized (DBUtil.class){
                if(dataSource == null){
                    //开始创建连接
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/bookManagement?characterEncoding=utf8&useSSL=false");
                    ((MysqlDataSource)dataSource).setUser("root");
                    ((MysqlDataSource)dataSource).setPassword("1234");
                }
            }
        }
        return dataSource;
    }
    //私有化构造方法
    private DBUtil(){};

    //封装获取连接的方法
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    //封装一个关闭资源的方法
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        //这几个资源的关闭顺序是和它的创建顺序相反的
        //关闭资源的几个if分开写，不要套在一个try catch中 分开写一个抛异常不影响其他的资源关闭，但是写在一起一个抛异常就会直接走catch就会影响其他的资源关闭
        //影响资源关闭，可能就会造成了资源泄露 资源泄露是很严重的错误
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
