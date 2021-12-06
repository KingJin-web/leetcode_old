package com.king.M12;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 1816. ½Ø¶Ï¾ä×Ó
 * @author: King
 * @create: 2021-12-06 22:25
 */
public class Test6 {
    public String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ' ' && --k == 0)
                return s.substring(0, i);
        return s;
    }

    public static void main(String[] args) {
        Test6 test6 = new Test6();
        MyPrint.print(test6.truncateSentence("",4));
    }
}
