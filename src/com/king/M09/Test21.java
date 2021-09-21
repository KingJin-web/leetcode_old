package com.king.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 58. 最后一个单词的长度
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-09-21 18:26
 */
public class Test21 {
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.6 MB , 在所有 Java 提交中击败了 60.96% 的用户
    public int lengthOfLastWord(String s) {

        char[] chars = s.trim().toCharArray();

        int ln = chars.length;
        int c = 0;
        for (int i = ln - 1; i >= 0; --i) {
            if (chars[i] == ' ') {
                return c;
            } else {
                ++c;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Test21 test21 = new Test21();
//        MyPrint.print(test21.lengthOfLastWord("Hello World"));
//        MyPrint.print(test21.lengthOfLastWord("   fly me   to   the moon  "));
        MyPrint.print(test21.lengthOfLastWord("a"));

    }
    //给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
    //
    //单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。


}
