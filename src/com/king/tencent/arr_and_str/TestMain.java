package com.king.tencent.arr_and_str;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestMain {
    Test3 t3 = new Test3();


    @Test
    public void longestPalindrome() {
        String str = "addadasassss123456789987654321sssasassa";
               System.out.println(t3.longestPalindrome(str));
    }
    Test4 t4 = new Test4();


    @Test
    public void myAtoi() {
        //System.out.println(t4.myAtoi("  -1234 aa"));
        System.out.println(t4.myAtoi("aa"));
    }

    public static void main(String[] args) {
        int a = Integer.parseInt("-123");
        System.out.println(a);
    }
}