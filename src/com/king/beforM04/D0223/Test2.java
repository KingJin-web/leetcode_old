package com.king.beforM04.D0223;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-02-23 23:24
 */
public class Test2 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        r.gc();
/*        // 得到JVM中的空闲内存量（单位是字节）
        System.out.println(r.freeMemory());
        // 的JVM内存总量（单位是字节）
        System.out.println(r.totalMemory());
        // JVM试图使用额最大内存量（单位是字节）
        System.out.println(r.maxMemory());
        // 可用处理器的数目
        System.out.println(r.availableProcessors());*/
        long startMem = r.freeMemory(); // 开始时的剩余内存


        int[] arr1 = {1, 9, 4, 6, 7,2,4,5,72,24,34};
        int[] ints1 = prevPermOpt1(arr1);
     //   System.out.println(Arrays.toString(ints1));



        long orz = startMem - r.freeMemory(); // 剩余内存 现在
        double a = orz / 1024;
        System.out.println(a);


        int[] arr2 = new int[]{1, 1, 5};
        int[] ints2 = prevPermOpt1(arr2);
        System.out.println(Arrays.toString(ints2));
    }



    public static int[] prevPermOpt1(int[] arr) {
        int a, b = 0;
        for (int i = arr.length - 1; i >= 1; i--) {

            if (arr[i - 1] > arr[i]) {
                int j = arr.length - 1;
                while (arr[j] >= arr[i - 1] || arr[j] == arr[j - 1])
                    j--;
                a = arr[i - 1];
                b = arr[j];
                arr[j] = a;
                arr[i - 1] = b;
                break;
            }
        }

        return arr;
    }
}
