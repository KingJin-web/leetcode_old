package com.king.M11.Test19;

import com.king.Helper;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-11-19 21:14
 */
public class Test4 {
    public static int answer(int[] x) {
        return t3(t2(t1(x)));
    }

    private static int t1(int[] x) {
        int[] arr = new int[x.length];
        int i = 0;
        for (int n : x) {
            arr[i++] = Math.abs(n);
        }
        Arrays.sort(arr);
        int c = 0;
        for (i = 0; i < arr.length - 1; ++i) {
            int i1 = arr[i + 1] - arr[i];
            c += Math.min(i1, 1);
        }

        return c + 1;

    }

    private static int[] t2(int t1) {

        return null;
    }

    private static int t3(int[] t2) {

        return 0;
    }

    public static void main(String[] args) {
        MyPrint.print(t1(Helper.getArrays(6, 9, 1)));
        MyPrint.print(t1(Helper.getArrays(6, 2, 3, 1)));
    }
}
