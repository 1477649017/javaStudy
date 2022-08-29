#  剑指Offer

##  二维数组中的查找

[Leetcode](https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
         if(matrix == null || matrix.length == 0){
             return false;
         }
         int row = 0;
         int col = matrix[0].length -1;
         while(row < matrix.length && col >= 0){
             if(matrix[row][col] < target){
                 row++;
             }else if(matrix[row][col] > target){
                 col--;
             }else{
                 return true;
             }
         }
         return false;
    }
}

//看最右边，从上往下是一个递增的过程。所以可以根据这个关系先确定是在哪一行。然后在每一行里面，再去比较确定找到位置
```

***

由题意可以知道，这个二维数组每一行的元素从左往右是递增的，在每一列上上从上往下也是递增的。所以从最上角开始比较，先确定在哪一行，然后再确定是在行的哪个位置。

注意：这里要注意，数组可能是null，长度也有可能是0。不过长度是0和nul是不一样的，一个是数组对象都没有，一个是有数组对象只不过长度是0，这点java里面是允许的。

***

另外的理解方式，从右上角看可以理解为一个二叉搜索树。整个遍历过程其实也就是二叉搜索树的查找过程。

![image-20220829205008357](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220829205008357.png) 

***

##  旋转数组的最小数字

[Leetcode](https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

```java
class Solution {
    public int minArray(int[] numbers) {
        //暴力解法
        // int min = numbers[0];
        // for(int i = 1;i < numbers.length;i++){
        //     if(numbers[i] < min){
        //         min = numbers[i];
        //     }
        // }
        // return min;

        //二分解法
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int mid = (left + right)/2;
            if(numbers[mid] < numbers[right]){
                right = mid;
            }else if(numbers[mid] > numbers[right]){
                left = mid + 1;
            }else{
                right = right - 1;
            }
        }
        return numbers[right];
    }
}
```

***

首先暴力解法，就别管这个数组是不是旋转了，就是找最小值的问题。题目说原数组是有序的，那其实就是可以往二分查找上思考。就可以看成是两个有序的数组拼接到一起，找的就是两个数组的交界处。

两种情况：

1，不存在重复的元素

![image-20220829210610244](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220829210610244.png) 

***

不存在重复元素的时候，上述例子原数组反转之前是【1 2 3 4 5】,因为我们是可以通过numbers[mid]的大小来确定他是在最小值的右边还是左边。如果是numbers[mid] < numbers[right]，我们可以知道现在mid位置还是在一个子有序数组（反转到后面的那部分）里面，那么最小值肯定是在mid位置及以前。如果是numbers[mid] > numbers[right]，那么最小值肯定是在mid位置以后。

2，存在重复的元素

![image-20220829211628308](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220829211628308.png) 

***

存在重复元素，那么就有可能存在numbers[mid] == numbers[right]的情况，这个时候你就确定不了mid的位置到底是在最小值的左边还是右边，这个时候就只能暴力的缩小范围了，right  = right - 1。

***

##  第一个只出现一次的字符

[Leetcode](https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

```java
class Solution {
    public char firstUniqChar(String s) {
        //哈希表的思想
        int[] arr = new int[26];
        Arrays.fill(arr,0);
        for(int i = 0;i < s.length();i++){
            arr[s.charAt(i) - 97]++;
        }
        for(int i = 0;i < s.length();i++){
            if(arr[s.charAt(i) - 97] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
```

***

第一个只出现一次的字符，就是哈希表的思想，统计每个字符出现的次数，遍历找到第一个只出现一次的就好。

***

