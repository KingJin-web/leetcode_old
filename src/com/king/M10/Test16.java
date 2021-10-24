package com.king.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 69. Sqrt(x)
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-10-17 17:10
 */
public class Test16 {

    //执行用时： 55 ms , 在所有 Java 提交中击败了 5.12% 的用户
    // 内存消耗： 35.2 MB , 在所有 Java 提交中击败了 94.11% 的用户
    public int mySqrt(int x) {
        int a = 1;
        while (x / a >= a) {
            ++a;
        }
        return --a;
    }

    //给你一个非负整数 x ，计算并返回?x?的 算术平方根 。
    //
    //由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
    //
    //注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
    //

    public static void main(String[] args) {
        Test16 test16 = new Test16();
        MyPrint.print(test16.mySqrt(13));
    }
}
