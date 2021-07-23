-- 创建表
create table tbEmp(
	eid int primary key,
	ename varchar(8) not null unique
		constraint CK_ename check(length(ename)>1 and length(ename)<6),
	esex varchar(2) default '男' not null
		constraint CK_esex check(esex in('男','女')),
	sAge int not null
		constraint CK_sAge check(sAge between 10 and 50),
	eaddr varchar(200) default '地址不详'
);

create table tbProd(
	pid int primary key,
	ptype varchar(20) not null,
	pmark varchar(200),
	pspec varchar(200)
);

create table tbSales(
	srno int primary key,
	eid int not null
		constraint FK_eid references tbEmp(eid),
	pid int not null
		constraint Fk_pid references tbProd(pid),
	pqty int not null
		constraint CK_pqty check(pqty>=0),
	pamount numeric(10,2) not null
		constraint CK_pamount check(pamount>=0),
	sdate date not null
);

create sequence seq_eid;
create sequence seq_pid;
create sequence seq_srno;


insert into tbEmp values(seq_eid.nextval,'张三',default,24,'湖南长沙');
insert into tbEmp values(seq_eid.nextval,'李云','男',26,'湖南长沙');
insert into tbEmp values(seq_eid.nextval,'王武','女',22,'湖南衡阳');
insert into tbEmp values(seq_eid.nextval,'陈彬',default,30,'湖北武汉');
insert into tbEmp values(seq_eid.nextval,'赵柳','女',24,'湖南益阳');
insert into tbEmp values(seq_eid.nextval,'钱七',default,32,'湖南长沙');
 
 
insert into tbProd values(seq_pid.nextval,'笔记本','紫光','');
insert into tbProd values(seq_pid.nextval,'笔记本','联想','U350');
insert into tbProd values(seq_pid.nextval,'电视机','长虹','29英寸');
insert into tbProd values(seq_pid.nextval,'电视机','长虹','52英寸');
insert into tbProd values(seq_pid.nextval,'电视机','熊猫','32英寸');
insert into tbProd values(seq_pid.nextval,'电视机','TCL','42英寸');
insert into tbProd values(seq_pid.nextval,'电视机','TCL','52英寸');

insert into tbSales values(seq_srno.nextval,1,5,1,4000,to_date('2012-5-14','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,2,1,2,8000,to_date('2012-3-14','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,2,3,1,4200,to_date('2012-3-26','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,2,2,1,4200,to_date('2012-3-26','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,2,5,3,20000,to_date('2012-4-14','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,2,1,1,4200,to_date('2012-5-12','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,3,1,2,8400,to_date('2012-6-14','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,4,3,1,4000,to_date('2012-2-18','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,5,4,2,12000,to_date('2012-3-14','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,5,5,1,4200,to_date('2012-3-12','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,5,3,1,4200,to_date('2012-4-12','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,5,4,3,8600,to_date('2012-3-12','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,1,2,2,11000,to_date('2012-5-12','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,3,2,2,12000,to_date('2012-4-14','YYYY-MM_DD'));
insert into tbSales values(seq_srno.nextval,4,2,1,4800,to_date('2012-4-18','YYYY-MM_DD'));

--1.查询两表的数据

--2.查询男员工名单



---多表查询(不需要查询总销售量和总销售价值,只需显示商品的销售情况即可)
--1. 所有职员,所有商品的销售情况,包括:职员姓名,商品类别,商品品牌,商品规格,销售数量,销售价值,销售时间,按销售时间从高到低排列



--2. 笔记本4月份的销售情况,包括:商品编号,商品品牌,商品规格,销售数量,销售价值,按销售数量从低到高排列



--3. 李云3月份的销售情况,包括:商品编号,销售数量,销售价值


--4. 长虹29英寸纯平艺术电视机的销售情况,包括:销售数量,销售价值,销售时间



--5. 长沙男职员4月份的销售情况,包括:职员姓名,商品类别,商品品牌,商品规格,销售数量,销售价值




--统计
--1. 总共有多少个职员？



--2. 长虹电视机被销售了多少次?




--3. 年龄最小的女职员的年龄(年龄最小的女职员的姓名,年龄)   


--4. 笔记本单笔销售价值最高的单笔销售价值


--5. 熊猫电视机的每次销售的平均销售价值(熊猫电视机的平均销售价格)



--6. 紫光笔记本3月份的销售总额


--分组与合计
--1. 按类型,品牌统计商品的销售总数量,销售总数量低于5的不统计




--2. 按品牌,规格统计笔记本的平均销售价格,按销售价格从高到低的顺序显示



 
--3. 按姓名统计男职员3月份的销售总额,销售总额低于10000的不统计




--4. 找出销售总额最高的职员的姓名




--5. 按姓名统计每个职员一共完成了多少笔销售业务



--6. 找出完成销售业务笔数最多的职员的姓名和他完成的业务数



--7. 按性别统计职员的最大年龄和最小年龄

