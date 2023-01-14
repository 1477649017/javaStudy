import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-14
 * Time: 17:04
 */
public class FirstAutoTest {
    //编写自动化测试脚本
    public void test() throws InterruptedException {
        //测试方法 打开百度 搜索csdn
        ChromeDriver chromeDriver = new ChromeDriver();//创建驱动
        Thread.sleep(3000);
        chromeDriver.get("https://www.baidu.com/");//进入bing搜索
        Thread.sleep(3000);
        //选取输入框元素 依据是css的id选择器 在其中输入csdn  具体id是啥查看前端代码
        chromeDriver.findElement(By.cssSelector("#kw")).sendKeys("蔡徐坤");
        Thread.sleep(3000);
        chromeDriver.findElement(By.cssSelector("#su")).click();//点击搜索按钮
        Thread.sleep(3000);
        chromeDriver.quit();//关闭浏览器

    }

    public void test2(){
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.baidu.com/");
        List<WebElement> web = chromeDriver.findElements(By.className("title-content"));//通过类名定位
        for (WebElement webElement:web) {
            System.out.println(webElement.getText());//获取每一个元素的文本内容
        }
        chromeDriver.quit();

    }

}
