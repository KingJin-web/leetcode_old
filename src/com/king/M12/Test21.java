package com.king.M12;

import com.king.util.MyPrint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: leetcode
 * @description: 1154. 一年中的第几天
 * @author: King
 * @create: 2021-12-21 22:03
 */
public class Test21 {

    //执行用时： 9 ms , 在所有 Java 提交中击败了 89.60% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 62.77% 的用户
    public int dayOfYear1(String date) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] str = date.split("-");
        int day = Integer.parseInt(str[2]);
        int month = Integer.parseInt(str[1]);
        int year = Integer.parseInt(str[0]);
        for (int i = 0; i < month - 1; i++) {
            day += months[i];
        }
        if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && month > 2) {
            day += 1;
        }

        return day;
    }

    public static void main(String[] args) {
        Test21 test = new Test21();
        MyPrint.print(test.dayOfYear("2004-12-31"));
    }


    //执行用时： 113 ms , 在所有 Java 提交中击败了 5.11% 的用户 内存消耗： 41.8 MB , 在所有 Java 提交中击败了 5.11% 的用户
    public int dayOfYear2(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date time = sdf.parse(date);
            long time1 = time.getTime();
            long time2 = getYearFirstDay(Integer.parseInt(date.substring(0, 4)));
            return (int) ((time1 - time2) / (24 * 60 * 60 * 1000)) + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;

    }

    /**
     * 获取某年第一天日期开始时刻
     *
     * @param year 时间
     * @return Date
     */
    public static long getYearFirstDay(int year) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR,year);
        return cal.getTimeInMillis();
    }

    //执行用时： 33 ms , 在所有 Java 提交中击败了 10.95% 的用户 内存消耗： 40 MB , 在所有 Java 提交中击败了 9.49% 的用户
    public int dayOfYear(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).getDayOfYear();

    }
}
