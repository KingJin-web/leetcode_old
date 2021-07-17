package com.king.M07;

import com.king.Helper;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-07-17 09:14
 */
public class Test14 {

    /**
     * 	5 ms	38.9 MB
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = toCharArray(s);
        char[] str2 = toCharArray(t);
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


    public static void main(String[] args) {
        Test14 t14 = new Test14();
        String s = "anagram", t = "nagaram";
        Helper.print(t14.isAnagram1(s,t));
        Helper.print(t14.isAnagram(s,t));
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.5 MB
     * , 在所有 Java 提交中击败了
     * 75.51%
     * 的用户
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] charCountS = new int[26];
        int[] charCountT = new int[26];
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        for (char c : charArrayS) {
            ++charCountS[c-'a'];
        }
        for (char c : charArrayT) {
            ++charCountT[c-'a'];
        }
        for(int i = 0; i < 26; ++i){
            if(charCountS[i]  != charCountT[i]){
                return false;
            }
        }
        return true;
    }
    public char[] toCharArray(String s) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return chars;
    }



}
