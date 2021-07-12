package com.king.M07;

import com.king.Helper;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * @author: King
 * @create: 2021-07-12 23:45
 */
public class Test6 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了43.52%的用户
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    public static void main(String[] args) {
        new Test6().merge(Helper.getArrays(1,2,3,0,0,0),3,Helper.getArrays(2,5,6),3);
    }
}
