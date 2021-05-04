package com.king.M05;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1480. 一维数组的动态和
 * https://leetcode-cn.com/problems/running-sum-of-1d-array/
 * @author: King
 * @create: 2021-05-04 13:43
 */
public class Test6 {
    static int[] nums = {1, 2, 3, 4};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Test6().runningSum(nums)));
        System.out.println(Arrays.toString(new Test6().runningSum2(nums)));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了97.40%的用户
     * @param nums
     * @return
     */
    public int[] runningSum2(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            arr[i] = sum;
        }

        return arr;
    }

    /**
     执行用时：1 ms, 在所有 Java 提交中击败了12.96%的用户
     内存消耗：37.6 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @return
     */
    public int[] runningSum3(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            arr[i] = sum;
        }
        System.gc();
        return arr;
    }

    /**
     * 比较傻
     * 执行用时：3 ms, 在所有 Java 提交中击败了11.11%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了75.09%的用户
     *
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sumArr(nums, i);
        }
        return arr;
    }

    public int sumArr(int[] nums, int l) {
        int count = 0;
        for (int i = 0; i <= l; i++) {
            count += nums[i];
        }
        return count;
    }
}
