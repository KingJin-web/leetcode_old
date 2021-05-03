package com.king.M05;

/**
 * @program: leetcode
 * @description: 7. 整数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 * @author: King
 * @create: 2021-05-03 23:26
 */
public class Test3 {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.3 MB, 在所有 Java 提交中击败了92.72%的用户
     * @param x
     * @return
     */
    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }

        return (int) n == n ? (int) n : 0;
    }

    public static void main(String[] args) {
        System.out.println(new Test3().reverse(123));
    }
}
