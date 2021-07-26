package com.king.M07;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @author: King
 * @create: 2021-07-26 10:04
 */
public class Test30 {

    static Test30 t30 = new Test30();

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 34.7 MB , 在所有 Java 提交中击败了 99.43% 的用户
     * n=1 1种
     * n=2 2种
     * n=3 3种
     * n=4 5种
     * n=5 8种
     * 自n>3后 f(n) = f(n-1) + f(n-2);
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] f = new int[]{1, 2, 3,};
        if (n <= 3) {
            return f[n - 1];
        }
        for (int i = 2; i < n; ++i) {
            f[2] = f[1] + f[0];
            f[0] = f[1];
            f[1] = f[2];

        }
        return f[2];

    }

    public static void main(String[] args) {
        Helper.print(t30.climbStairs(5));
    }
}
