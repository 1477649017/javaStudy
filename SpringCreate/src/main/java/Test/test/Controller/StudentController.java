package Test.test.Controller;
import Test.Student;
import Test.test.AComponent;
import Test.test.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

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
//    @Autowired
//    private StudentService studentService;
//    @Autowired
//    private AComponent aComponent;

    //set注入
//    private StudentService studentService;
//    private AComponent aComponent;
//
//    @Autowired
//    public void setStudentService(StudentService studentService) {
//        this.studentService = studentService;
//    }
//    @Autowired
//    public void setaComponent(AComponent aComponent) {
//        this.aComponent = aComponent;
//    }
    //构造方法注入
//    private StudentService studentService;
//    private AComponent aComponent;
//
//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    @Autowired
//    public StudentController(AComponent aComponent) {
//        this.aComponent = aComponent;
//    }

//    @Autowired
//    public StudentController(StudentService studentService,AComponent aComponent) {
//        this.aComponent = aComponent;
//        this.studentService = studentService;
//    }


    //@Resuorce注入
//    @Resource
//    private StudentService studentService;
//
//    @Resource
//    public void setStudentService(StudentService studentService) {
//        this.studentService = studentService;
//    }
//    public void sayHi(){
//        studentService.sayHi();
//    }


    //使用@Resource
    //@Resource(name = "student1")
    @Autowired
    @Qualifier("student1")
    private Student student;

//    @Resource(name = "student1")
//    private Student student;
    public void func(){
        System.out.println(student);
    }
}
