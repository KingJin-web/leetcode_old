package com.king.M08;

/**
 * @program: leetcode
 * @description: 844. 比较含退格的字符串
 * https://leetcode-cn.com/problems/backspace-string-compare/
 * @author: King
 * @create: 2021-08-16 00:01
 */
public class Test14 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 73.99% 的用户
     * 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 92.87% 的用户
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        return test(s).equals(test(t));
    }

    public static String test(String s) {
        StringBuilder ret = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar != '#') {
                ret.append(aChar);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {

    }
}
