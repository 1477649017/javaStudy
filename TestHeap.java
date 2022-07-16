import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-16
 * Time: 18:20
 */
public class TestHeap {
    public int[] elem;
    public int UsedSize;//用来记录数组中有效元素的个数

    public TestHeap() {
        this.elem = new int[10];
        this.UsedSize = 0;
    }

    public void initArray(int[] array){//进行初始化
        this.elem = Arrays.copyOf(array,array.length);
        this.UsedSize = elem.length;
    }

    //开始建堆,这里是建立大根堆
    public void createHeap(){
        for(int parent = (UsedSize - 1 - 1)/2;parent >= 0;parent--){
            shiftDown(parent,UsedSize);
        }
    }

    /*
    * parent 是每一棵子树的根节点的下标
    *
    * len 是每一棵子树结束的位置
    * */
    public void shiftDown(int parent,int len){
        int child = parent*2 + 1;//最起码有左孩子，求出左孩子下标
        while (child < len){//进行调整的时候，你的child下标肯定不能超过我们的边界
            //有右孩子的前提下，进行比较
            if(child + 1 < len && elem[child] < elem[child+1]){
                child++;//此刻child是在较大的孩子下标处
            }
            if(elem[child] > elem[parent]){
                //如果比父亲节点的值大，那么就要交换
                swap(elem,child,parent);
                parent = child;
                child = parent*2 + 1;//交换之后继续向下调整，下面可能不满足
            }else{
                break;
            }
        }
    }

    private void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
