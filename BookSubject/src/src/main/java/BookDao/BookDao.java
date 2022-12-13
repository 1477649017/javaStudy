package BookDao;

import book.Book;

import java.math.BigDecimal;
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
 * Date: 2022-12-08
 * Time: 16:49
 */
public class BookDao {
    //这个类主要是用来操作数据库获取书籍
    //1，增加书籍
    public void insertBook(Book book){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            //构造sql
            String sql = "insert into book values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,book.getName());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setDouble(3,book.getPrice());
            preparedStatement.setString(4,book.getType());
            preparedStatement.setString(5,"false");
            int ret = preparedStatement.executeUpdate();
            if(ret != 1){
                System.out.println("新增失败!");
            }else {
                System.out.println("新增成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
    }
    //2，删除书籍
    public void deleteBook(String name){
        //根据名字进行删除
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            //构造sql
            String sql = "delete from book where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            int ret = preparedStatement.executeUpdate();
            if(ret != 1){
                System.out.println("删除失败!");
            }else{
                System.out.println("删除成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
    }
    //3，查找指定的书籍
    public Book SelectOneBook(String name){
        //根据名字进行查找
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            //构造sql
            String sql = "select * from book where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String bookName = resultSet.getString("name");
                String author = resultSet.getString("author");
                double price  = resultSet.getDouble("price");
                String type = resultSet.getString("type");
                String borrowed = resultSet.getString("isBorrowed");
                boolean isBorrowed = false;
                if(borrowed.equals("true")){
                    isBorrowed = true;
                }
                Book book = new Book(bookName,author,price,type,isBorrowed);
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return null;
    }
    //4，查询所有的书籍
    public List<Book> SelectAllBook(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Book> list = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            //构造sql
            String sql = "select * from book";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String bookName = resultSet.getString("name");
                String author = resultSet.getString("author");
                double price  = resultSet.getDouble("price");
                String type = resultSet.getString("type");
                String borrowed = resultSet.getString("isBorrowed");
                boolean isBorrowed = false;
                if(borrowed.equals("true")){
                    isBorrowed = true;
                }
                Book book = new Book(bookName,author,price,type,isBorrowed);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return list;
    }

    //5，更新借阅信息
    public void updateInfo(String name,String info){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            //构造sql
            String sql = "update book set isBorrowed = ? where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,info);
            preparedStatement.setString(2,name);
            int ret = preparedStatement.executeUpdate();
            if(ret != 1){
                System.out.println("更新失败!");
            }else{
                System.out.println("更新成功!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
    }
}
