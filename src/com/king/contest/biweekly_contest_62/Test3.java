package com.king.contest.biweekly_contest_62;

/**
 * @program: leetcode
 * @description: 5873. 考试的最大困扰度
 * @author: King
 * @create: 2021-10-02 23:06
 */
public class Test3 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char [] chars = answerKey.toCharArray();
        int ln = chars.length;
        int count = 0,max = 0;
        char ch = chars[0];
        for (int i = 1; i < ln; i++) {
            if (ch == chars[i]){
                ++count;
            }else {
                ch = chars[i];
            }
        }

        return 0;
    }
}
