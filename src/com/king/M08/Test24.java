package com.king.M08;

import com.king.Helper;

import java.awt.*;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1646. 获取生成数组中的最大值
 * https://leetcode-cn.com/problems/get-maximum-in-generated-array
 * @author: King
 * @create: 2021-08-23 23:22
 */
public class Test24 {
    //给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
    //
    //nums[0] = 0
    //nums[1] = 1
    //当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
    //当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
    //返回生成数组 nums 中的 最大 值。

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.1 MB , 在所有 Java 提交中击败了 73.89% 的用户
    private int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }
        return getArrMax(nums);

    }

    public static int getArrMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }

    public int getMaximumGenerated1(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }
        return Arrays.stream(nums).max().getAsInt();
    }

    public static void main(String[] args) {
        Test24 test24 = new Test24();
        Helper.print(test24.getMaximumGenerated1(22));
        Helper.print(test24.getMaximumGenerated(22));
    }


}
