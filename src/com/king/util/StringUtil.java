package com.king.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-04 13:35
 */
public class StringUtil  {
    private static Logger logger = Logger.getLogger(StringUtil.class.getName());

    /**
     * Convert String to int, return the specified value if it fails
     *
     * @param s
     * @param n
     * @return
     */
    private static int getInt(String s, int n) {
        int num;
        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
//            MyPrint.printError(e.getMessage());
            logger.info(e.getMessage());
            return n;
        }
        return num;
    }

    /**
     * Convert String to int, return zero if it fails
     *
     * @param s
     * @return
     */
    public static int getInt(String s) {
        return getInt(s, 0);
    }


    public static void main(String[] args) {
        MyPrint.print(getInt("22"));
        MyPrint.print(getInt("--22"));
        MyPrint.print(getInt(""));
    }
}
