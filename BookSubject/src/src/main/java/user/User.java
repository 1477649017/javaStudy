package user;


import operation.Ibookoperatortion;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-19
 * Time: 18:14
 */
public abstract class User {
    protected String name;//用户名
    public Ibookoperatortion[] ioperation;
    public User(String name) {//构造方法
        this.name = name;
    }

    public abstract int menu();//抽象方法无需具体实现，在实现类里面具体实现

    public void doOperation(int choice){//与主函数不在同一个包，也不是子类关系，所以设置成public
        ioperation[choice].doBook();
    }

}
