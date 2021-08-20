package com.king.M08;

import com.king.Helper;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 541. 反转字符串 II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * @author: King
 * @create: 2021-08-20 10:11
 */
public class Test20 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 62.81% 的用户
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        int ln = s.length() - 1;

        char[] chars = s.toCharArray();
        for (int i = 0; i <= ln; i += 2 * k) {
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ln, i + k - 1);
            //用异或运算反转
            changArrays(chars, i, end);
        }
        return new String(chars);
    }

    public void changArrays(char[] chars, int left, int right) {
        while (left < right) {
            char ch = chars[left];
            chars[left] = chars[right];
            chars[right] = ch;
            ++left;
            --right;
        }
    }

    public static void main(String[] args) {
        Test20 test20 = new Test20();
        Helper.print(test20.reverseStr("abcdefg", 2));
        //输出："bacdfeg"
        Helper.print(test20.reverseStr("abcd", 4));
        //输出："dcba"
    }
}
