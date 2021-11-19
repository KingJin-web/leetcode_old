package com.king.M11.Test19;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-11-19 20:32
 */
public class Test3 {
    public static int[] answer(int x) {
        return t3(t2(t1(x)));
    }

    private static int[] t3(int t2) {

        String s = String.valueOf(t2);
        int n = s.length();

        int[] arr = new int[n * 7];
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < n; ++j) {
                arr[i * n + j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }

        }


        return arr;
    }

    private static int t2(int[] t1) {
        int[] arr = new int[t1.length];
        int i = 0;
        for (int n : t1) {
            arr[i++] = Math.abs(n);
        }
        Arrays.sort(arr);
        int c = 0;
        for (i = 0; i < arr.length - 1; ++i) {
            int i1 = arr[i + 1] - arr[i];
            c += Math.min(i1, 4);
        }

        return c + 4;

    }

    private static int[] t1(int x) {
        List<Integer> list = new ArrayList<>();
        int num = 2;
        for (int i = 0; i < 9; ++i) {
            list.add(num);
            num += x;
        }

        return sort(list.stream().mapToInt(i -> i).toArray());
    }
    public static int[] sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - 1 - i; ++j) {
                if (a[j] < a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
        return a;
    }
    public static void main(String[] args) {
        answer(41);
        MyPrint.print(t1(5));
    }
}
