package com.king.D0406;

/**
 * @program: leetcode
 * @description: 80. 删除有序数组中的重复项 II
 * @author: King
 * @create: 2021-04-06 19:17
 */
public class Test1 {
    int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = new Test1().removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }
}
