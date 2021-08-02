package com.king.M08;

/**
 * @program: leetcode
 * @description: 28. й╣ож strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 * @author: King
 * @create: 2021-08-02 23:21
 */
public class Test2 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()){
            return -1;
        }
        return haystack.indexOf(needle);
    }
}
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)||haystack.equals(needle)) {
            return 0;
        }
        int n = haystack.length(), m = needle.length();
        char[] chh = toCharArray(haystack, n);

        char[] chn = toCharArray(needle, m);
        int index = 0 ,c = 0;
        for (int i = 0; i < n - m; i++) {
            for (int j = 0; j < m; j++) {
                if (chh[i] == chn[j]) {
                    index = i;
                    for (; i < n - m; i++) {
                        for (; j < m; j++) {
                            if (chh[i] == chn[j]) {
                                c++;
                            }
                            if (c == m){
                                return index;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public char[] toCharArray(String str, int length) {

        char[] ch = new char[length];

        for (int i = 0; i < length; i++) {
            ch[i] = str.charAt(i);
        }
        return ch;
    }
}