#  Leetcode--刷题之被虐日记(5月2日)

![image-20220502132810778](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220502132810778.png) 

****

#  一，题目解读

首先，题目的意思就是要将两个有序数组nums1,nums2合并为一个有序的数组，但需要我们注意的是，最后合并的数组不应该由函数返回，并且要存储在nums1中，题目中nums1的长度注意是m+n，也就是说默认nums1一定是能够存放下合并后的所有元素的，这里特别要小心，不能把m当成了nums1的长度了，就比如示例3，你看到的是nums1 = [0],m = 0，意思好像是说nums1里面没有任何元素，但事实是nums1的长度m+n是1，也就是说里面是有元素的，关于这一点我反正是被坑了，原因就是没好好看题目........

*****



#  二，解法揭秘

##  2.1，利用类方法

````
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //1,调用类方法
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
````

**解析：**

这个方法的思路最简单，也是我自己的第一时间想到的，直接拿着类方法两下给它搞定了，其中System类里面的native方法arraycopy，可以用来进行数组的拷贝，具体的方法介绍大家不懂的话可以去看我的对于Java数组解析的那篇博客。将所有元素全部都放到nums1中后，再进行排序就达到了我们的目的了，将两个有序的数组合并为了一个有序的数组。

****

但是，这种方法虽然简单，不需要怎么动脑经，但就达不到我们刷题的目的了，所以这种方法，看看，爽爽就好。

****

##  2.2，利用一个中间数组，双指针思路

````
class Solution {
   public void merge(int[] nums1, int m, int[] nums2, int n) {
        //2，利用中间数组，双指针思想
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int[] tmp = new int[m+n];
        while(p1 < m || p2 < n){
            if(p1 == m){//这种情况是 p1 == m == 0，或者是 p1 == m也就是nums1有效元素已经遍历完了
                tmp[p3++] = nums2[p2++];
            }else if(p2 == n){//这种情况是 p2 == n == 0，或者是 p2 == n也就是nums2元素已经遍历完了
                tmp[p3++] = nums1[p1++];
            }else if(nums1[p1] < nums2[p2]){//这种情况是 nums1的元素小于nums2 的元素
                tmp[p3++] = nums1[p1++];
            }else{//这种情况是 nums1的元素大于等于 nums2的元素 (等于的情况放大于，小于里面都行)
                tmp[p3++] = nums2[p2++];
            }
        }
        System.arraycopy(tmp,0,nums1,0,m+n);
    }
}
````

**解析：**

思路就是首先定义一个中间数组tmp，以及三个下标记录变量p1,p2,p3(有点指针那个意思)，p1指向的是nums1的起始位置，p2指向的是nums2的起始位置，p3指向的是tmp的起始位置，然后去比较nums1与nums2的每一个元素，如果说nums1的元素小于nums2的元素，那就是把nums1的元素赋值到tmp里面,同时p1,p3往后走一步，然后又去比较，如果说nums2的元素小于等于nums1的元素，就把nums2的元素赋值到tmp里面，同时p2,p3往后走一步。其中注意有两种情要单拎出来，就是m == 0 和 n == 0，m == 0 的时候就相当于遍历nums2数组，然后把元素一个个赋值到tmp里面，n == 0 的时候就相当于遍历nums1数组，然后把元素一个个赋值到tmp里面。还有当p1 == m或者 p2  == n 的时候，就说明nums1 或者 nums2已经所有有效元素都遍历完了，那么后面就只需要把nums2或者nums1的剩下的元素全部赋值到tmp中即可。最后一部就是把tmp中的内容拷贝到nums1中就好。



*****

##  2.3，逆向双指针(主推方法)

```
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        3，逆向双指针
        int p1 = m-1;
        int p2 = n-1;
        int tail = m+n-1;
        while(p1 >= 0 || p2 >= 0){
            if(p1 == -1){//这种情况是 m == 0或者是 nums2里面的元素比nums1里面的都小，就直接把nums2全部赋值到nums1前面就好了
                nums1[tail--] = nums2[p2--];
            }else if(p2 == -1){//这种情况是 n == 0或者是 nums2里面的元素比nums1里面的都大，那前面就nums1自身赋值了
                nums1[p1--] = nums1[tail--];
            }else if(nums2[p2] > nums1[p1]){// nums2里面的元素比nums1里面的元素大
                nums1[tail--] = nums2[p2--];
            }else{
                nums1[tail--] = nums1[p1--];// nums1的元素大于等于nums2的元素(等于的情况放大于，小于里面都行)
            }
        }
    }
}
```

**解析：**

逆向双指针的思路与上面的有点像，只不过这个时候没有借助一个中间的数组，而是直接在nums1上进行操作。之前是先把小的往前放，这次是先把大的往后放，其他的原理都是差不多的。

**图示：**(第一次弄动图，不太会整，大家见谅哈哈，基本还是能看懂)

![动画3](C:\Users\14776\Desktop\动画3.gif) 