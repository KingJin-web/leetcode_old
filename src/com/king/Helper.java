package com.king;

import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-07-07 21:04
 */
public class Helper {
    public static int[] getArrays(int... nums) {
        return nums;
    }

    public static String[] getArrays(String... s) {
        return s;
    }

    public static List<String> getList(String... s) {
        return Arrays.asList(s);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void print(Object[] o) {
        System.out.println(Arrays.toString(o));
    }

    public static void print(Object[]... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public static void print(int[] ...s) {
        System.out.println(Arrays.deepToString(s));
    }

    public static void print(String[] ...s) {
        System.out.println(Arrays.deepToString(s));
    }

    public static void print(char[] ...chars) {
        System.out.println(Arrays.deepToString(chars));
    }
//    public static List<String> getArrays(String nums) {
//        return Arrays.asList(nums);
//    }
}
