# 算法设计与分析第二次作业动态规划

## [6-1 Programming Contest (30 分)](a.cpp)

Bob will participate in a programming contest. There are altogether `n` problems in the contest. Unlike in PAT (Programming Ability Test), in a programming contest one can not obtain partial scores. For problem `i`, Bob will need `time[i]` to solve it and obtains the corresponding `score[i]`, or he may choose not to solve it at all. Bob will be happy when he obtains a total score no less than `happy_score`. You are supposed to find the minimum time needed for Bob to be happy. The function `need_time` must return the minimum time, or `-1` if it is impossible for Bob to obtain a score no less than `happy_score`.

### Format of function:

```cpp
int need_time(const int time[], const int score[], int happy_score, int n);

```

Here `n` (**1**≤**`n`**≤ `MAXN`) is the number of problems; `happy_score` (**1**≤`happy_score` **≤** `MAXS`) is the minimum score for Bob to be happy; `time[]` is the array to store `time[i]` (**1****≤**`time[i]`**≤****1****0****0**) which is the time to solve problem `i`; `score[]` is the array to store `score[i]` (**1****≤**`score[i]`**≤****1****0****0**) which is the score Bob gets for solving problem `i`.

### Sample program of judge:

```cpp
#include <stdio.h>

#define MAXN 10
#define MAXS 1000

int need_time(const int time[], const int score[], int happy_score, int n);

int main() {
  int n, i, happy_score;
  int time[MAXN], score[MAXN];
  scanf("%d %d", &n, &happy_score);
  for (i = 0; i < n; ++i)
      scanf("%d", &time[i]);
  for (i = 0; i < n; ++i)
      scanf("%d", &score[i]);
  printf("%d\n", need_time(time, score, happy_score, n));
  return 0;
}

/* Your function will be put here */

```

### Sample Input:

```cpp
6 121

84 87 78 16 94 38
87 93 50 22 63 28
```

### Sample Output:

```cpp
125
```

## [6-2 求解拆分集合为相等的子集合问题（动态规划法） (30 分)](b.cpp)

求解拆分集合为相等的子集合问题。将1～n的连续整数组成的集合划分为两个子集合，且保证每个集合的数字和相等。例如：对于n=4，对应的集合{1,2,3,4}能被划分为{1,4}、{2,3}两个集合，使得1＋4＝2＋3，且划分方案只有这一种。

### 函数接口定义：

```cpp
int split(int n);
```

### 裁判测试程序样例：

```cpp
#include <stdio.h>
#include <iostream>
#include <string.h>
#define MAXN 20

using namespace std;
int dp[MAXN*MAXN/2][MAXN*MAXN/2];
int split(int n);
int main()
{
    int n;
    cin>>n;
    cout<<split(n);
    return 0;
}

/* 请在这里填写答案 */
```

### 输入格式:

输入正整数n（测试数据已确保{1,2,3,…,n}的和是2的倍数。）

```cpp
3
```

### 输出格式:

输出拆分方案数。（可划分方案{1,2}、{3}）

```cpp
1 
```

## [7-1 最长公共子序列 (10 分)](c.cpp)

给定两个长度分别为N和M的字符串A和B，求既是A的子序列又是B的子序列的字符串长度最长是多少。

### 输入格式:

第一行包含两个整数N和M。1≤N,M≤1000

第二行包含一个长度为N的字符串，表示字符串A。

第三行包含一个长度为M的字符串，表示字符串B。

字符串均由小写字母构成。

### 输出格式:

输出一个整数，表示最大长度。

### 输入样例:

```
4 5
acbd
abcbd
```

### 输出样例:

```out
4
```

---

## [7-2 乘法表 (10 分)](d.cpp)

定义于字母表 **∑****=****{****a****,****b****,****c****}** 上的乘法表如下。|             | **a** | **b** | **c** |
| ------------- | ------------- | ------------- | ------------- |
| **a** | b           | b           | a           |
| **b** | c           | b           | a           |
| **c** | a           | c           | c           |

依此乘法表，对任一定义于∑上的字符串，适当加括号后，得到一个表达式。例如，对于字符串 x=bbbba ，它的一个加括号表达式为(b(bb))(ba) 。依乘法表，该表达式的值为 a 。试设计一个动态规划算法，对任一定义于 ∑上的字符串 x\=x1x2...xn ，计算有多少种不同的加括号方式，使由 x 导出的加括号表达式的值为 a 。

### 输入格式:

一个字符串，长度不大于20

### 输出格式:

加括号的方法数量

### 输入样例:

```in
bbbba
```

### 输出样例:

```out
6
```

## [7-3 石子合并 (10 分)](e.cpp)

在一个圆形操场的四周摆放 **N** 堆石子,现要将石子有次序地合并成一堆.规定每次只能选相邻的 2 堆合并成新的一堆，并将新的一堆的石子数，记为该次合并的得分。

试设计出一个算法,计算出将 **N** 堆石子合并成 1 堆的最小得分和最大得分。

### 输入格式:

数据的第 1 行是正整数 **N** ，表示有 **N** 堆石子。

第 2 行有 **N** 个整数，第 **i** 个整数 **a****i****** 表示第 **i** 堆石子的个数。

### 输出格式:

输出共 2 行，第 1 行为最小得分，第 2 行为最大得分。

### 输入样例:

