package Test.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Controller.User: 14776
 * Date: 2023-02-07
 * Time: 22:32
 */
public class User {
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Controller.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
