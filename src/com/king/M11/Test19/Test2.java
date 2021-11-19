package com.king.M11.Test19;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-11-19 20:13
 */
public class Test2 {
    /**
     * 请勿修改返回值类型
     */
    public static int[] answer(int x) {
        return t3(t2(t1(x)));
    }

    public static int[] t1(int x) {
        x = Math.abs(x);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= x; ++i) {
            if (x % i == 0) {
                list.add(i);
            }
        }

        if (list.size() > 2) {
            //大到小
            return new int[]{list.get(list.size() - 1), list.get(list.size() - 2)};
        } else {
            return new int[]{list.get(0), list.get(1)};
        }

    }

    public static int[] t2(int[] a) {
        if (a[0] + a[1] == 21) {
            return new int[]{0, 1};
        } else {
            return a;
        }
    }

    public static int[] t3(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int[] arr = new int[n * 3];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = a[i / 3];
        }
        return arr;
    }

    public static void main(String[] args) {
        MyPrint.print(t1(72));
    }
}
