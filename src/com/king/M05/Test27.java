package com.king.M05;

/**
 * @program: leetcode
 * @description: 231. 2 的幂
 * https://leetcode-cn.com/problems/power-of-two/
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * @author: King
 * @create: 2021-05-30 23:46
 */
public class Test27 {
//    执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：35.5 MB, 在所有 Java 提交中击败了46.48%的用户
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if ((n & n - 1) == 0) return true;
        return false;
    }

    public static void main(String[] args) {

    }
}
