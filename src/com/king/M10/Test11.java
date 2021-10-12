package com.king.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 29. 两数相除
 * https://leetcode-cn.com/problems/divide-two-integers/
 * @author: King
 * @create: 2021/10/12 21:27
 */
public class Test11 {
    private static final int MAX = 2147483647;

    public int divide(int dividend, int divisor) { //首先进行预处理
        if (divisor == 1) return dividend;
        if (divisor == -1) return dividend < MAX * -1 ? MAX : dividend * -1; //开始向减
        long res = 0, a = dividend, b = divisor, flag = -1;
        if (a >= 0 && b > 0 || a < 0 && b < 0) flag = 1;
        a = Math.abs(a);
        b = Math.abs(b);
        while (a >= b) {
            a -= b;
            res++;
        }
        return (int) (res * flag);
    }

    public static void main(String[] args) {
        Test11 test11  = new Test11();
        MyPrint.print(test11.divide(10,3));
    }
}