```
4
4 5 9 4
```

### 输出样例

```
43
54
```

## [7-4 Split (20 分)](f.cpp)

Little Zhang has an array **a** which length is **n**, and the index of this array **a** starts from zero. As Little Zhang is bored, he decides to play with the array.

Next, Little Zhang wants to split the array **a**, each time the even-indexed numbers are distributed into the array **b** in order, and the odd-indexed numbers are distributed into the array **c** in order. Ensure that all numbers in array **b** are before array **c**. Then, Little Zhang will continue to split all the new arrays **b** and **c** in the same way. Because Little Zhang is really crazy, he'll repeat this kind of operation until there is only one number in the array, and there's no split operation will be performed.

For example, for an array which length **n****=****8**，and the initial array is **a****0********,****a****1********,****a****2********,****a****3********,****a****4********,****a****5********,****a****6********,****a****7******.

After performing a split operation, the array **b** is **a****0********,****a****2********,****a****4********,****a****6******, the array **c** is **a****1********,****a****3********,****a****5********,****a****7******, then the original array can be seen as **a****0********,****a****2********,****a****4********,****a****6********,****a****1********,****a****3********,****a****5********,****a****7******.

Next, after splitting the **b** array you'll get **a****0********,****a****4****** and **a****2********,****a****6******, and after splitting the **c** array you'll get **a****1********,****a****5****** and **a****3********,****a****7******, then the original array can be seen as **a****0********,****a****4********,****a****2********,****a****6********,****a****1********,****a****5********,****a****3********,****a****7******。

Then, on the basis of the original distribution, you'll still find that **a****0********,****a****4********,****a****2********,****a****6********,****a****1********,****a****5********,****a****3********,****a****7******.

Now given an initial array **a**, you are asked to tell Little Zhang the final permutation of the array after all the split operations.

### Input Specification:

Each input file only contains one test case.

The first line contains an integer **n** **(****1****≤****n****≤****1****0****6********)**, indicating the length of the array **a**. It is guaranteed that the value of **n** over all cases is **2****k********(****0****≤****k****≤****1****9****)**.

The second line contains **n** integers **a****i****** **(****1****≤****a****i********≤****1****0****9********)**, indicating the value of the **i**-th number in the array.

### Output Specification:

Print the final permutation of the array after all the split operations.

**Note: Please, DO NOT output extra spaces at the end of each line, or your answer may be considered incorrect!**

### Sample Input:

```in
8
0 1 2 3 4 5 6 7
```

### Sample Output:

```out
0 4 2 6 1 5 3 7
```

### Hint:

For the sample test case, the process of all the split operations are shown in the following picture:

![样例.png](https://images.ptausercontent.com/fff1b66e-08b7-40bd-b40f-d7dd3bfc9296.png)

## [7-5 收集宝物 (30 分)](g.cpp)

小明有一张藏宝图，上面有n*m个房间，每个房间里面都有一个有一定价值的宝物，小明只能从左上角的房间进入，且每次只能向右或向下行走，最终只能从最右下的房间出来。经过某个房间时，如果该房间中的宝物价值比小明手中任何宝物价值都大，小明就可以拿走它，当然，也可以不拿。当小明走到出口时，如果他手中的宝贝恰好是k件，则这些宝物就可以送给小明。请你帮小明算一算，他有多少种不同的行动方案能获得这k件宝贝。

### 输入格式:

输入第一行3个整数n,m,k(1<=n,m<=50,1<=k<=12)，其间空格分割。

接下来有n行数据，每行有m个整数Vi(0<=Vi<=12)，代表这个房间里的宝物的价值。

### 输出格式:

要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对1000000007取模的结果。

### 输入样例1:

```in
2 2 2
1 2
2 1
```

### 输出样例1:

```out
2
```

### 输入样例2:

```in
2 3 2
1 2 3
2 1 5
```

### 输出样例2:

```out
14
```



## [7-6 小乐子闯鬼屋 (300 分)](h.cpp)

小乐子正在玩鬼屋冒险。 现在，他进入鬼屋最恐怖的环节，'鬼打墙'。 这里有一个诡异的的阵法，这个阵法中有许多门，每次都会有两扇门出现在小乐子左右两边，门的背后可能藏有工作人员扮演的鬼。 首先，小乐子在入口。 对于此后的每一次选择，小乐子将以p的概率开左手边的门，或者以1-p的概率开另一扇门。 给定每个鬼的位置，请计算小乐子通过“鬼打墙”的概率。

注意无论选择哪扇门，都会进入同一个房间

### 输入格式:

每个测试用例包含两行。

每个测试用例的第一行分别为N(1≤N≤10)和p(0.25≤p≤0.75)，用一个空白隔开，表示鬼的数量和开左手边门的概率。

每个测试用例的第二行是N个整数，代表N个鬼的位置。每个整数的取值范围是[1,100000000]。

其中假设有一组数据的描述为，鬼的位置1，4，6.即鬼在第一关的左手边，第二关的右手边，第三关的右手边

### 输出格式:

对于每个测试用例，将概率输出为一行，精度为小数点后7位。

### 输入样例:

在这里给出一组输入。例如：

```in
1 0.5
2
2 0.5
2 4
```

### 输出样例:

在这里给出相应的输出。例如：

```out
0.5000000
0.2500000
```
