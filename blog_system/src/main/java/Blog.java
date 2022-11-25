import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-11-25
 * Time: 14:44
 */
//+--------+--------------+---------------------------+---------------------+--------+
//| blogId | title        | content                   | postTime            | userId |
//+--------+--------------+---------------------------+---------------------+--------+
//具体有关数据库时间类型的参数的使用可以去看博客中有讲 https://blog.csdn.net/qq_61688804/article/details/126317089?spm=1001.2014.3001.5501

public class Blog {
    private int blogId;
    private String title;
    private String content;
    //注意 mysql中的datetime timestamp类型在java中对应的是java.sql.Date java.sql.Timestamp 只不过Date不能获取到时分秒，但是Timestamp可以
    private Timestamp postTime;
    private int userId;

    //提供get set方法

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
