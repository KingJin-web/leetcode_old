package com.king.M08;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * @author: King
 * @create: 2021-08-18 23:18
 */
public class Test18 {
//    输入：s = "   fly me   to   the moon  "
//    输出：4

    //调用api
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.7 MB , 在所有 Java 提交中击败了 43.29% 的用户
    public int lengthOfLastWord1(String s) {
        s = s.trim();
        return s.substring(s.lastIndexOf(' ') + 1).length();
    }

    //使用split
    //执行用时： 1 ms , 在所有 Java 提交中击败了 37.67% 的用户 内存消耗： 36.9 MB , 在所有 Java 提交中击败了 17.59% 的用户
    public int lengthOfLastWord2(String s) {
        String[] strings = s.split(" ");
        int ln = strings.length - 1;
        while (strings[ln] != null) {
            return strings[ln--].length();
        }
        return 0;
    }

    //从右向左遍历，从第一个不是空格的字符开始计数，一旦开始计数，再遇到空格就结束了
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.8 MB , 在所有 Java 提交中击败了 30.39% 的用户
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        Test18 test18 = new Test18();
        Helper.print(test18.lengthOfLastWord("   fly me   to   the moon  "));
        ;
    }
}
