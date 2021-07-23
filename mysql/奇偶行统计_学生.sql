只能依靠标识列的值来进行判断和选取
因为数据行可能存在增加、修改和删除，因此标识列的数据值并不“完全可靠”，例如标识列值为3，并不一定是第三行，因为如果第二行被删除了，它就是第二行，实际上也是偶数行
根据我们前面使用过的SELECT…INTO，可以创建一张新表，顺便创建新的标识列，再在新的标识列上执行奇偶判断
奇数判断依据：标识列值%2不等于0；偶数判断依据：标识列值%2等于0

create table test1
(
    tid   int primary key,
    tname varchar(10),
    price int(6)
);

insert into test1
values (1, '苹果', 56);
insert into test1
values (3, '香蕉', 435);
insert into test1
values (5, '橘子', 234);
insert into test1
values (6, '火龙果', 187);
insert into test1
values (7, '猕猴桃', 323);
insert into test1
values (8, '樱桃', 450);
insert into test1
values (10, '西瓜', 686);

commit;

--奇偶行统计


