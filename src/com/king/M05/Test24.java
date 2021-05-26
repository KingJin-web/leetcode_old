package com.king.M05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: 1190. 反转每对括号间的子串
 * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * @author: King
 * @create: 2021-05-26 23:40
 */
public class Test24 {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }
}

