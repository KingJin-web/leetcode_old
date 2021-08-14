package com.king.M08;

/**
 * @program: leetcode
 * @description: 516. 最长回文子序列
 * @author: King
 * @create: 2021-08-12 23:33
 */
public class Test12 {

    public int longestPalindromeSubseq(String s) {
        String s2 = reverse(s);
        char[] chars = s.toCharArray();
        char c = ' ';
        int count = 0;
        for (char ch : chars) {
            if (ch == c){
                count++;
            }else {

            }
        }

        return count;
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

}
