package com.king.M11.Test19;

import com.king.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-11-19 19:38
 */
public class Test1 {

    public static int[] answer(int x) {

        return t3(t2(t1(x)));
    }

    public static int t1(int x) {
        int num = Math.abs(x);
        if (num < 21) {
            num = 21;
        }

        while (num % 10 != num) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;

        }

        return num;
    }

    public static int[] t2(int x) {
        List<Integer> list = new ArrayList<>();
        int c = 0;
        for (int i = 1; i <= x; ++i) {
            if (x % i == 0 && c <= 6) {
                list.add(i);
                ++c;
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] t3(int[] a) {
        int n = a.length;

        int[] arr = new int[n * 4];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = a[i / 4];
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(t3(Helper.getArrays(1, 2, 3))));
    }
}
