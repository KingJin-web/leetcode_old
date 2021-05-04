package com.king.M05;

/**
 * @program: leetcode
 * @description: 1037. 有效的回旋镖
 * https://leetcode-cn.com/problems/valid-boomerang/
 * @author: King
 * @create: 2021-05-04 01:53
 */
public class Test4 {
    /**
     * 判断三点是否同直线，直接思路就是判断斜率。
     * 假设三点分别为a(x1, y1), b(x2, y2), c(x3,y3),
     * a、b两点的斜率为 k1 = (y2 - y1) / (x2 - x1)
     * a、c两点的斜率为 k2 = (y3 - y1) / (x3 - x1)
     * 如果在同一直线，则k1 = k2，考虑到分母为0 的情况，可以直接交叉相乘，省去判断0的情况，直接判断
     * (y2 - y1) * (x3 - x1) 与 (y3 - y1) * (x2 - x1)
     * 不相等即为不在同一直线上
     *
     * @param points
     * @return
     */
    public boolean isBoomerang(int[][] points) {
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 1}, {2, 3}, {3, 2}};
        System.out.println(new Test4().isBoomerang(nums));
    }

}


class aa {
    public static void main(String[] args) {
        int i = 0;
        System.out.println("i = " + i + " " + (0 == i++));

        System.out.println("i = " + i + " " + (1 == ++i));
    }
}
