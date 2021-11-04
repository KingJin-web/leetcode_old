package com.king.M11;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 1218. 最长定差子序列
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 * @author: King
 * @create: 2021-11-05 02:23
 */
public class Test5 {

    //执行用时： 34 ms , 在所有 Java 提交中击败了 86.80% 的用户 内存消耗： 55.4 MB , 在所有 Java 提交中击败了 28.94% 的用户
    public int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int j : arr) {
            Integer val = map.get(j - difference);
            if (val != null) {
                map.put(j, val + 1);
                max = Math.max(max, val + 1);
            } else
                map.put(j, 1);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
