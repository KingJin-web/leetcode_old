package com.king.M09;

import com.king.util.MyPrint;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 447. 回旋镖的数量
 * @author: King
 * @create: 2021-09-13 21:10
 */
public class Test12 {
    //JAVA 实现： 这道题思路其实也比较简单，计算一点和其他点之间的距离，使用哈希表存储，若同一距离出现多次，
    //则可以形成回旋镖。假设同一距离出现 n 次，由数字规律可推出回旋镖的数量 sum = n*(n-1) 。
    // 本人开始只能做到存储到哈希表，然后按该公式累加得到最后结果。
    // 参考了速度第一的答案，优化如下：
    // 假设当前同一距离的数量为 n, 回旋镖数量为 n*(n-1), 当再出现一个同一距离时，回旋镖的数量应为 (n+1)*n，与之前相差
    // (n+1)*n - n*(n-1)= 2*n， 所以只需要把最后答案加上 2*n, 最后 n+1 再存储到哈希表中。


    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int ans = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    double dis = Math.pow(points[i][0] - points[j][0], 2)
                            + Math.pow(points[i][1] - points[j][1], 2);
                    if (!map.containsKey(dis)) {
                        map.put(dis, 1);
                    } else {
                        int n = map.get(dis);
                        ans += 2 * n;
                        map.put(dis, 1 + n);
                    }
                }
            }
            map.clear();
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][] nums = new int[][]{{0,0},{1,0},{2,0}};
        Test12 test12 = new Test12();
        MyPrint.print(test12.numberOfBoomerangs(nums));
    }
}
//给定平面上n 对 互不相同 的点points ，其中 points[i] = [xi, yi] 。回旋镖 是由点(i, j, k) 表示的元组 ，
// 其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
//
//返回平面上所有回旋镖的数量。
//
//
//示例 1：
//
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
//示例 2：
//
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
//示例 3：
//
//输入：points = [[1,1]]
//输出：0

