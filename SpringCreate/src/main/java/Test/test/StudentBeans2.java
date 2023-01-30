package Test.test;

import Test.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2023-01-17
 * Time: 10:31
 */
@Component
public class StudentBeans2 {
    @Bean(name = {"stu2"})
    public Student getStudent(){
        //这里是伪代码 真实是不会new对象的 一般是查询数据库返回对象
        Student stu = new Student();
        stu.setId(2);
        stu.setName("李四");
        return stu;
    }
}
