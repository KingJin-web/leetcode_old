package com.king.M05;

/**
 * @program: leetcode
 * @description: 35. 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 * @author: King
 * @create: 2021-05-04 11:45
 */
public class Test5 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了81.91%的用户
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        boolean a =true;
        return nums.length;
    }


    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.7 MB, 在所有 Java 提交中击败了97.99%的用户
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }

        return l;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(new Test5().searchInsert(nums,5));
    }
}
