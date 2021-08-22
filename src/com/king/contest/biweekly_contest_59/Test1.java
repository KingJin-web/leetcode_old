package com.king.contest.biweekly_contest_59;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 5834. 使用特殊打字机键入单词的最少时间
 * @author: King
 * @create: 2021-08-21 22:34
 */
public class Test1 {
    public int minTimeToType(String word) {
        int first = 0;
        int count = 0;
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            int ch = aChar - 'a';
            int max = Math.max(first,ch);
            int min = Math.min(first,ch);
            int num = Math.abs(max - min);
            count +=  (num>= 13 ?26 - num:num ) +1;
            first = ch;
        }

        return count;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        //Helper.print(test1.minTimeToType("abc"));
        Helper.print(test1.minTimeToType("bza"));
        //Helper.print(test1.minTimeToType("zjpc"));
    }
}
