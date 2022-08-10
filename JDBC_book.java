import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-10
 * Time: 10:03
 */
public class JDBC_book {
    public static void insertforCategory(Connection connection) throws SQLException {
        //对类别表进行插入
        String sql = "insert into category values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        String[] arr = new String[]{"历史","艺术","计算机","数学","小说"};
        for (int i = 0; i < arr.length; i++) {
            preparedStatement.setInt(1,i+1);
            preparedStatement.setString(2,arr[i]);
            preparedStatement.executeUpdate();//进行执行
        }
        preparedStatement.close();
    }

    public static void insertforStudent(Connection connection) throws SQLException {
        //对类别表进行插入
        String sql = "insert into student values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        String[] arr = new String[]{"王昭君","李白","貂蝉","小乔","韩信"};
        for (int i = 0; i < arr.length; i++) {
            preparedStatement.setInt(1,i+1);
            preparedStatement.setString(2,arr[i]);
            preparedStatement.executeUpdate();//进行执行
        }
        preparedStatement.close();
    }


    public static Timestamp getTimestamp(String dateString) throws ParseException {
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
        return new java.sql.Timestamp(date.getTime());
    }

    public static void test1(Connection connection) throws SQLException, ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入借阅人姓名：");
        String stu_name = scan.next();
        System.out.println("请输入借阅的书籍名:");
        String book_name = scan.next();

        //根据姓名查询学生id
        String sql1 = "select id from student where name = ?";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        preparedStatement1.setString(1,stu_name);
        ResultSet set1 = preparedStatement1.executeQuery();
        int id1 = 0;
        while(set1.next()){
            id1 = set1.getInt("id");
        }

        //根据书名查询书籍id
        String sql2 = "select id from book where name = ?";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setString(1,book_name);
        ResultSet set2 = preparedStatement1.executeQuery();
        int id2 = 0;
        while(set2.next()){
            id2 = set2.getInt("id");
        }

        //现在可以进行插入一条新的记录了
        String sql3 =  "insert into borrow_info values(null,?,?,?,?)";
        PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
        preparedStatement3.setInt(1,id2);
        preparedStatement3.setInt(2,id1);
        preparedStatement3.setTimestamp(3,getTimestamp("2019-09-25 17:50:00"));
        preparedStatement3.setTimestamp(4,getTimestamp("2019-10-25 17:50:00"));
        preparedStatement3.executeUpdate();


    }

    public static void test2(Connection connection) throws SQLException {
        //查询计算机分类下的图书借阅信息
        String sql = "select * from borrow_info where book_id in (select book.id from category,book where category.id = book.category_id and category.id = 3)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet set = preparedStatement.executeQuery();
        while(set.next()){
            int id = set.getInt("id");
            int book_id = set.getInt("book_id");
            int student_id = set.getInt("student_id");
            Timestamp start_time = set.getTimestamp("start_time");
            Timestamp end_time = set.getTimestamp("end_time");
            System.out.println(" id = " + id + " book_id = " + book_id + " student_id = " + student_id + " start_time = " + start_time + " end_time = " + end_time);
        }
        preparedStatement.close();
    }

    public static void test3(Connection connection) throws SQLException {
        String sql = "update book set price = 61.20 where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"深入理解Java虚拟机");
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void test4(Connection connection) throws SQLException {
        String sql = "delete from borrow_info order by id desc limit 1";//不给offset默认就是从偏移量为0开始
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void main(String[] args) throws SQLException, ParseException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/ebook?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("88888888");

        Connection connection = dataSource.getConnection();
        insertforCategory(connection);//对类别表进行插入数据
        insertforStudent(connection);//对学生表进行插入数据

        //新增貂蝉同学的借阅记录
        test1(connection);

        //查询计算机分类下的借阅信息
        test2(connection);

        //修改图书《深入理解Java虚拟机》的价格为61.20
        test3(connection);

        //删除id最大的一条借阅记录
        test4(connection);


    }
}
