package com.king.beforM04.D0408;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        String s = "-4193 with words";
        System.out.println(new Test2().myAtoi1(s));
        System.out.println(new Test2().myAtoi2(s));
    }

    private int myAtoi2(String s) {
        String regEx = "^[\\+\\-]?\\d+";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(s);
        matcher.find();

        return Integer.parseInt(matcher.group()) ;
    }

    public int myAtoi1(String s) {

        if (s.length() == 1) {
            return Integer.parseInt(s);
        }
        char str[] = s.toCharArray();
        int n = str.length;
        int index = 0;
        while (index < n && str[index] == ' ') {
            index++;
        }
        if (index == n) {
            return 0;
        }
        boolean negative = false;
        if (str[index] == '-') {
            //遇到负号
            negative = true;
            index++;
        } else if (str[index] == '+') {
            // 遇到正号
            index++;
        } else if (!Character.isDigit(str[index])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (index < n && Character.isDigit(str[index])) {
            int digit = str[index] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            index++;
        }
        return negative ? -ans : ans;

    }

}
