import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class JDBCTest {
    public static void main(String[] args) throws SQLException, ParseException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/JDBC?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("88888888");

        Connection connection = dataSource.getConnection();

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入书名：");
        String bookName = scan.next();
        scan.nextLine();//这个地方注意一定要吃掉回车，下面读取时间用的是nextLine(),不然回车会直接输入到日期里面去
        System.out.println("请输入出版日期:");
        String publishTime = scan.nextLine();


        String sql = "insert into book values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,bookName);
        //要将一个字符串形式的时间转换成时间类型然后放入数据库中
        //1,String转换为 java.util.Date
        java.util.Date time1 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间格式工具类
        time1 = simpleDateFormat.parse(publishTime);//将出版日期按照这个时间格式转换为java.util.Date类型

        //2,java.util.Date 转换为 java.sql.Date/java.sql.Timestamp
        //首先获取到这个时间的毫秒数,然后把这个毫秒数转换为 java.sql.Date
        Long time2 = time1.getTime();//距离1970-01-01 00：00：00的毫秒数
        java.sql.Timestamp publish_Time = new Timestamp(time2);
        preparedStatement.setTimestamp(2,publish_Time);

        //java.sql.Date publish_Time = new Date(time2);
        //preparedStatement.setDate(2,publish_Time);

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }
}
