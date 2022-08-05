create table Employee(
    id int,
    salary int
);

select ifnull((select distinct salary from Employee order by salary desc limit 1 offset 1),null) as SecondHighestSalary;
//注意两个点 1，需要去重，因为我们要使用分页查询 2，ifnull函数的运用 ifnull(a,b) 有则为a，无则为b
 create table T1(
     id int,
     name varchar(20)
 );

  create table T2(
      id int,
      name varchar(20)
  );

  insert into T1 values (1,"张三"),(2,"李四"),(3,"王五"),(4,"赵六"),(5,"田七");
  insert into T2 values (1,"张三"),(2,"李四"),(3,"mike"),(4,"lisa"),(5,"yoyo");

  select * from T1 union select * from T2 where T2.id not in (select T1.id from T1,T2 where T1.name = T2.name);