package com.king.M06;

/**
 * @program: leetcode
 * @description: 剑指 Offer 15. 二进制中1的个数
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @author: King
 * @create: 2021-06-23 23:17
 */
public class Test9 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.4 MB, 在所有 Java 提交中击败了41.04%的用户
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(new Test9().hammingWeight(00000000000000000000000000001011));
    }
}
