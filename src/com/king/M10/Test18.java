package com.king.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 476. Êý×ÖµÄ²¹Êý
 * https://leetcode-cn.com/problems/number-complement/
 * @author: King
 * @create: 2021-10-18 01:10
 */
public class Test18 {
    public int findComplement(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }

    public static void main(String[] args) {
        Test18 test18 = new Test18();
        MyPrint.print(test18.findComplement(123));
    }
}
