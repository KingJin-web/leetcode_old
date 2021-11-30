package com.king.M11;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 400. 第 N 位数字
 *
 * @author: King
 * @create: 2021-11-30 22:34
 */
public class Test30 {

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 34.9 MB , 在所有 Java 提交中击败了 96.02% 的用户
    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    public static void main(String[] args) {
        Test30 o = new Test30();
        MyPrint.print(o.findNthDigit(11));
    }
}
