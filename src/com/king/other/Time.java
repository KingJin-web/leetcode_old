package com.king.other;

import java.util.Calendar;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-07-05 18:09
 */
public class Time {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        // 获取年
        int year = calendar.get(Calendar.YEAR);
        // 获取月，这里需要需要月份的范围为0~11，因此获取月份的时候需要+1才是当前月份值
        int month = calendar.get(Calendar.MONTH) + 1;
        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        // 获取时
        int hour = calendar.get(Calendar.HOUR);
        // int hour = calendar.get(Calendar.HOUR_OF_DAY); // 24小时表示
        // 获取分
        int minute = calendar.get(Calendar.MINUTE);
        // 获取秒
        int second = calendar.get(Calendar.SECOND);
        // 星期，英语国家星期从星期日开始计算
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);

        calendar.set(year,month,day,hour,minute,second);
        System.out.println(calendar.getTime());
    }
}
