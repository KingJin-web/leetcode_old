package com.king.M04;

/**
 * @program: leetcode
 * @description: 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * @author: King
 * @create: 2021-04-15 19:56
 */
public class Test4 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};

        Test4 t4 = new Test4();
        System.out.println(t4.rob(nums));

    }

    /*

     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];



//        return Math.max(findMax(nums,))
    }
}
