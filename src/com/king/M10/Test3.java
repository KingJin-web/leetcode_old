package com.king.M10;

import com.king.util.MyPrint;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 166. 分数到小数
 * @author: King
 * @create: 2021-10-04 00:03
 */
public class Test3 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long a = numerator, b = denominator;
        if (a > 0 && b < 0 || a < 0 && b > 0) sb.append('-');
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b);
        if (a % b == 0) return sb.toString();
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while ((a = (a % b) * 10) > 0 && !map.containsKey(a)) {
            map.put(a, sb.length());
            sb.append(a / b);
        }
        if (a == 0) return sb.toString();
        return sb.insert(map.get(a).intValue(), '(').append(')').toString();
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        MyPrint.print(test3.fractionToDecimal(1,2));
    }
}
