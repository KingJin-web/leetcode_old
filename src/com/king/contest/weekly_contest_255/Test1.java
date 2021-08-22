package com.king.contest.weekly_contest_255;

import com.king.Helper;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 5850. 找出数组的最大公约数
 * @author: King
 * @create: 2021-08-22 10:36
 */
public class Test1 {
/*    给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。

    两个数的 最大公约数 是能够被两个数整除的最大正整数。*/

    public int findGCD(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        int c = max % min;
        while (c != 0) {
            max = min;
            min = c;
            c = max % min;
        }
        return min;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Helper.print(test1.findGCD(Helper.getArrays(2,5,6,9,10)));
    }
}
