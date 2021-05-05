package com.king.M05;

/**
 * @program: leetcode
 * @description: 740. 删除并获得点数
 * @author: King
 * @create: 2021-05-05 08:58
 */
public class Test7 {
    /**
     *执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了52.68%的用户
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int max = nums[0];
        for (int i = 0; i < len; ++i) {
            max = Math.max(max, nums[i]);
        }
//      构造一个新的数组all
        int[] all = new int[max + 1];
        for (int item : nums) {
            all[item]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = all[1] * 1;
        dp[2] = Math.max(dp[1], all[2] * 2);
//      动态规划求解
        for (int i = 2; i <= max; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
        }
        return dp[max];
    }

    static int[] nums = {2, 2, 3, 3, 3, 4};

    public static void main(String[] args) {
        Test7 t7 = new Test7();
        System.out.println(t7.deleteAndEarn(nums));;
    }
}
