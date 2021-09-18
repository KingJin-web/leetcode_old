package com.king.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @program: testSpring
 * @description: 时间工具类
 * @author: King
 * @create: 2021-05-08 20:51
 */
public class TimeUtil {

    /**
     * 输出 为yyyy-MM-dd HH:mm:ss 格式 的字符串时间
     *
     * @return
     */
    public static String nowTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 转换的时间枚举
     */
    public enum DateFormatEnum {
        yyyyMMddHHmmssSSS,
        yyyyMMddHHmmss,
        yyyyMMddHHmm,
        yyyyMMdd
    }

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static String nowToString() {
        return now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * case 后面只能是枚举值
     *
     * @param type
     * @return
     */
    public static String nowToString(DateFormatEnum type) {
        String str = null;
        switch (type) {
            case yyyyMMddHHmmssSSS:
                str = "yyyy-MM-dd HH:mm:ss.SSS";
                break;
            case yyyyMMddHHmm:
                str = "yyyy-MM-dd HH:mm";
                break;
            case yyyyMMdd:
                str = "yyyy-MM-dd";
                break;
            default:
                str = "yyyy-MM-dd HH:mm:ss";
                break;
        }

        return now().format(DateTimeFormatter.ofPattern(str));
    }
}
