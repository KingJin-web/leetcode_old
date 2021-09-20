package com.king.M09;

import com.king.Helper;
import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author: King
 * @create: 2021-09-20 18:35
 */
public class Test20 {
    //给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    //
    //子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
    // 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

    //执行用时： 62 ms , 在所有 Java 提交中击败了 48.99% 的用户 内存消耗： 37.7 MB , 在所有 Java 提交中击败了 95.66% 的用户
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        Test20 test20 = new Test20();
        MyPrint.print(test20.lengthOfLIS(Helper.getArrays(10, 9, 2, 5, 3, 7, 101, 18)));
    }
}
