package com.king.M07;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @author: King
 * @create: 2021-07-17 09:09
 */
public class Test13 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(num + sum, num);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Test13 t13 = new Test13();
        Helper.print(t13.maxSubArray(Helper.getArrays(-2,1,-3,4,-1,2,1,-5,4)));
    }
}
