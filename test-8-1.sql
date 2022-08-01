insert into book values("Java核心技术","xxx",100,"2019-01-01 00:00:00");
update book set price = 61.00 where bookName = "Java核心技术";
insert into goods values ("耳机",65.00,100,"有线耳机"),("漫画书",20.00,300,"少儿漫画");
delete from goods where price > 60 or stock < 200;
update goods set information = "商品记录进行修改",price = price + 30 where stock > 30;