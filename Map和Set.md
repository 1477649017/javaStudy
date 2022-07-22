#  Map和Set

#  一，搜索树

二叉搜索树的相关操作函数代码：

```java
public class BinarySearchTree {//二叉搜索树
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode root;

    /*
    * 搜索函数，查看当前搜索树里面是否存在该元素
    * 找到就返回节点，找不到就返回null
    * */

    public TreeNode searchKey(int key){
        if(root == null){
            return null;
        }
        TreeNode cur = root;
        while(cur != null){
            if(cur.val < key){
                cur = cur.right;
            }else if(cur.val > key){
                cur = cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }

    /*
    * 插入函数，在二叉搜索树里面插入一个节点
    * */
    public boolean insertNode(int val){
        TreeNode node = new TreeNode(val);
        if(root == null){
            root = node;
            return true;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null){
            if(cur.val > val){
                pre = cur;
                cur = cur.left;
            }else if(cur.val < val){
                pre = cur;
                cur = cur.right;
            }else{
                return false;
            }
        }
        if(pre.val > val){
            pre.left = node;
        }else{
            pre.right = node;
        }
        return true;
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /*
    * 删除节点函数
    * */
    public void remove(int val){
        if(root == null){
            return;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur  != null){//先找到你要删除的节点
            if(cur.val < val){
                pre = cur;
                cur = cur.right;
            }else if(cur.val > val){
                pre = cur;
                cur = cur.left;
            }else{
                //到这里就说明找到了，开始删除
                removeNode(pre,cur);
                return;//这里要return，不然死循环
            }
        }
    }
    private void removeNode(TreeNode parent,TreeNode cur){
        if(cur.left == null){
            if(cur == root){
                root = root.right;
            }else if(parent.left == cur){
                parent.left = cur.right;
            }else{
                parent.right = cur.right;
            }
        }else if(cur.right == null){
            if(cur == root){
                root = root.left;
            }else if(parent.left == cur){
                parent.left = cur.left;
            }else{
                parent.right = cur.left;
            }
        }else{
            //替换法删除,去左边找最大值
            TreeNode tP = cur;
            TreeNode t = cur.left;
            while(t.right != null){//一直往右边走找最大值
                tP = t;
                t = t.right;
            }
            //出来了就说明找到了
            cur.val = t.val;//先把值替换,然后删除t
            if(tP.left == t){
                tP.left = t.left;
            }else{
                tP.right = t.left;
            }
        }
    }
}

```

【删除操作细节分析：】

 ![image-20220721185456715](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220721185456715.png) 

***

#  二，Map

【有关Map的一些函数，以及细节：】

  ![image-20220721222142575](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220721222142575.png) 

***

![image-20220721222226886](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220721222226886.png) 

***

#  三，Set

【有关Set的使用和细节：】

![image-20220722082640481](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220722082640481.png) 

***

【三个题，体现Map,Set的思想：】

```java
public class TestDemo220721 {
    public static void func1(int[] array){
        //删除10万个数据中的重复元素
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        Object[] objects = hashSet.toArray();
        System.out.println(Arrays.toString(objects));
    }

    public static int func2(int[] array){
        //找到10万个数据中的第一个重复的元素
//        HashSet<Integer> hashSet = new HashSet<>();
//        int ret = 0;
//        for (int i = 0; i < array.length; i++) {
//            //放的时候看一下Set里面有不有，有就是第一个重复的
//            if(!hashSet.contains(array[i])){
//                hashSet.add(array[i]);
//            }else{
//                ret = array[i];
//                break;
//            }
//        }
//        return ret;
        int ret = 0;
        HashMap<Integer,Integer> hashMap =new HashMap();
        for (int i = 0; i < array.length; i++) {
            if(!hashMap.containsKey(array[i])){
                hashMap.put(array[i],1);
            }else{
                int value = hashMap.get(array[i]);
                hashMap.put(array[i],value+1);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(hashMap.get(array[i]) == 1){
                ret = array[i];
            }
        }
        return ret;
    }

    public static void func3(int[] array){
        //统计100000个数据中每个元素出现的次数
//        HashMap<Integer,Integer> hashMap =new HashMap();
//        for (int i = 0; i < array.length; i++) {
//            if(!hashMap.containsKey(array[i])){
//                hashMap.put(array[i],1);
//            }else{
//                int value = hashMap.get(array[i]);
//                hashMap.put(array[i],value+1);
//            }
//        }
//        System.out.println(hashMap);

        HashMap<Integer,Integer> hashMap =new HashMap();
        for (int i = 0; i < array.length; i++) {
            int ret = hashMap.getOrDefault(array[i],-1);//存在即返回vaule，不存在就返回默认值-1
            if(ret < 0){
                hashMap.put(array[i],1);
            }else{
                hashMap.put(array[i],ret+1);
            }
        }
        System.out.println(hashMap);


    }
    public static void main(String[] args) {
        int[] array = new int[100000];
        Random random = new Random();
        for(int i = 0;i < array.length;i++){
            array[i] = random.nextInt(10000);
        }
        //int[] array = new int[]{1,3,3,4,4,8,9,10,5,6,6};
        func1(array);
        func2(array);
        func3(array);
    }
}
```

