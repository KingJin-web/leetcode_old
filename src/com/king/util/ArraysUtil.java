package com.king.util;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.stream.IntStream;

/**
 * @program: leetcode
 * @description: Êý×é°ïÖúÀà
 * @author: King
 * @create: 2021-09-17 19:37
 */
public class ArraysUtil {

    /**
     * Sort the array from largest to smallest
     *
     * @param nums int[]
     */
    public static void sortBToS(int[] nums) {
        int ln = nums.length;
        Integer[] a = new Integer[ln];
        for (int i = 0; i < ln; ++i)
            a[i] = nums[i];
        sortBToS(a);
        for (int i = 0; i < ln; ++i)
            nums[i] = a[i];
    }

    /**
     * Sort the array from largest to smallest
     *
     * @param nums Integer[]
     */
    public static void sortBToS(Integer[] nums) {
        Arrays.sort(nums, (o1, o2) -> o2 - o1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 11, 23, 1, 33};
        sortBToS(a);
        MyPrint.print(a);
    }

    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - 1 - i; ++j) {
                if (a[j] > a[i]){
                    int t = a[j];
                    a[j] = a[i];
                    a[i] = t;
                }
            }
        }
    }
}
