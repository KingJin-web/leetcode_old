package com.king.pta;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 7-6 小乐子闯鬼屋 (300 分)
 * @author: King
 * @create: 2021-04-20 12:56
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        double p = in.nextDouble();


        int[] arr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }




        int N2 = in.nextInt();
        double s = in.nextDouble();
        int[] arr2 = new int[N2];
        for (int i = 0; i < N2; i++) {
            arr2[i] = in.nextInt();
        }



        aVoid(arr,p);
        System.out.println();
        aVoid(arr2,s);
    }

    public static void aVoid(int[] arr, double p) {
        double p2 = 1 - p;
        double a = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] / 2 == 0)
                a *= p2;
            else
                a *= p;
        }
        System.out.printf("%.7f", a);
    }
}
