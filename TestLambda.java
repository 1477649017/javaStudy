package Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-24
 * Time: 18:08
 */


//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}
//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}
//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}
//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}
//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}

abstract class Test{
    public abstract void func();
}


public class TestLambda {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zizi");
        list.add("hehe");
        list.add("wowo");
        list.forEach(new Consumer<String>() {//Consumer就是一个函数式接口
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //简化
        list.forEach(s -> System.out.println(s));

        list.sort(new Comparator<String>() {//传入的是一个比较器也可以改成lambda表达式
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        list.sort((o1,o2) -> o1.compareTo(o2));//排序
        list.forEach(s -> System.out.println(s));


    }
    public static void main8(String[] args) {
        int a = 10;
        //a = 2;
        new Test(){
            public void func(){
                //a = 90;
                System.out.println("重写一下！" + a);
            }
        }.func();
    }
    public static void main7(String[] args) {
        //两个参数，有返回值
        MoreParameterReturn moreParameterReturn = (int a,int b) -> {return a+b;};
        System.out.println(moreParameterReturn.test(100, 200));
        //简化
        MoreParameterReturn moreParameterReturn1 = (a,b) -> a+b;
        System.out.println(moreParameterReturn1.test(100, 200));
    }
    public static void main6(String[] args) {
        //一个参数，有返回值
        OneParameterReturn oneParameterReturn = (int a) -> {return a;};
        System.out.println(oneParameterReturn.test(200));

        //简化
        OneParameterReturn oneParameterReturn1 = a -> a;
        System.out.println(oneParameterReturn1.test(200));
    }
    public static void main5(String[] args) {
        //无参数，有返回值
        NoParameterReturn noParameterReturn = () -> {return 100;};
        System.out.println(noParameterReturn.test());
        NoParameterReturn noParameterReturn1 = () -> 100;//只有一条return可以就直接写返回值就可以
        System.out.println(noParameterReturn1.test());
    }
    public static void main4(String[] args) {
        //3，无返回值，两个参数
        MoreParameterNoReturn moreParameterNoReturn = (int a,int b) -> {
            System.out.println(a+b);
        };
        moreParameterNoReturn.test(100,200);

        MoreParameterNoReturn moreParameterNoReturn1 = (a,b) -> System.out.println(a+b);
        moreParameterNoReturn.test(100,200);
        //省略参数的类型，两个省略的话就要一起都省略







    }
    public static void main3(String[] args) {
        //2,无返回值，有一个参数
        OneParameterNoReturn oneParameterNoReturn = (int a) -> {
            System.out.println(a);
        };
        oneParameterNoReturn.test(100);
        //简化
        OneParameterNoReturn oneParameterNoReturn1 = a -> System.out.println(a);
        //只有一个参数，类型，括号都可以去掉
    }
    public static void main2(String[] args) {
        //lambda表达式的应用
        //1.无返回值，无参数函数式接口转lambda表达式
        NoParameterNoReturn noParameterNoReturn = new NoParameterNoReturn() {//这是匿名内部类的调用方法
            @Override
            public void test() {
                System.out.println("这是一个无返回值，无参数的方法！");
            }
        };
        noParameterNoReturn.test();
        NoParameterNoReturn noParameterNoReturn1 = () -> {System.out.println("这是一个无返回值，无参数的方法！");};
        noParameterNoReturn1.test();
        NoParameterNoReturn noParameterNoReturn2 = () -> System.out.println("这是一个无返回值，无参数的方法！");//语句块只有一条语句可以省略花括号
        noParameterNoReturn2.test();

        NoParameterNoReturn noParameterNoReturn3 = () -> {
            System.out.println("这是一个无返回值，无参数的方法！");
            System.out.println("这是一个无返回值，无参数的方法！");};//这时候花括号不能省略



    }


    public static void main1(String[] args) {
        //定义一个大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {//这是相当于有一个匿名内部类实现了Comparator接口并重写了抽象方法
                return o2 - o1;
            }
        });

        //利用lambda表达式
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>((o1,o2) -> {return o2 - o1;});
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>((o1,o2) -> o2 - o1);



    }
}
