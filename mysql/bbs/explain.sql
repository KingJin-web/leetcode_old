-- https://segmentfault.com/a/1190000021458117
-- http://www.cnitblog.com/aliyiyi08/archive/2008/09/09/48878.html
explain select * from tbl_user where uid= 1;
+----+-------------+----------+------------+-------+---------------+---------+---------+-------+------+----------+-------+
| id | select_type | table    | partitions | type  | possible_keys | key     | key_len | ref   | rows | filtered | Extra |
+----+-------------+----------+------------+-------+---------------+---------+---------+-------+------+----------+-------+
|  1 | SIMPLE      | tbl_user | NULL       | const | PRIMARY       | PRIMARY | 4       | const |    1 |   100.00 | NULL  |
+----+-------------+----------+------------+-------+---------------+---------+---------+-------+------+----------+-------+
1. id //select查询的序列号，包含一组数字，表示查询中执行select子句或操作表的顺序
2. select_type //查询类型
3. table //正在访问哪个表
4. partitions //匹配的分区
5. type //访问的类型
6. possible_keys //显示可能应用在这张表中的索引，一个或多个，但不一定实际使用到
7. key //实际使用到的索引，如果为NULL，则没有使用索引
8. key_len //表示索引中使用的字节数，可通过该列计算查询中使用的索引的长度
9. ref //显示索引的哪一列被使用了，如果可能的话，是一个常数，哪些列或常量被用于查找索引列上的值
10. rows //根据表统计信息及索引选用情况，大致估算出找到所需的记录所需读取的行数
11. filtered //查询的表行占表的百分比
12. Extra //包含不适合在其它列中显示但十分重要的额外信息
explain select * from tbl_user where uname = 'a';

explain SELECT topicid,
               title,
               a.modifytime,
               uname,
               a.boardid
        FROM (SELECT topicid, title, modifytime, uname, boardid
              FROM tbl_topic
                       LEFT JOIN tbl_user ON tbl_topic.uid = tbl_user.uid) a,
             (SELECT boardid, max(modifytime) AS modifytime FROM tbl_topic GROUP BY boardid) b
        WHERE a.boardid = b.boardid
          AND a.modifytime = b.modifytime;