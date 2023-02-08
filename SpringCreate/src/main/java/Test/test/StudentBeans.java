package Test.test;

import Test.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-16
 * Time: 20:35
 */
@Component
public class StudentBeans {
    @Bean
    public Student student1(){
        Student stu = new Student();
        stu.setId(1);
        stu.setName("张三");
        return stu;
    }

    @Bean
    public Student student2(){
        Student stu = new Student();
        stu.setId(1);
        stu.setName("张三");
        return stu;
    }
}
