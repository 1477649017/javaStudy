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
    @Bean(name = {"stu1"})
    //@Bean({"stu1","stu2"}) 简写方法
    public Student getStudent(){
        //这里是伪代码 真实是不会new对象的 一般是查询数据库返回对象
        Student stu = new Student();
        stu.setId(1);
        stu.setName("张三");
        return stu;
    }
}
