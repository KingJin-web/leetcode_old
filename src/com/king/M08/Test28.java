package com.king.M08;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 1480. 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 * 链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
 * @author: King
 * @create: 2021-08-28 22:39
 */
public class Test28 {
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 61.07% 的用户
    public int[] runningSum(int[] nums) {
        int ln = nums.length;
        int[] result = new int[ln];
        int count = 0;
        for (int i = 0; i < ln; ++i) {
            result[i] = count+=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
//        输入：nums = [3,1,2,10,1]
//        输出：[3,4,6,16,17]
        Test28 test28 = new Test28();
        Helper.print(test28.runningSum(Helper.getArrays(3,1,2,10,1)));
    }
}
