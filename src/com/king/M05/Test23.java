package com.king.M05;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 剑指 Offer 40. 最小的k个数
 * @author: King
 * @create: 2021-05-25 23:25
 */
public class Test23 {
    //输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    public static void main(String[] args) {
        Test23 test23 = new Test23();
        int[] arr = {3,2,1};
        int k = 2;
        int[] a = test23.getLeastNumbers(arr,k);
        System.out.println(Arrays.toString(a));

    }
}
