import java.lang.reflect.Array;
import java.util.Arrays;

public class MyStack<T> {
    public T[] elem;
    public int UsedSize;//用来记录当前栈中有效元素，并且标记数组元素下标
    public static final int DEFAULT_CAPACITY = 10;

    public MyStack(Class<T> clazz){//构造方法，为数组初始化
        elem = (T[]) Array.newInstance(clazz,DEFAULT_CAPACITY);
    }

    private boolean isFull(){
        if(UsedSize == elem.length){
            return true;
        }
        return false;
    }
    public void push(T val){
        //压栈之前首先要判满
        if(isFull()){
            //如果满了就要扩容
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[UsedSize] = val;
        UsedSize++;
    }

    public T pop(){//弹出栈顶元素并删除
        //弹出之前先判断一下栈是不是已经是空的了
        if(empty()){
            throw new PopEmptyException("栈已空，无法执行pop操作！");
        }
        T val = elem[UsedSize - 1];
        UsedSize--;//直接减减，下次赋值会直接覆盖掉
        return val;
    }

    public T peek(){//获取栈顶元素
        if(empty()){
            throw new PopEmptyException("栈已空，无法执行peek操作！");
        }
        T val = elem[UsedSize - 1];
        return val;
    }
    public int search(T val){
        for(int i = UsedSize - 1;i >= 0;i--){
            if(elem[i] == val){
                return i;
            }
        }
        return -1;
    }

    public boolean empty(){
        if(UsedSize == 0){
            return true;
        }
        return false;
    }

    public int getUsedSize(){
        return UsedSize;
    }
}
