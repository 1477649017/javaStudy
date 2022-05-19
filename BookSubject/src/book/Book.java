package book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 17:31
 */
public class Book {
    private String name;//书名
    private String author;//作者
    private int price;//价格
    private String type;//书的类型
    private boolean isBorrowed;//是否被借出

    public Book(String name, String author, int price, String type) {//构造方法
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Book:" +
                "name='" + name + '\'' +
                "\tauthor='" + author + '\'' +
                "\tprice=" + price +
                "\ttype='" + type + '\'' +
                "\tisBorrowed=" + ((isBorrowed == false)? "未借出" : "已借出")
                ;
    }
}
