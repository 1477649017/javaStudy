#  String Oj题：

![image-20220606205146915](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220606205146915.png) 

```java
class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            arr[ch - 97]++; 
        }
        for(int i = 0;i < s.length();i++){
            if(arr[s.charAt(i) - 97] == 1){
                return i;
            }
        }
        return -1;
    }
}
```

这个题主要讲的就是它的思想，我们都知道char型的本质就可以看成是int型(这里只考虑ascii码表的范围)，所以既然是找第一个只出现一次的字符的下标，那我们就把字符的值减97作为下标的值，比如'a' - 97就是0，那当遍历到字符a的时候，就会把数组相应的位置上的值自增，其实这里也就是0下标的值++，所以最终把整个字符串遍历完之后，数组中保存的就是各个字符出现的次数。然后再把字符串遍历一遍，当它在数组中对应的次数是1的时候，那就是整个字符串第一个只出现一次的字符，再返回下标就好了。

**这个题重点就是将字符的ascii码值作为下标的思想。还有就是为了减少数组的长度，减去一个97，让下标可以直接从0开始**

***

![image-20220606215445209](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220606215445209.png) 

```java
class Solution {
    public boolean isLegal(char ch){
        if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(left < right && isLegal(s.charAt(left)) == false){//left < right是为了防止有的前面一直是无效字符然乎一直加加，可能会越界
                left++;
            }
            while(left < right && isLegal(s.charAt(right)) == false){
                right--;
            }
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

这个题目不是简单的判断回文串，它不考虑大小写，那我们就把它全部转换为小写，它只比较数字，字母字符，所以我们在便利的时候要检测这个字符是不是有效字符，如果不是就要跳过。思想就是这样，解法还是双指针，前后进行比较就好。

