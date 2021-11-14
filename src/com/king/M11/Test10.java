package com.king.M11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-11-13 21:15
 */
public class Test10 {
    public static void main(String[] args) {
        String filter = "2.2内存中如何存放数据";

        String gogogo = filter.replaceAll("((\\d*)(\\.\\d*)?|0)","");
        System.out.println(gogogo);

        Pattern pattern = Pattern.compile("((\\d*)(\\.\\d*)?|0)");
        Matcher m = pattern.matcher(filter);
        String str = "";
        if (m.find()) {
            str = m.group(1);
        }
        System.out.println(str);
    }


}
