import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-07-21
 * Time: 14:56
 */
public class TestDemo220721 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("hello",3);
        map.put("abc",10);
        map.put("hello2",8);
        System.out.println(map);
    }
    public static void main2(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        map.put("abc",10);
        map.put("haha",20);
        map.put("haha",30);
        System.out.println(map);

        System.out.println(map.get("abc"));
        System.out.println(map.get("aaaa"));
        System.out.println(map.getOrDefault("hello",100));

        Set<String> set = map.keySet();//可以将我们的map的key值转换为set
        Collection<Integer> list = map.values();//将我们的value值转换为集合
        System.out.println(set);
        System.out.println(list);

        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        System.out.println(entrySet);
        for (Map.Entry<String,Integer> entry:entrySet) {
            System.out.println("Key:" + entry.getKey() + " Vaule" + entry.getValue());
        }
    }
    public static void main1(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = new int[]{80,20,45,70,89,50};
        for(int i = 0;i < array.length;i++){
            binarySearchTree.insertNode(array[i]);
        }
        binarySearchTree.inOrder(binarySearchTree.root);
        binarySearchTree.remove(50);
        System.out.println();
        binarySearchTree.inOrder(binarySearchTree.root);
        BinarySearchTree.TreeNode ret = binarySearchTree.searchKey(80);
        System.out.println();
        System.out.println(ret.val);
    }
}
