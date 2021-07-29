-- https://leetcode-cn.com/problems/rank-scores/
编写一个 SQL 查询来实现分数排名。

如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。

+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
例如，根据上述给定的 Scores 表，你的查询应该返回（按分数从高到低排列）：

+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+
重要提示：对于 MySQL 解决方案，如果要转义用作列名的保留字，可以在关键字之前和之后使用撇号。例如 `Rank`

drop table scores;
create table scores
(
    id    int primary key,
    score double(8, 2)
);
insert into scores value
    (1, 3.50),
    (2, 3.65),
    (3, 4.00),
    (4, 3.85),
    (5, 4.00),
    (6, 3.65);

set @c = 0;
SELECT Score,
       CONVERT((CASE
                    WHEN @prev = Score THEN @cur
                    WHEN @prev := Score THEN @cur := @cur + 1
                    WHEN Score <= 0 THEN @cur := @cur + 1
           END), UNSIGNED INTEGER) AS 'Rank'
FROM scores,
     (SELECT @cur := 0, @prev := null) r
ORDER BY Score
        DESC;

select score as 'Score', dense_rank() over (order by score desc ) as 'Rank'
from scores;


select score as 'Score', CONVERT((@c := @c + 1), UNSIGNED INTEGER) as 'Rank'
from scores,
     (select @c := 0) as c2
order by score desc;

