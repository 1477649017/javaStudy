public class HashBuck<K,V> {

    static class Node<K,V> {
        public K key;
        public V val;
        public Node next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K,V>[] array ;
    public int usedSize;//记录 当前哈希桶当中 有效数据的个数
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashBuck() {
        this.array = (Node<K, V>[])new  Node[10];
        this.usedSize = 0;
    }



/**
* 存储key val
* @param key
* @param val
* @return
*/
    public void put(K key,V val) {
        Node node  = new Node(key,val);
        int index = key.hashCode()% array.length;
        Node cur = array[index];
        while(cur != null){
            if(cur.key == key){
                cur.val = val;
                return;//如果有这个元素那就修改值了return
            }
            cur = cur.next;
        }
        //进行头插
        node.next = array[index];
        array[index] = node;
        this.usedSize++;

        //检查负载因子。如果当前负载因子大于标准负载因子那就要扩容
        if(loadFactor() >= DEFAULT_LOAD_FACTOR){
            //进行扩容
            grow();
        }

    }
    private float loadFactor(){
        return (this.usedSize)*1.0f/ array.length;
    }

    private void grow() {
//重新的哈希
/**
 * 1. 遍历数组的每个元素的链表
 * 2. 每遍历到一个节点，就重新哈希  key % len
 * 3. 进行头插法
 */
        Node[] newArray = new Node[2* array.length];
        for (int i = 0; i < array.length; i++) {
            Node<K,V> cur = array[i];
            Node<K,V> curNext = null;
            while(cur != null){
                curNext = cur.next;//先把cur.next记住，不然后面一头插就把后面节点全丢了
                int index = cur.key.hashCode()% newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        this.array = newArray;

    }

/**
* 通过key值 获取val 值
* @param key
* @return
*/
    public V get(K key) {
        int index = key.hashCode()% array.length;
        Node<K,V> cur = array[index];
        while(cur != null){
            if(cur.key.equals(key)){
                break;//如果有这个元素那就修改值了return
            }
            cur = cur.next;
        }
        return (V)cur.val;
    }
}