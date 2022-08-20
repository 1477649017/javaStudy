import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-08-15
 * Time: 8:34
 */

//4，使用匿名内部实现Runnable接口

public class Demo4 {
    public static void main(String[] args) {
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("hello thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t4.start();

        while(true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
