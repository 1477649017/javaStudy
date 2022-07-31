create table book(
    bookName varchar(20),
    author varchar(20),
    price decimal(4,2),
    publish_date datetime
);

insert into book values ("book1","张三",56.43,"2020-10-10"),("book2",null,29.00,"2018-10-10"),("book3","王五",78.89,"2020-11-11");

create table goods(
    goodsName varchar(20),
    price decimal(5,2),
    stock int,
    information varchar(20)
);



insert into goods values("学生书包",18.19,101);


select name,age from student where name like '张%' and age between 18 and 25;

create table article(
    title varchar(20),
    create_data datetime
);

insert into article values ("XXX","2019-01-01 10:34"),(null,"2019-11-12 12:30");

select author,create_data from article where date(create_data) between "2019-01-01 10:30" and "2019-11-10 16:02";

select * from article where create_data > "2019-01-01" or title = null;

create table user(
    ID int,
    account varchar(20),
    amount int
);

insert into user values (01,"1234567",60),(02,"2323222",400),(03,null,900);
select * from user where (ID between 1 and 200 or ID between 300 and 500) and account is not null and amount > 100;