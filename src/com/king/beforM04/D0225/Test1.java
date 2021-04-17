package com.king.beforM04.D0225;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1317. 将整数转换为两个无零整数的和
 * @author: King
 * @create: 2021-02-25 14:55
 */
public class Test1 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] a = solution.getNoZeroIntegers(10131);
        System.out.println(Arrays.toString(a));

    }
}

