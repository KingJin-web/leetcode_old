package com.king;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-04-27 10:49
 */

import java.util.Scanner;

public class Main {
    static int[] cnts = new int[6];
    //一开始就选择下标为最大的500
    //d = [0.05, 0.1, 0.2, 0.5, 1, 2]
    static double[] coins = {5, 10, 20, 50, 100, 200};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        for (int i = 0; i < 6; i++) {
//            cnts[i] = sc.nextInt();
//        }
//        double aa = sc.nextDouble();
//        test((int) (aa * 100));
        while (n > 0) {
            for (int i = 0; i < 6; i++) {
                cnts[i] = sc.nextInt();
            }
            double aa = sc.nextDouble();
            test((int) (aa * 100));
            n--;
        }
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

}



