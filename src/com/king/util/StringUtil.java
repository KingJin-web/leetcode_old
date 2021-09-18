package com.king.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-17 20:46
 */
public class StringUtil {


    //检测字符串中是否有中文  不包含中文符号
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]+");
        Matcher m = p.matcher(str);
        return m.find();
    }

    //检测字符串中是否有双字节字符包含中文,中文符号
    public static boolean isContainTwoByte(String str) {
        Pattern p = Pattern.compile("[^\\x00-\\xff]");
        Matcher m = p.matcher(str);
        return m.find();
    }


}
