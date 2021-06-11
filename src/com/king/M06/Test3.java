package com.king.M06;

/**
 * @program: leetcode
 * @description: 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 * @author: King
 * @create: 2021-06-11 23:32
 */
public class Test3 {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}
