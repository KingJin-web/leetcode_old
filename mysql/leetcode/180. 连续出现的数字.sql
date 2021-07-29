180. 连续出现的数字
SQL架构
表：Logs

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
id 是这个表的主键。


编写一个 SQL 查询，查找所有至少连续出现三次的数字。

返回的结果表中的数据可以按 任意顺序 排列。



查询结果格式如下面的例子所示：



Logs 表：
+----+-----+
| Id | Num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+

Result 表：
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
1 是唯一连续出现至少三次的数字。
drop table logs;
create table Logs
(
    id  int,
    num varchar(20)
);

insert into logs value
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 2),
    (5, 1),
    (6, 2),
    (7, 2);

编写一个 SQL 查询，查找所有至少连续出现三次的数字。
select distinct Num as ConsecutiveNums
from (
         select Num,
                case
                    when @prev = Num then @count := @count + 1
                    when (@prev := Num) is not null then @count := 1
                    end as CNT
         from Logs,
              (select @prev := null, @count := null) as t
     ) as temp
where temp.CNT >= 3;

select distinct a.Num as ConsecutiveNums
from Logs as a,
     Logs as b,
     Logs as c
where a.Num = b.Num
  and b.Num = c.Num
  and a.id = b.id - 1
  and b.id = c.id - 1;



select a.num as 'ConsecutiveNums', c, Logs.num
from logs
         right join (select num, count(*) as c from logs group by num) as a on a.num = Logs.num
where c > 3
order by c desc
limit 1;

select a.num as 'ConsecutiveNums'
from logs
         right join (select num, count(*) as c from logs group by num) as a on a.num = Logs.num
where c > 3
order by c desc
limit 1;
