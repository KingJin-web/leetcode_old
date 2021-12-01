package com.king.M11;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 520. 检测大写字母
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-12-01 01:10
 */
public class Test13 {
//我们定义，在以下情况时，单词的大写用法是正确的：
//
//全部字母都是大写，比如 "USA" 。
//单词中所有字母都不是大写，比如 "leetcode" 。
//如果单词不只含有一个字母，只有首字母大写，?比如?"Google" 。
//给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
//

    //执行用时： 1 ms , 在所有 Java 提交中击败了 94.63% 的用户 内存消耗： 36.9 MB , 在所有 Java 提交中击败了 11.22% 的用户
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int upper = 0;//大写字母个数
        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                ++upper;
            }
        }
        if (upper == chars.length) {
            return true;
        } else if (upper == 0) {
            return true;
        } else return Character.isUpperCase(chars[0]) && upper == 1;
    }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        MyPrint.print(test13.detectCapitalUse("SKT"));
        MyPrint.print(test13.detectCapitalUse("Google"));
    }

    public boolean detectCapitalUse1(String word) {
        char[] cs = word.toCharArray();
        int upper = 0;//大写字母个数
        int lower = 0;//小写字母个数
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'a') {
                lower++;
            } else {
                upper++;
            }
        }
        if (upper == cs.length) { //全大写
            return true;
        }
        if (lower == cs.length) {//全小写
            return true;
        }
        if (upper == 1 && cs[0] < 'a') {//首字母大写
            return true;
        }
        return false;
    }
}
