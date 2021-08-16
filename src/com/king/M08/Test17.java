package com.king.M08;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 551. 学生出勤记录 I
 * https://leetcode-cn.com/problems/student-attendance-record-i/
 * @author: King
 * @create: 2021-08-17 00:38
 */
public class Test17 {
    /**
     * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
     * <p>
     * 'A'：Absent，缺勤
     * 'L'：Late，迟到
     * 'P'：Present，到场
     * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
     * <p>
     * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
     * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
     * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
     */

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 59.04% 的用户
     *
     * @param s
     * @return
     */
    public boolean checkRecord1(String s) {

        char[] chars = s.toCharArray();
        int A = 0;
        for (char ch : chars) {
            if (ch == 'A') {
                ++A;
            }
            if (A >= 2) {
                return false;
            }
        }
        return !s.contains("LLL");
    }

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 83.16% 的用户
    public boolean checkRecord(String s) {
        return (!s.contains("LLL"))&& (s.indexOf(65) == s.lastIndexOf(65));
    }
    public static void main(String[] args) {
        Test17 test17 = new Test17();
        Helper.print(test17.checkRecord("PPPLLA"));


    }
}
