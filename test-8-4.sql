create table emp(
    name varchar(20),
    gender varchar(20),
    depart varchar(20),
    salary int
);

insert into emp values ("张三","男","开发",10000),("李四","男","开发",11000),("王五","男","测试",10000),("赵六","女","测试",12000),("孙七","女","产品",11000);
select gender,avg(salary) from emp group by gender;
select depart,sum(salary) from emp group by depart;
select depart,sum(salary) from emp group by depart order by sum(salary) limit 1 offset 2;
select name,gender,depart,salary from emp group by name where ;
select depart,avg(salary) from emp where salary > 10000 and gender = "男" group by depart;