package com.part;

import java.math.BigInteger;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-08-21 22:10
 */
public class part1_1 {
    static int  SwapOddEvenBits(int num)
    {
        return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
    }


    public static void main(String[] args) {
        System.out.println(SwapOddEvenBits(585));
        System.out.println(SwapOddEvenBits(58));
    }
}
