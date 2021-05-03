package com.king.M05;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-05-03 21:39
 */
public class Main {

    public static void main(String[] args) {
        char ch1 = getchar();
        char ch2 = getchar();
        putchar(ch1,ch2);
    }


    public static char getchar() {
        char ch = 0;Scanner in = new Scanner(System.in);
        try  {
            String s = in.next();

            ch = s.charAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ch;
    }

    public static void putchar(char... chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            System.out.print(chars[i] + ",");
        }
        System.out.println(chars[chars.length - 1]);

        switch (chars[1]){

        }
    }
}
