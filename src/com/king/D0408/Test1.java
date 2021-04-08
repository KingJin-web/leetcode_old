package com.king.D0408;

import java.util.Date;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-04-08 19:05
 */
public class Test1 {
    /**
     * 循环查找
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.7 MB, 在所有 Java 提交中击败了85.54%的用户
     *
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int min = nums[0];
        for (int i : nums) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1;
        int pivot;
        while (left < right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] < nums[right]) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {

        int arr[] = new int[]{3, 4, 5, 6, 1, 2};
        Date date = new Date();
        long date1 = date.getTime();
        int a = new Test1().findMin1(arr);
        long date2 = date.getTime();
        int b = new Test1().findMin2(arr);
        long date3 = date.getTime();

        System.out.println((date2 - date1) + " " + (date3 - date2) + "\n " + a + " " + b);
    }
}
