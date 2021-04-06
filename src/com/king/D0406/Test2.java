package com.king.D0406;

/**
 * @program: leetcode
 * @description: 26. 删除有序数组中的重复项
 * @author: King
 * @create: 2021-04-06 19:34
 */
public class Test2 {
    int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }

        return ++j;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = new Test2().removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }

    }
}
