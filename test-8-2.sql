create table staff(
    ID int primary key auto_increment,
    name varchar(20) not null,
    age int default 18
);
create table timesheet(
    staffId int primary key,
    pushtime datetime,
    ispushCard varchar(20) default "NO",
    foreign key(staffId) references staff(ID)
);


insert into staff values (null,"张三",20),(null,"李四",24),(null,"王五",23);

insert into timesheet values (2,"2022-08-02 08:30:00","YES"),(1,"2022-08-02 08:30:00","YES"),(3,"2022-08-02 08:30:00","NO");

//设计学生宿舍管理系统
create database dorManagement;
create table dorm(
    dormId int primary key auto_increment,
    floor int not null,
    numberofPeo int default 4
);
create table student(
    stuId int primary key auto_increment,
    name varchar(20) not null,
    livDorm int not null,
    foreign key(livDorm) references dorm(dormId)
);
create table checkSheet(
    checkTime datetime,
    isFull varchar(20) default "YES",
    checkDorm int,
    absenceStuId int default null,
    foreign key(absenceStuId) references student(stuId),
    foreign key(checkDorm) references dorm(dormId)
);

insert into dorm values (1001,1,4),(2001,2,4),(3001,3,4);

insert into student values (2001070012,"张三",1001),(2001070034,"李四",1001),(2001070045,"王五",1001),(2001070056,"李明",1001);
insert into checkSheet values ("2022-08-02 19:00:00","NO",1001,2001070056);

//车辆违规系统
create database trafficViolation;
create table customer(
    ID int primary key,
    name varchar(20) not null,
    phone varchar(20) unique
);

create table vehicle(
    licenseNum varc20) primary key,
    vehicleType varchahar(r(20) not null,
    registrationTime datetime
);

create table violations(
    violationsPeoId int,
    violationsTime datetime not null,
    violationsCarNum varchar(20),
    violationsItems varchar(20),
    foreign key(violationsPeoId) references customer(ID),
    foreign key(violationsCarNum) references vehicle(licenseNum)
);

insert into customer values (1001,"张三",11111111),(1002,"李四",22222222),(1003,"王五",33333333);
insert into vehicle values ("鄂E xxxxx","大众","2010-10-10 12:30:00"),("鄂E zzzzz","奔驰","2013-12-10 12:30:00"),("鄂E vvvvv","奥迪","2019-05-11 12:30:00");
insert into violations values(1001,"2020-08-02 13:00:00","鄂E xxxxx","闯红灯");

//食堂管理系统

create database canteenManagement;

create table canteen(
    canteenNo int primary key,
    windowsNum int not null,
    chargePerson varchar(20)
);
create table canteenWindows(
    windowsId int primary key auto_increment,
    foodCategory varchar(20) comment "窗口食物种类"
);
create table chargeRecord(
    ofCanteenId int,
    ofWindowsId int,
    money decimal(5,2) not null,
    foreign key(ofCanteenId) references canteen(canteenNo),
    foreign key(ofWindowsId) references canteenWindows(windowsId)
);

insert into canteen values (1,20,"张三"),(2,20,"李四");
insert into canteenWindows values (3,"面食"),(4,"快餐");
insert into chargeRecord values (1,3,100.00),(2,4,200.00);