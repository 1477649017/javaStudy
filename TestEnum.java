package EnumDemo;

import reflectDemo.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-24
 * Time: 16:36
 */
public enum TestEnum {
    //RED,GREEN,BLUE;//枚举对象、它自身也是可以有属性的，是可以进行传参的

    RED("RED",1),GREEN("GREEN",2),BLUE("BLUE",3);
    public String color;
    public int ordinal;

    TestEnum(String color,int ordinal){//注意，枚举的构造方法默认是私有的
        this.color = color;
        this.ordinal = ordinal;
    }


    public static void main(String[] args) {
        TestEnum[] testEnums = TestEnum.values();//以数组形式返回成员
        for(int i = 0;i < testEnums.length;i++){
            System.out.println(testEnums[i] + " 序号 " + testEnums[i].ordinal() );
        }

        TestEnum testEnum1 = TestEnum.valueOf("GREEN");
        //将字符串转换为枚举实例。注意，这个枚举实例一定要是本身存在的 “GREEN1”这样是转换不了的
        System.out.println(testEnum1);

        TestEnum testEnum2 = TestEnum.BLUE;
        TestEnum testEnum3 = TestEnum.RED;
        System.out.println(testEnum3.compareTo(testEnum2));//比较的是序号的大小,序号相减
        System.out.println(RED.compareTo(BLUE));
        System.out.println(RED.color);

    }

}
