package demo5;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-18
 * Time: 19:51
 */
class Boy implements Cloneable{
    public int age = 10;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public Boy boy = new Boy();//也就是说Person类的实例成员是一个引用类型的变量
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person tmp = (Person)super.clone();
        tmp.boy = (Boy)(tmp.boy.clone());//也可以用tmp.boy = (Boy)(this.clone())
        return tmp;
    }
}
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person per1 = new Person();
        Person per2 = (Person)per1.clone();
        System.out.println("修改前：" + per1.boy.age + " " + per2.boy.age);
        per1.boy.age = 20;
        System.out.println("修改后：" + per1.boy.age + " " + per2.boy.age);
    }
}
