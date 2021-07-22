package com.king;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-04-27 10:49
 */

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static int[] cnts = new int[6];
    //一开始就选择下标为最大的500
    //d = [0.05, 0.1, 0.2, 0.5, 1, 2]
    static double[] coins = {5, 10, 20, 50, 100, 200};

    public static void main(String[] args) {
        String s = "你好123asdf";

        System.out.println(chineseNumber(s));
        System.out.println(s.length());
        System.out.println(Arrays.toString(s.getBytes(StandardCharsets.UTF_8)));
    }


    public static int chineseNumber(String text) {
        int amount = 0;
        for (int i = 0; i < text.length(); i++) {

            if (Pattern.matches("^[\u4E00-\u9Fa5]{0,}$", String.valueOf(text.charAt(i)))) {
                amount++;
            }
        }
        return amount;
    }

    private static void test(int aa) {
        double count = 0;
        int c = 0;
        int i = 0, n = 0;
        for (i = 0; i < 6; i++) {
            count += cnts[i] * coins[i];
        }
        if (count < aa) {
            System.out.println("impossible");
            return;
        }
        i = 5;
        while (i >= 0) {
            if (aa >= coins[i]) {
                n = (int) (aa / coins[i]);
                if (n >= cnts[i]) {
                    n = cnts[i];
                }
                aa -= n * coins[i];
                //System.out.println(aa);
                c += n;
                //System.out.println("使用了" + n + "个" + coins[i]);
            }
            i--;
        }
        System.out.println(c);
    }

    public static class T1 {
        public static void main(String[] args) {
            Integer i1 = 100;
            Integer i2 = 100;
            Integer i3 = 200;
            Integer i4 = 200;
            Integer i5 = -100;
            Integer i6 = -100;

            Helper.printAddresses("i1", i1);
            Helper.printAddresses("i2", i2);
            Helper.printAddresses("i3", i3);
            Helper.printAddresses("i4", i4);
            Helper.getName(i1);

            System.out.println(i1 == i2);
            System.out.println(i3 == i4);
            System.out.println(i5 == i6);
        }
    }
}

