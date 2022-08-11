#  Leetcode SQL专项

##  1，计算特殊奖金

[Leetcode](https://leetcode.cn/problems/calculate-special-bonus/)

```sql
-- select employee_id,salary as bonus from Employees where employee_id%2 != 0 and name not like 'M%' union select employee_id,salary*0 as bonus from Employees where employee_id%2 = 0 or name like 'M%' order by employee_id;
-- 这种就是用了联合查询，把符合条件的先查询出来，然后把不符合条件的查询出来，然后两个拼到一起成为结果

select employee_id,if(employee_id%2 != 0 and name not like 'M%',salary,0) as bonus from Employees order by employee_id;
-- 运用if函数 if(expr,val1,val2)条件满足值为val1，不满足为val2
```

有两种解法，第一种理解起来比较简单，就是联合查询，把两个查询结果拼接起来就是我们的结果。这里重点是要学习一下if(expr,val1,val2)这个函数，expr条件满足则结果就是val1,否则就是val2。

***

##  2，删除重复的电子邮箱

[Leetcode](https://leetcode.cn/problems/delete-duplicate-emails/)

```sql
delete from Person where id not in
(
    select id from 
    (
        select min(id) as id from Person group by Email 
    ) t -- 这个t是一个是中间临时表的名字
)
```

按照邮箱进行分组，然后选择出每一组里面id最小的，然后只要删除id不在这些id最小的结果里的记录即可。

**注意：在MySQL中，不能先Select一个表的记录，再按此条件Update和Delete同一个表的记录，否则会出错：You can't specify target table 'xxx' for update in FROM clause。**

**解决方法：使用嵌套Select——将Select得到的查询结果作为中间表，再Select一遍中间表作为结果集，即可规避错误。**

这一点是以前没有遇到过的，我们嵌套子查询的时候是没有问题的，但是如果是想更新，删除，必须要把查询结果作为一个中间表才行。

***

##  3，修复表中的名字

[Leetcode](https://leetcode.cn/problems/fix-names-in-a-table/)

```sql
select user_id,
CONCAT(Upper(left(name,1)),Lower(substring(name,2))) as name 
from users order by user_id;

-- CONCAT()字符串拼接函数
-- left() 返回字符串左边n个字符
-- substring() 分割字符串
-- 字符串函数和java里面有些相似
-- 这个题就是分两步处理，先处理首字母，然后处理后面剩余字母，前后再拼接就好
-- 函数名不区分大小写
```

这个题只要是学习到了一些新的函数，再就是注意一下，在SQL里面，字符串的下标是从1开始的，要与各个编程语言的区分开。

***

##  4，按日期分组销售产品

[Leetcode](https://leetcode.cn/problems/group-sold-products-by-the-date/)

```sql
select 
    sell_date,-- 日期
    count(distinct product) as num_sold,-- 统计一下产品数，注意去重
    group_concat(distinct product order by product Separator ',') as products
from Activities group by sell_date order by sell_date;

-- group_concat([DISTINCT] 要连接的字段 [Order BY ASC/DESC 排序字段] [Separator '分隔符']) -- 可以将一组内的同一列组合成一行进行展示
```

这里也是主要学习一个函数group_concat()，可以将组内的某一列组合成一行来进行展示,可以指定分隔符。

***

##  5，丢失信息的雇员

[Leetcode](https://leetcode.cn/problems/employees-with-missing-information/)

```sql
select A.employee_id 
from Employees A left join Salaries B  on A.employee_id = B.employee_id 
where B.salary is null 
union 
select B.employee_id 
from Employees A right join Salaries B on A.employee_id = B.employee_id 
where A.name is null 
order by employee_id;

-- 左外连接与右外连接 以及 联合查询的综合运用
```

注意两次你选取employee_id的地方是不一样的，这个要想清楚，左连接的时候看的是Employees里面的id，右连接看的是Salaries里面的employee_id。另外，在进行联合查询的时候,on后面跟的是连接条件，不要把筛选结果的条件放到后面去了，筛选结果还是利用where子句进行筛选。

***

##  6，每个产品在不同商店的价格

[Leetcode](https://leetcode.cn/problems/rearrange-products-table/)

```sql
select product_id,'store1' as store,store1 as price from Products where store1 is not null
union all
select product_id,'store2' as store,store2 as price from Products where store2 is not null
union all
select product_id,'store3' as store,store3 as price from Products where store3 is not null;
```

![image-20220809084840440](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220809084840440.png) 

***

按照题目的意思，其实就是要把列的关系转成行的关系，横表转竖表，注意这个是面试中的常考点。解决方法无非就是一列列的处理，然后把每次的结果使用union all(也可以使用union，不过这里连接的两个结果之间是不会存在重复情况的)连接起来就好。

可能**'store1' as store，store1 as price**  这个地方不太好理解。其实表有一个新的列为store，然后值全是'store1'，这里一定要加引号（要原来表的列名作为值），不然选出来的值就还是每个商店的价格。后面store1的每一个值都是价格嘛，别名就是price。

***

【扩展：】

那既然说到了上面的列转行，自然也就少不了 行转列。

假如我们现在要把上面的输出结果还原成原来的样子，也就是行转列，要如何进行操作？利用 sum( if () ) + group by

假设上面的输出表为ret

```sql
select product_id,
       sum(if(store = 'store1',price,null)) as 'store1',
       sum(if(store = 'store2',price,null)) as 'store2',
       sum(if(store = 'store3',price,null)) as 'store3'
from ret
group by product_id;
```

按照product_id进行分组，然后把每一组里面商店是store1,store2,store3的price加起来，作为新的列'store1','store2','store3'的值。这里为什么可以使用sum()求一列的和，因为在每个商店里，每种商品只可能存在一个，所以对应的价格也就是只有一个，那加起来相当于没加就是它的单价。里面的if()就是筛选条件，因为sum()会去遍历这一组的每一行然后将值加起来，而针对我们来说，每一次就是只要store = 'store1'的价格。

***

总结：列转行，每一列一列的处理，然后使用union all(union)连接结果。行转列，sum( if() ) + group by。

***

##  7，第二高的薪水

[Leetcode](https://leetcode.cn/problems/second-highest-salary/)

```java
select ifnull((select distinct salary from Employee order by salary desc limit 1 offset 1),null) as SecondHighestSalary;
```

这里使用到了子查询以及ifnull()，对于ifnull(expr,null)，如果说expr的结果不是null，也就是查询到了，那么返回值就是expr，否则返回值就是null。

***

##  8，树节点

[Lettcode](https://leetcode.cn/problems/tree-node/)

```java
select id,'Root' as Type from tree where p_id is null
union
select id,'Inner' as Type from tree where id in (select distinct p_id from tree where p_id is not null) and p_id is not null
union 
select id,'Leaf' as Type from tree where id  not in (select distinct p_id from tree where p_id is not null) and p_id is not null
order by id;
```

![image-20220811095611492](C:\Users\14776\AppData\Roaming\Typora\typora-user-images\image-20220811095611492.png) 

***

要求输出每个节点的id以及其节点类型。我这里用的解法就是分别处理，然后使用union进行联合。那么最重要的就是想清楚什么情况是内部节点，什么情况是叶子节点。根节点最好判断。

内部节点：内部节点首先它要是有子节点的，也就是它必须作为别人的父节点，所以肯定会在p_id里面出现，但是在这些里面，最终要单独去掉一个根节点。那么剩下的就是内部节点。

叶子节点：叶子节点，它不能有子节点，所以它不可能是出现在p_id里面的。其实按理来说只要它不是别人的父节点那就可以了，但是题目最后有一个要求是，当只有一个节点的时候，这个节点的属性是能是根节点，不能算是叶子节点。所以除了前面的条件外，还有一个特殊条件是不能是根节点。

***

