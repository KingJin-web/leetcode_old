# 五月

## [690. 员工的重要性](Test1.java)

给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。

比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3
的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。

现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。

示例：

    输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
    输出：11
    解释：
    员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。

提示：

    一个员工最多有一个 直系 领导，但是可以有多个 直系 下属
    员工数量不超过 2000 。

<hr>

## [1333. 餐厅过滤器]( Test2.java)

给你一个餐馆信息数组 restaurants，其中

```C
restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]。
```

你必须使用以下三个过滤器来过滤这些餐馆信息。

其中素食者友好过滤器 veganFriendly 的值可以为 true 或者 false，如果为 true 就意味着你应该只包括 veganFriendlyi 为 true 的餐馆，为 false
则意味着可以包括任何餐馆。此外，我们还有最大价格 maxPrice 和最大距离 maxDistance 两个过滤器，它们分别考虑餐厅的价格因素和距离因素的最大值。

过滤后返回餐馆的 id，按照 rating 从高到低排序。如果 rating 相同，那么按 id 从高到低排序。简单起见， veganFriendlyi 和 veganFriendly 为 true 时取值为 1，为 false 时，取值为
0 。

示例 1：

    输入：restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 1, maxPrice = 50, maxDistance = 10
    输出：[3,1,5]
    解释：
    这些餐馆为：
    餐馆 1 [id=1, rating=4, veganFriendly=1, price=40, distance=10]
    餐馆 2 [id=2, rating=8, veganFriendly=0, price=50, distance=5]
    餐馆 3 [id=3, rating=8, veganFriendly=1, price=30, distance=4]
    餐馆 4 [id=4, rating=10, veganFriendly=0, price=10, distance=3]
    餐馆 5 [id=5, rating=1, veganFriendly=1, price=15, distance=1]
    在按照 veganFriendly = 1, maxPrice = 50 和 maxDistance = 10 进行过滤后，我们得到了餐馆 3, 餐馆 1 和 餐馆 5（按评分从高到低排序）。

示例 2：

    输入：restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 0, maxPrice = 50, maxDistance = 10
    输出：[4,3,2,1,5]
    解释：餐馆与示例 1 相同，但在 veganFriendly = 0 的过滤条件下，应该考虑所有餐馆。

示例 3：

    输入：restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 0, maxPrice = 30, maxDistance = 3
    输出：[4,5]

提示：

    1 <= restaurants.length <= 10^4
    restaurants[i].length == 5
    1 <= idi, ratingi, pricei, distancei <= 10^5
    1 <= maxPrice, maxDistance <= 10^5
    veganFriendlyi 和 veganFriendly 的值为 0 或 1 。
    所有 idi 各不相同。

<hr>

## [7. 整数反转](Test3.java)

给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。

示例 1：

    输入：x = 123
    输出：321

示例 2：
    
    输入：x = -123
    输出：-321

示例 3：

    输入：x = 120
    输出：21

示例 4：

    输入：x = 0
    输出：0

提示：

    -2^31 <= x <= 2^31 - 1

<hr>


## [1037. 有效的回旋镖](Test4.java)

回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。

给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。



示例 1：

    输入：[[1,1],[2,3],[3,2]]
    输出：true
示例 2：

    输入：[[1,1],[2,2],[3,3]]
    输出：false
    

提示：
    
    points.length == 3
    points[i].length == 2
    0 <= points[i][j] <= 100

<hr>