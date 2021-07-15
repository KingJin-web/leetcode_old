package com.king.M07;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 53. 最大子序和
 * @author: King
 * @create: 2021-07-14 23:06
 */
public class Test10 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了95.44%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了61.47%的用户
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0], count = 0;
        for (int num : nums) {
            count = Math.max(count + num, num);
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Test10 t10 = new Test10();
        int a = t10.maxSubArray(Helper.getArrays(-2, 1, -3, 4, -1, 2, 1, -5, 4));
        System.out.println(a);
    }
}
