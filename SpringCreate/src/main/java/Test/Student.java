package Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-16
 * Time: 20:29
 */
public class Student {
    public int id;
    public String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test.Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
