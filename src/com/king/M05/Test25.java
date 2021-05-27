package com.king.M05;

/**
 * @program: leetcode
 * @description: 461. 汉明距离
 * https://leetcode-cn.com/problems/hamming-distance/
 * @author: King
 * @create: 2021-05-27 00:33
 */
public class Test25 {
    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
