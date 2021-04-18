package com.king.tencent.arr_and_str;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Date;

/**
 * @program: leetcode
 * @description: 最长回文子串
 * @author: King
 * @create: 2021-04-18 14:25
 */
@Aspect//切面类:你要增强的功能写在这里
public class Test3 {

    /**
     * 中心扩展算法
     * 执行用时：32 ms, 在所有 Java 提交中击败了84.94%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了91.14%的用户
     * 我们知道回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - 1) - (left + 1) + 1;
    }

    public  String longestPalindrome2(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String tmp = s.substring(i, j);
                if (isPalindromic(tmp) && tmp.length() > max) {
                    ans = tmp;
                    max = j - i;
                }
            }
        }
        return ans;
    }

    private  boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Around("execution(* com.king.tencent.arr_and_str.Test3.longestPalindrome()*(..))")
    public Object compute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("**********compute2进入了   增强。。。");
        long start = System.currentTimeMillis();
        Object retVal=pjp.proceed();
        long end=System.currentTimeMillis();
        System.out.println("**********compute2退出增强了。。。");
        System.out.println("时长为"+(end-start));
        return retVal;
    }
}


