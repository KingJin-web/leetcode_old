package com.nowcoder.M08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: [编程题]数组变换
 * 牛牛有一个数组，里面的数可能不相等，现在他想把数组变为：所有的数都相等。问是否可行。
 * 牛牛可以进行的操作是：将数组中的任意一个数改为这个数的两倍。
 * 这个操作的使用次数不限，也可以不使用，并且可以对同一个位置使用多次。
 * @author: King
 * @create: 2021-08-10 21:50
 */
public class Test1 {

    static int anotherIs2Power(int num) {
        while ((num & 1) == 0)
            num >>= 1;
        return num;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = anotherIs2Power(in.nextInt());

            }
            Arrays.sort(arr);
            System.out.println(arr[0] == arr[n - 1] ? "YES" : "NO");
        }

    }

}
