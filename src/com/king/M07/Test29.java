package com.king.M07;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 * @author: King
 * @create: 2021-07-25 23:39
 */
public class Test29 {
    //F(0) = 0，F(1) = 1
    //F(n) = F(n - 1) + F(n - 2)，其中 n > 1
    public int fib1(int n) {
        int[] F = new int[]{0, 1, 0};
        if (n <= 1)
            return F[n];
        for (int i = 1; i < n; ++i) {
            F[2] = F[1] + F[0];
            F[0] = F[1];
            F[1] = F[2];
        }
        System.gc();
        return F[2];
    }
    /**
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        int[] F = new int[]{0, 1, 0};
        if (n <= 1)
            return F[n];
        for (int i = 1; i < n; ++i) {
            F[2] = F[1] + F[0];
            F[0] = F[1];
            F[1] = F[2];
        }
        return F[2];
    }

    static Test29 t29 = new Test29();

    public static void main(String[] args) {

        Helper.print(t29.fib(10));
        Helper.print(t29.fib(4));
    }
}
