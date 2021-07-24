package com.king.M07;

import com.king.Helper;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 1736. 替换隐藏数字得到的最晚时间
 * https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/
 * @author: King
 * @create: 2021-07-24 09:17
 */
public class Test26 {
//    给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
//    有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
//    替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.7 MB , 在所有 Java 提交中击败了 40.79% 的用户
     *
     * @param time
     * @return
     */
    public String maximumTime(String time) {

        char[] chars = time.toCharArray();
        if (chars[0] == '?') {
            if (chars[1] == '?') {
                chars[0] = '2';
                chars[1] = '3';
            } else {
                if (chars[1] <= '3') {
                    chars[0] = '2';
                } else {
                    chars[0] = '1';
                }
            }
        }
        if (chars[1] == '?') {
            if (chars[0] == '0' || chars[0] == '1') {
                chars[1] = '9';
            } else {
                chars[1] = '3';
            }
        }
        Helper.print(Arrays.toString(chars));
        if (chars[3] == '?') chars[3] = '5';
        if (chars[4] == '?') chars[4] = '9';
        return new String(chars);

    }

    public static void main(String[] args) {
        Test26 t26 = new Test26();
        Helper.print(t26.maximumTime("2?:??"));
        Helper.print(t26.maximumTime("?0:15"));
        Helper.print(t26.maximumTime("??:3?"));
        Helper.print(t26.maximumTime("?0:15"));
    }
}
