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
    /**
     * 通过
     * 显示详情
     * 执行用时：14 ms, 在所有 Java 提交中击败了7.26% 的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了97.98% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = concat(nums1, nums2);

        sort(arr);

        int a = arr.length / 2;
        if (arr.length % 2 == 0) {

            return (double) (arr[a] + arr[a - 1]) / 2;
        } else {
            return (double) arr[a];
        }

    }

    static int[] concat(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    public int[] sort(int[] sourceArray) {
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
        int[] nums1 = {}, nums2 = {3, 5, 4};
        Test2 t2 = new Test2();

        System.out.println(t2.findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了13.45% 的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了97.06% 的用户
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[n + m];
        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
        }
        arrMerge(arr, m, nums2, n);
        int a = arr.length / 2;
        if (arr.length % 2 == 0) {

            return (double) (arr[a] + arr[a - 1]) / 2;
        } else {
            return (double) arr[a];
        }

    }

    private void arrMerge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int a = m + n - 1;
        //判断两个数组，进行遍历比较
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[a--] = nums1[i--];
            } else {
                nums1[a--] = nums2[j--];
            }
        }
        //如果nums1遍历提前结束，将nums2剩下的所有数字直接给nums1
        if (i < 0) {
            for (int b = j; b >= 0; b--) {
                nums1[a--] = nums2[b];
            }
        }
        //如果nums2遍历提前结束，此时nums1已经排序结束，无需今进行下一步操作
    }


}
