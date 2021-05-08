package com.king.M05;

/**
 * @program: leetcode
 * @description: 1720. 解码异或后的数组
 * 考试
 * https://leetcode-cn.com/problems/decode-xored-array/
 * @author: King
 * @create: 2021-05-06 22:04
 */
public class Test8 {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }
}
