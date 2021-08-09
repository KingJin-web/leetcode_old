package com.king.M08;

import com.king.Helper;
import org.junit.Assert;

/**
 * @program: leetcode
 * @description: 1137. 第 N 个泰波那契数
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 * @author: King
 * @create: 2021-08-08 22:46
 */
public class Test8 {
    /*    泰波那契序列 Tn 定义如下：
        T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
        给你整数 n，请返回第 n 个泰波那契数 Tn 的值。*/
    static Test8 test8 = new Test8();

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35 MB , 在所有 Java 提交中击败了 87.57% 的用户
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        int[] T = new int[]{0, 1, 1, 0};
        if (n < 3) {
            return T[n];
        }
        for (int i = 2; i < n; ++i) {
            T[3] = T[0] + T[1] + T[2];
            T[0] = T[1];
            T[1] = T[2];
            T[2] = T[3];
        }
        return T[3];
    }

    public static void main(String[] args) {
        String x="7";
        int y = 2;
        int z=2;
        System.out.println(x+y+z);
        Helper.print(test8.tribonacci(25));
    }
}
