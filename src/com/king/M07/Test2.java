package com.king.M07;

import com.king.Helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-07-07 20:50
 */
public class Test2 {

    public static Test2 t2 = new Test2();


    /**
     * 执行用时：145 ms, 在所有 Java 提交中击败了57.63%的用户
     * 内存消耗：46.8 MB, 在所有 Java 提交中击败了97.97%的用户
     *
     * @param deliciousness
     * @return
     */
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = Arrays.stream(deliciousness).max().getAsInt();

        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = deliciousness.length;
        for (int val : deliciousness) {
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }

    public static void isPowerOfTwos(int... nums) {
        for (int n : nums) {
            System.out.println(n + " " + isPowerOfTwo(n));
        }
    }

    public static void main(String[] args) {

        System.out.println(t2.countPairs(Helper.getArrays(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println(t2.countPairs2(Helper.getArrays(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    public int countPairs2(int[] deliciousness) {
        int res = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                int count = deliciousness[i] + deliciousness[j];
                if (isPowerOfTwo(count)) {
                    res++;
                    res %= 1000000007;
                }
            }
        }
        return res;
    }

    int[] arr = Helper.getArrays();
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
