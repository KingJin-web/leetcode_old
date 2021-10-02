package com.king.M10;

import com.king.util.MyPrint;

import java.time.LocalDateTime;

/**
 * @program: leetcode
 * @description: 5873. 考试的最大困扰度
 * @author: King
 * @create: 2021-10-02 16:30
 */
public class Test2 {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(3);

        System.out.println(localDateTime);
        MyPrint.print(localDateTime);
    }
}
