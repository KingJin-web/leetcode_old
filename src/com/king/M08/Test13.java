package com.king.M08;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1897. ???¡¤?????????????????????
 * https://leetcode-cn.com/problems/redistribute-characters-to-make-all-strings-equal/
 * @author: King
 * @create: 2021-08-14 14:24
 */
public class Test13 {
    /**
     * ???????? 2 ms , ?????? Java ???§Ý????? 98.63% ?????
     * ???????? 38 MB , ?????? Java ???§Ý????? 70.58% ?????
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
