package com.king.tencent.arr_and_str;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 两数之和
 * @author: King
 * @create: 2021-04-17 14:54
 */
public class Test1 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了73.42%的用户
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    arr = new int[]{i, j};
                    return arr;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        int[] nums = new int[]{2, 7, 11, 15}; //9
        nums = new int[]{2, 5, 5, 11};
        System.out.println(Arrays.toString(t1.twoSum(nums, 10)));
    }
}
