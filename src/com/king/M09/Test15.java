package com.king.M09;

import com.king.util.MyPrint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-15 09:19
 */
public class Test15 {
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]+");
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static boolean isContainChinese1(String str) {
        Pattern p = Pattern.compile("[^\\x00-\\xff]");
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static void main(String[] args) {
        MyPrint.print(isContainChinese1("123£¬1"));
        MyPrint.print(isContainChinese("Hello"));
        MyPrint.print("ÄãºÃ".matches("[\u4E00-\u9FA5]+"));;
    }
}
