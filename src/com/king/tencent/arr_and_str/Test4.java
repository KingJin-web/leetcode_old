package com.king.tencent.arr_and_str;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 字符串转换整数 (atoi)
 * @author: King
 * @create: 2021-04-18 15:46
 */
public class Test4 {


    /**
     执行用时：2 ms, 在所有 Java 提交中击败了99.59%的用户
     内存消耗：38.1 MB, 在所有 Java 提交中击败了96.93%的用户
     * @param s
     * @return
     */
    public int myAtoi(String s) {

        s = s.trim();
        if (s .equals("")){
            return 0;
        }
        char[] ch = toCharArray(s);
        int flag = 1;
        long sum = 0;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '-' && i == 0) {
                flag = -1;
                continue;
            }
            if (ch[i] == '+' && i == 0) {
                flag = 1;
                continue;
            }
            if (ch[i] >= '0' && ch[i] <= '9') {
                sum = (ch[i] - '0') + sum * 10;
            } else break;

            if (-sum <= -2147483648 && ch[0] == '-') return -2147483648;
            if (sum >= 2147483647 && ch[0] != '-') return 2147483647;
        }


        return (int) sum * flag;

    }

    public char[] toCharArray(String s) {

        char[] ch = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
        }
        return ch;
    }
}
