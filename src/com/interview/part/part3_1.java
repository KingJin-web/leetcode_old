package com.interview.part;

/**
 * @program: leetcode
 * @description: 3-1 数列求值
 * @author: King
 * @create: 2021-08-22 13:03
 */
public class part3_1 {

    //f(n) = f(n-1)+f(n-2)+f(n-3) +1
    public int getSum(int n) {
        int[] F = new int[]{0, 0, 0, 1};
        if (n < F.length) {
            return F[n];
        }
        for (int i = 3; i < n; i++) {
            F[3] = F[0] + F[1] + F[2] + 1;
            F[0] = F[1];
            F[1] = F[2];
            F[2] = F[3];

        }
        return F[2];
    }

    public static void main(String[] args) {
        part3_1 part31 = new part3_1();
        System.out.println(part31.getSum(20000000));
    }
}
