package com.king.M07;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 665. 非递减数列
 * https://leetcode-cn.com/problems/non-decreasing-array/
 * @author: King
 * @create: 2021-07-20 19:08
 */
public class Test19 {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                nums[i] = y;
                if (isSorted(nums)) {
                    return true;
                }
                nums[i] = x; // 复原
                nums[i + 1] = x;
                return isSorted(nums);
            }
        }
        return true;
    }

    public boolean isSorted(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test19 t19 = new Test19();
        Helper.print(t19.checkPossibility(Helper.getArrays(4,2,1)));
    }
}