****

#  四,OJ题

[只出现一次的数字](https://leetcode.cn/problems/single-number/)

```java
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}
```

***

[复制带随机指针的链表](https://leetcode.cn/problems/copy-list-with-random-pointer/)

```java
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        //不能用TreeMap，因为节点在此不比较
        Map<Node,Node> map = new HashMap<>();
        while(cur != null){//先把val值拷贝，并形成映射关系
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);

    }
}

//这个题就是注意不要用TreeMap，因为节点在这里是无法比较的
```





![image-20220722103208882](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220722103208882.png) 

***

[宝石与石头](https://leetcode.cn/problems/jewels-and-stones/submissions/)

```java
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>(); 
        for(int i = 0;i < jewels.length();i++){
            set.add(jewels.charAt(i));
        }
        int count = 0;
        for(int j = 0;j < stones.length();j++){
            if(set.contains(stones.charAt(j))){
                count++;
            }
        }
        return count;
    }
}
```

***

[坏键盘打字](https://www.nowcoder.com/questionTerminal/f88dafac00c8431fa363cd85a37c2d5e)

```java
import java.util.*;

public class Main{
    public static void func(String s1,String s2){
        Set<Character> set = new HashSet<>();
        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();
        for(char ch:s2.toCharArray()){
            set.add(ch);
        }
        for(char ch:s1.toCharArray()){
            if(!set.contains(ch)){
                System.out.print(ch);
                set.add(ch);
            }
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String str1 = scan.nextLine();//期望输入的
            String str2 = scan.nextLine();//实际输入的
            func(str1,str2);
        }
    }
}
```

思想就是遍历str2，转成大写之后，把它放到set里面，然后再去遍历str1，如果有字符不在set里面，就说明该期望字符我们没打上，所以就是坏的。只是要注意的一个点就是不能重复的输出，所以这个坏字符你输出过了就把它加到set里面，这样下次就不会打印了。

***

[前k个高频单词](https://leetcode.cn/problems/top-k-frequent-words/submissions/)

```java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //1,首先求出每个单词出现的次数
        Map<String,Integer> map = new HashMap<>();
        for(String key:words){
            if(map.get(key) == null){
                map.put(key,1);
            }else{
                int count = map.get(key);
                map.put(key,count+1);
            }
        }

        //2，获得次数就是topK问题了
        PriorityQueue<Map.Entry<String,Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue()) == 0){
                    return o2.getKey().compareTo(o1.getKey());
                }else{
                    return o1.getValue().compareTo(o2.getValue());//建立小根堆,引用类型比较最好还是用CompareTo,比较依据是出现次数
                }
            }
        });

        //3，开始遍历map,往堆中放元素
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            if(priorityQueue.size() < k){//先放入个元素
                priorityQueue.offer(entry);
            }else{
                Map.Entry<String,Integer> top = priorityQueue.peek();//栈顶元素
                if(entry.getValue().compareTo(top.getValue()) > 0){
                    priorityQueue.poll();
                    priorityQueue.offer(entry);
                }else{
                    //到这有两种情况。次数小于或者相等
                    if(entry.getValue().compareTo(top.getValue()) == 0){
                        //如果相等要比较key,按字典序排序，所以小的进大的出
                        if(top.getKey().compareTo(entry.getKey()) > 0){
                            priorityQueue.poll();
                            priorityQueue.offer(entry);
                        }
                    }
                }
            }
        }

        List<String> list = new ArrayList<>();
        for(int i = 0;i < k;i++){
            list.add(priorityQueue.poll().getKey());
        }
        Collections.reverse(list);//进行反转，因为要求是频率高到低
        return list;
    }
}
```

![image-20220722160407477](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220722160407477.png) 

***

