package com.king.M11;

/**
 * @program: leetcode
 * @description: 598. 范围求和 II
 * https://leetcode-cn.com/problems/range-addition-ii/
 * @author: King
 * @create: 2021-11-07 23:43
 */
public class Test7 {

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
    //内存消耗： 38.4 MB , 在所有 Java 提交中击败了 66.72% 的用户
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int[] op : ops) {
            a = Math.min(a, op[0]);
            b = Math.min(b, op[1]);
        }
        return a * b;
    }
}
