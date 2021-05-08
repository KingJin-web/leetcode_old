package com.king.M05;

/**
 * @program: leetcode
 * @description: 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 统计一个数字在排序数组中出现的次数。
 * @author: King
 * @create: 2021-05-08 21:06
 */
public class Test10 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了28.09%的用户
     * 内存消耗：41.2 MB, 在所有 Java 提交中击败了83.75%的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int count = 0;
        for (int i : nums) {
            if (target == i) {
                count++;
            }
            if (count > 0 && target != i) {
                return count;
            }
        }
        return count;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.4 MB, 在所有 Java 提交中击败了58.97%的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target)
                right = mid;
            if (nums[mid] < target)
                left = mid + 1;
        }
        while (left < nums.length && nums[left++] == target)
            count++;
        return count;
    }
}
