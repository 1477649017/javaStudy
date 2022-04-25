
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-04-25
 * Time: 9:42
 */
import java.io.Console;
public class TestDemo220425 {
    public static void main(String[] args) {
        Console cons = System.console();
        String username = cons.readLine("User name: ");
        char[] passwd = cons.readPassword("Password:");
    }
    public static void main1(String[] args) {
        int a = 0xffffffff;

        //System.out.printf("%tT",new Date());
        //System.out.printf("%s %tB %te","Due date",new Date(),new Date());
        System.out.printf("%1$s %2$tB %2$te %2$tY","Due date",new Date());
    }
}
