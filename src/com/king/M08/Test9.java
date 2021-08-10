package com.king.M08;

import com.king.Helper;

import java.util.*;

/**
 * @program: leetcode
 * @description: 313. ³¬¼¶³óÊý
 * https://leetcode-cn.com/problems/super-ugly-number/
 * @author: King
 * @create: 2021-08-09 23:26
 */
public class Test9 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);
        for (int i = 2; i <= n; i++) {
            int[] nums = new int[m];
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }
            dp[i] = minNum;
            for (int j = 0; j < m; j++) {
                if (minNum == nums[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }

    public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        Map<Integer, Integer> primesMap = new HashMap<>();
        for (int prime : primes) {
            primesMap.put(prime, 0);
        }

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : primesMap.entrySet()) {
                min = Math.min(min, dp[entry.getValue()]*entry.getKey());
            }
            dp[i] = min;
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : primesMap.entrySet()) {
                if (dp[entry.getValue()]*entry.getKey() == min) {
                    list.add(entry.getKey());
                }
            }
            for (Integer key : list) {
                primesMap.put(key, primesMap.getOrDefault(key, 0)+1);
            }
        }

        Helper.print(dp,5);
        return dp[n-1];
    }

    static Test9 test8 = new Test9();
    public static void main(String[] args) {
        test8.nthSuperUglyNumber(12,Helper.getArrays(2,7,13,19));
        test8.nthSuperUglyNumber1(12,Helper.getArrays(2,7,13,19));

    }
}
