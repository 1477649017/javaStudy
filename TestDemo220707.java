import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-07
 * Time: 8:24
 */
class Person{
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        Person tmp = (Person) o;
        if(this.name.equals(((Person) o).name) && this.age == ((Person) o).age){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "name:" + this.name + " ; " + "age:"+ this.age;
    }
}
public class TestDemo220707 {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>(Integer.class);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.getUsedSize());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.getUsedSize());
        System.out.println(myStack.search(2));
        System.out.println(myStack.empty());


    }
    public static void main4(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Vector<Integer> vector = new Vector<>(2);
        vector.add(1);
        vector.add(2);
        System.out.println(vector.capacity());
        vector.add(3);
        System.out.println(vector.capacity());
    }
    public static void main3(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(40);//栈底
        stack.push(40);
        stack.push(40);
        stack.push(40);//栈顶
        stack.push(40);
        stack.push(40);
        stack.push(40);
        stack.push(40);
        stack.push(40);
        stack.push(40);
        System.out.println(stack.capacity());
        stack.push(40);
        System.out.println(stack.capacity());

//        int val = stack.peek();//查看一下栈顶元素
//        System.out.println(val);//40
//
//        int val1 = stack.pop();//弹出并删除栈顶元素 40
//        val = stack.peek();//30
//        System.out.println(val);
//
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        //弹出三次，栈变空
//
//        boolean ret = stack.empty();//判断栈是不是空
//        System.out.println(ret);//true
//
//        int sz = stack.size();//求栈中元素个数
//        System.out.println(sz);

    }
    public static void main2(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();//无参构造
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        //1,直接输出
        System.out.println(linkedList);

        //2,foreach循环
        for (Integer x:linkedList) {
            System.out.print(x + " ");
        }
        System.out.println();

        //3,for循环
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();

        //4,迭代器
        Iterator<Integer> it = linkedList.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        ListIterator<Integer> it2 = linkedList.listIterator(linkedList.size());//从后往前
        while(it2.hasPrevious()){
            System.out.print(it2.previous() + " ");
        }
        System.out.println();
    }
    public static void main1(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(20);


        LinkedList<Integer> linkedList = new LinkedList<>();//无参构造
        linkedList.addAll(arrayList);//尾插arraylist中的所有元素
        System.out.println(linkedList);
        List ret = linkedList.subList(0,2);
        System.out.println(ret);//注意你通过ret是可以修改到linkedlist中的内容的

        LinkedList<Person> linkedList1 = new LinkedList<>();
        linkedList1.add(new Person("xiaowang",18));
        linkedList1.add(new Person("xiaoli",19));
        System.out.println(linkedList1);
        linkedList1.remove(new Person("xiaoli",19));//Person类需要重写equals方法
        System.out.println(linkedList1);


    }
}
