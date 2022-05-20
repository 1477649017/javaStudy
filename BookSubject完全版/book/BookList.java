package book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 17:31
 */
public class BookList {
    Book[] book = new Book[10];//假设初始最多就只放10本书
    private int usedSize;//记录数组中元素的个数，也就是书的本数

    public BookList() {
        book[0] = new Book("三国演义","罗贯中",29,"小说");
        book[1] = new Book("西游记","吴承恩",30,"小说");
        book[2] = new Book("红楼梦","曹雪芹",22,"小说");
        usedSize = 3;//初始化数组中放有三本书
    }

    public int getUsedSize() {
        return usedSize;//实时取到数组元素的个数
    }

    public void setUsedSize(int Size) {
        this.usedSize = Size;//实时设置数组元素的个数
    }

    public Book getBook(int pos){
        return book[pos];//根据下标返回对应位置上的书
    }

    public void setBook(int pos,Book tmpBook){
        book[pos] = tmpBook;//将某一本新书添加到我们的数组中
    }
}
