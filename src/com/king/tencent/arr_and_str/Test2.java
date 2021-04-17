package com.king.tencent.arr_and_str;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 寻找两个正序数组的中位数
 * https://leetcode-cn.com/leetbook/read/tencent/xx6c46/
 * @author: King
 * @create: 2021-04-17 15:37
 */
public class Test2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int[] arr = concat(nums1, nums2);
        arr = sort(arr);
        if (arr.length % 2 == 0) {
            int n = arr.length / 2;
            return (double) (arr[n] + arr[n - 1]) / 2;
        } else {
            int n = arr.length / 2;
            return (double) arr[n];
        }

    }

    static int[] concat(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    public int[] sort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 5}, nums2 = {3, 5, 4};
        Test2 t2 = new Test2();
        int[] arr = concat(nums1, nums2);
        System.out.println(Arrays.toString(arr));
        t2.findMedianSortedArrays(nums1, nums2);
    }


}
