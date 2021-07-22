SQL能力项：
2001
数据来源：根据题目所用表格导入自建，说明所用数据库（限定使用MYSQL/ORACLE/SQLSERVER）
1)查询各个年龄段的人数，结果输出年龄段及对应的人数，按年龄段升序排序

select 年龄段, count(年龄段) '人数'
from sheet1
group by 年龄段
order by 年龄段;
2)查询每个工龄区间的人数，结果输出工龄区间及对应的人数，按人数降序排序
三年以下（工龄<3）
三年~七年（3<=工龄<7）
七年~十年（7<=工龄<10）
十年~十五年（10<=工龄<15）
十五年及以上（15<=工龄）
select 工龄区间, 人数
from (
         select '三年以下' as 工龄区间, count(*) '人数'
         from sheet1
         where 工龄 < 3
         UNION
         select '三年~七年' as 工龄区间, count(*) '人数'
         from sheet1
         where 工龄 >= 3
           and 工龄 < 7
         UNION
         select '七年~十年' as 工龄区间, count(*) '人数'
         from sheet1
         where 工龄 >= 7
           and 工龄 < 10
         UNION
         select '十年~十五年' as 工龄区间, count(*) '人数'
         from sheet1
         where 工龄 >= 10
           and 工龄 < 15
         UNION
         select '十五年及以上' as 工龄区间, count(*) '人数'
         from sheet1
         where 工龄 >= 15)
         as 工人
order by 人数 desc;

select 工龄段, sum(工龄) as num
from (
         select (case
                     when 0 <= 工龄 and 工龄 < 3 then '三年以下'
                     when 3 <= 工龄 and 工龄 < 7 then '三年~七年'
                     when 7 <= 工龄 and 工龄 < 10 then '七年~十年'
                     when 10 <= 工龄 and 工龄 < 15 then '十年~十五年'
                     else '十五年及以上'
             end
                    )     as 工龄段,
                count(工龄) as 工龄
         from sheet1
         group by 工龄, 工龄段
     ) a
group by 工龄段
order by num desc;


select count(*)
from sheet1;
3)查询姓名重复三次的人员ID，结果以人员ID降序排序

select ID, a.人员姓名
from sheet1
         inner join
         (select 人员姓名 from sheet1 group by 人员姓名 having count(*) >= 3) as a
         on sheet1.人员姓名 = a.人员姓名
order by sheet1.ID desc;

select ID, sheet1.人员姓名
from sheet1
         right join
         (select 人员姓名 from sheet1 group by 人员姓名 having count(*) >= 3) as a
         on a.人员姓名 = sheet1.人员姓名
order by sheet1.ID desc;

4)查询每个公司岗位类别为‘一般管理’的人员中，各个学历的占比，结果输出，公司、学历、占比
select *
from sheet1;
select a.公司简称, 学历, total as 本公司人数, round(num / total * 100, 5)
from (select 公司简称, 学历, count(id) as num
      from sheet1
      where 岗位类别 = '一般管理'
      group by 公司简称, 学历) as a
         right join (select 公司简称, count(id) as total from sheet1 group by 公司简称) b
                    on a.公司简称 = b.公司简称;

5)查询去掉最大年龄，最小年龄后人员的平均年龄（要求使用 NOT EXISTS）
数据来源：附件table1，导入数据库
select avg(年龄)
from sheet1
where 年龄 not in (
                     (select max(年龄) from sheet1),
                     (select max(年龄) from sheet1)
    );

select avg(s1.年龄)
from sheet1 s1
where not EXISTS(
        select 1
        from (
                 select max(年龄) as age
                 from sheet1
                 union
                 select max(年龄) as age
                 from sheet1
             ) s2
        where s1.年龄 = s2.age
    );



2002 :
数据来源：根据题目所用表格导入自建，说明所用数据库（限定使用MYSQL / ORACLE / SQLSERVER）
1) 查询新进类型中，不同原因的人数以及人数排名，结果输出 原因、人数、排名

2)查询2009年度，每个月的公司变化人数（新进人数-离职人数），结果输出年度、月度、变化人数，结果根据年度、月度升序排序
3)查询累计到每个年度的离职人数,结果输出年度、累计离职人数（注意是累计不是合计）
4)查询2009年度，每个月的离职人数以及环比增长率，结果根据年度、月度升序排序

数据来源：附件table2，导入数据库


2003:
数据来源：自建，说明所用数据库（限定使用MYSQL/ORACLE/SQLSERVER）
1)随机建个含有主键的表，输出建表语句
create table a
(
    id   int not null primary key AUTO_INCREMENT,
    name varchar(50)
);
2)插入5条数据，输出插入语句
insert into a value (null, '张三');
insert into a value (null, '李四');
insert into a value (null, '王五');
insert into a value (null, '赵六');
insert into a value (null, '田七');

3) 删除两条输出，输出删除语句
delete from a where name = '张三';
delete from a where name = '李四';
4) 根据主键更新两条数据，输出更新语句
update a set name = '蔡徐坤' where id = 1;
update a set name = '吴亦凡' where id = 2;
5) 查询一条数据，建成视图，输出建视图语句
create view v1 as select * from a where id = 1;
select * from v1;

