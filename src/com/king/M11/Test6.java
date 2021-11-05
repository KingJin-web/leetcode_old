package com.king.M11;

import com.king.Helper;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 268. 丢失的数字
 * https://leetcode-cn.com/problems/missing-number/
 * @author: King
 * @create: 2021-11-06 01:31
 */
public class Test6 {

    //给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

    //执行用时： 2 ms , 在所有 Java 提交中击败了 35.76% 的用户 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 59.78% 的用户
    public int missingNumber1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int a = 0;
        for (int i = 1; i <= n; ++i) {
            a += i;
        }
        return a - sum;
    }

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 23.15% 的用户
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int a = 0;
        for (int i = 1; i <= n; ++i) {
            a += i;
            sum += nums[i - 1];
        }
        return a - sum;
    }

    public static void main(String[] args) {
        Test6 test6 = new Test6();

        MyPrint.print(test6.missingNumber(Helper.getArrays(9, 6, 4, 2, 3, 5, 7, 0, 1)));
    }
}
