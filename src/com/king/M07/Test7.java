package com.king.M07;

/**
 * @program: leetcode
 * @description: 275. H 指数 II
 * @author: King
 * @create: 2021-07-12 23:53
 */
public class Test7 {
    public int hIndex(int[] citations) {
        int n = citations.length, h = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (h < citations[i]) h++;
        }
        return h;

    }
}
