package com.king.M05;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author: King
 * @create: 2021-05-08 21:12
 */
public class Test11 {
    static int nums[] = {5, 7, 7, 8, 8, 10}, target = 8;

    public int[] searchRange(int[] nums, int target) {
        int l = nums.length;

        if (l == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }
        int[] arr = new int[]{-1, -1};
        int c = 0;

        for (int i = 0; i < l; i++) {
            if (target == nums[i]) {
                arr[c++] = i;
            }
        }

        return arr;
    }

    public int[] searchRange(int[] nums, int target,int a) {
        int[] res = new int[] {-1, -1};
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }
    //leftOrRight为true找左边界 false找右边界
    public int binarySearch(int[] nums, int target, boolean leftOrRight) {
        int res = -1;
        int left = 0, right = nums.length - 1, mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(target < nums[mid])
                right = mid - 1;
            else if(target > nums[mid])
                left = mid + 1;
            else {
                res = mid;
                //处理target == nums[mid]
                if(leftOrRight)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        System.out.println(Arrays.toString(test11.searchRange(nums, target)));
        ;
    }
}
