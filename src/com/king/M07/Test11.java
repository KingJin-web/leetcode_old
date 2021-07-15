package com.king.M07;

import com.king.Helper;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1846. 减小和重新排列数组后的最大元素
 * https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/
 * @author: King
 * @create: 2021-07-15 12:01
 */
public class Test11 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < n; ++i) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        Test11 t11 = new Test11();
        int a = t11.maximumElementAfterDecrementingAndRearranging(Helper.getArrays(2,2,1,2,1));
        System.out.println(a);
        Helper.print(a);
    }
}
