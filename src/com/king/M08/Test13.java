package com.king.M08;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1897. 重新分配字符使所有字符串都相等
 * https://leetcode-cn.com/problems/redistribute-characters-to-make-all-strings-equal/
 * @author: King
 * @create: 2021-08-14 14:24
 */
public class Test13 {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 98.63% 的用户
     * 内存消耗： 38 MB , 在所有 Java 提交中击败了 70.58% 的用户
     *
     * @param words
     * @return
     */
    public boolean makeEqual(String[] words) {

        int[] arr = new int[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                ++arr[ch - 'a'];
            }
        }
        int n = words.length;
        for (int num : arr) {
            if (num % n != 0) {
                return false;
            }
        }
        return true;
    }


}
