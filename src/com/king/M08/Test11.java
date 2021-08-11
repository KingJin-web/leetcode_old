package com.king.M08;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 413. 等差数列划分
 * https://leetcode-cn.com/problems/arithmetic-slices/
 * @author: King
 * @create: 2021-08-11 22:34
 */
public class Test11 {

    static Test11 test11 = new Test11();
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 47.28% 的用户
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int ln = nums.length;
        if (ln < 3) {
            return 0;
        }
        int c = nums[0] - nums[1];
        int count = 0, a, result = 0;
        for (int i = 2; i < ln; ++i) {
            a = nums[i - 1] - nums[i];
            if (a == c) {
                ++count;
            } else {
                c = a;
                count = 0;
            }

            result += count;
        }

        return result;
    }

    public static void main(String[] args) {
        Helper.print(test11.numberOfArithmeticSlices(Helper.getArrays(1,2,3,4)));
    }
}
