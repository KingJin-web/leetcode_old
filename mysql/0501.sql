Create table If Not Exists Employee
(
    Id     int,
    Salary int
);
Truncate table Employee;
insert into Employee (Id, Salary)
values ('1', '100');
insert into Employee (Id, Salary)
values ('2', '200');
insert into Employee (Id, Salary)
values ('3', '300');
# https://leetcode-cn.com/problems/second-highest-salary/
# 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
# +----+--------+
# | Id | Salary |
# +----+--------+
# | 1  | 100    |
# | 2  | 200    |
# | 3  | 300    |
# +----+--------+
# 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
# +---------------------+
# | SecondHighestSalary |
# +---------------------+
# | 200                 |
# +---------------------+
select (select distinct salary from Employee order by salary desc limit 1,1)
           as SecondHighestSalary;

# ifnull(x，y)，若x不为空则返回x，否则返回y，这道题y=null
# limit x，y，找到对应的记录就停止
# distinct，过滤关键字
select ifnull
           (
               (select distinct Salary
                from Employee
                order by Salary desc
                limit 1,1),
               null
           ) as 'SecondHighestSalary';