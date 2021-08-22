package com.king.contest.biweekly_contest_59;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 5837. 划分数字的方案数
 * @author: King
 * @create: 2021-08-21 23:25
 */
public class Test4 {
    public int numberOfCombinations(String num) {
        char[] chars = num.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            char chi = chars[i];
            int count = 0;
            for (int j = i + 1; j < chars.length; j++) {
                char chj = chars[j];
                if (chj >= chi) {
                     Helper.print(chi + " " + chj);
                    ++count;
                    chi = chj;
                } else {
                    break;
                }
            }
            result += count;
        }
        return result + 1;
    }

    public static void main(String[] args) {
        Test4 t4 = new Test4();
        Helper.print(t4.numberOfCombinations("327"));
        Helper.print(t4.numberOfCombinations("9999999999999"));
    }
}
