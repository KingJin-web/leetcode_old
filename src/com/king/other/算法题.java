package com.king.other;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-07-10 14:45
 */
public class 算法题 {

    public static void main(String[] args) {
        int count = 0;
        double a = 500, b = 300, c = (double) 100 / 3;
        int i = 0;
        for (i = 0; i < 100; i++) {
            count +=a;
            if (count == 10000){
                break;
            }
        }
        System.out.println(count + " " + i);
    }

}
