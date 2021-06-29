package com.king.M06;

/**
 * @program: leetcode
 * @description: 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @author: King
 * @create: 2021-06-27 21:14
 */
public class Test10 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35 MB, 在所有 Java 提交中击败了93.09%的用户
     * @param n
     * @return
     */
    public int fib1(int n) {
        long[] f = new long[]{0, 1, 1, 2};
        if (n < f.length)
            return (int) f[n];

        for (int i = 3; i <= n; i++) {
            f[3] = ((f[2] + f[1]) % 1000000007);
            f[1] = f[2];
            f[2] = f[3];
        }

        return (int) f[3];
    }

    public int fib(int n) {
        long[] f = new long[]{0, 1, 1};
        if (n < f.length)
            return (int) f[n];

        for (int i = 2; i <= n; i++) {
            f[2] = ((f[1] + f[0]) % 1000000007);
            f[0] = f[1];
            f[1] = f[2];
        }

        return (int) f[2];
    }

    public int fib2(int n) {
        if (n < 2) return n;
        long[] result = new long[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
            result[i] %= (Math.pow(10, 9) + 7);
        }
        return (int) result[n];

    }

    public static void main(String[] args) {
        System.out.println(new Test10().fib(81));
        System.out.println(new Test10().fib1(81));
    }
}

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0, &nbsp; F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */