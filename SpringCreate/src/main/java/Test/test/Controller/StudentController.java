package Test.test.Controller;

import Test.test.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-17
 * Time: 11:01
 */
@Controller
public class StudentController {
    //属性注入 将studentService对象获取到
    @Autowired
    private StudentService studentService;

    public void sayHi(){
        //要去调用Service的sayHi方法 所以这里必须获取到Service层的对象
        studentService.sayHi();
    }
}
