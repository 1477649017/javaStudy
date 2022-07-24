package reflectDemo;


import reflectDemo.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-24
 * Time: 15:41
 */
//开始在类外使用反射
public class Test {

    //1，通过反射创建对象
    public static void reflectNewInstance(){
        try {
            Class<?> class1 = Class.forName("reflectDemo.Student");
            Student student = (Student) class1.newInstance();
            System.out.println(student);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //2，反射获取构造方法
    public static void reflectConstruct(){
        try {
            Class<?> class1 = Class.forName("reflectDemo.Student");
            Constructor<?> constructor  = class1.getDeclaredConstructor(String.class,int.class);//返回一个构造器对象
            constructor.setAccessible(true);//必须set为true
            //这个地方因为你是想调用的私有的，本来是拿不到的，但是现在拿到了，编译器需要你确认是不是要调用。不写会报异常
            Student student = (Student) constructor.newInstance("lisi",20);
            System.out.println(student);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    //3，反射获取修改字段属性
    public static void reflectFiled(){
        try {
            Class<?> class1 = Class.forName("reflectDemo.Student");
            Student student = (Student) class1.newInstance();
            Field field = class1.getDeclaredField("name");
            field.setAccessible(true);

            field.set(student,"wangwu");
            System.out.println(student);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void reflectMethod(){
        try {
            Class<?> class1 = Class.forName("reflectDemo.Student");
            Student student = (Student) class1.newInstance();
            Method method = class1.getDeclaredMethod("function", String.class);//获取指定的方法
            method.setAccessible(true);
            method.invoke(student,"我是通过反射调用你的！");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //reflectNewInstance();
        //reflectConstruct();
        //reflectFiled();
        reflectMethod();
    }
}
