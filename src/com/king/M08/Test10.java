package com.king.M08;

import com.king.Helper;
import com.king.MyAssert;
import org.junit.Assert;

/**
 * @program: leetcode
 * @description: 6. Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @author: King
 * @create: 2021-08-11 00:17
 * 例如对一个4行的
 * 0     6      12        18
 * 1   5 7   11 13    17
 * 2 4   8 10   14 16
 * 3     9      15
 */
public class Test10 {
//    public String convert(String s, int numRows) {
//        //当s的长度小于行数时，直接返回s
//        //当行数为1时，也直接返回s
//        if (s.length() < numRows || numRows == 1) {
//            return s;
//        }
//        int segment = 2 * numRows - 2;
//        StringBuilder stb = new StringBuilder(s.length());
//        // 输出头
//        for (int i = 0; i * segment < s.length(); i++) {
//            stb.append(s.charAt(i * segment));
//        }
//
//
//        return stb.toString();
//    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 97.51% 的用户
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        //当s的长度小于行数时，直接返回s
        //当行数为1时，也直接返回s
        int len = s.length();
        if (len < numRows || numRows == 1) {
            return s;
        }

        int segment = 2 * numRows - 2;
        StringBuilder target = new StringBuilder(len);
        // 输出头
        for (int i = 0; i * segment < len; ++i) {
            target.append(s.charAt(i * segment));
        }
        // 输出体
        int l = 0;
        for (int i = 0; i < numRows - 2; ++i) {
            for (int j = 0; j * segment + i + 1 < len; ++j) {
                // 输出一段的第一列
                target.append(s.charAt(j * segment + i + 1));
                // 输出一段的第二列，首先要判断第二列对应位置是否有元素，也就是索引不能超过s的长度
                l = j * segment + (segment - i - 1);

                if (l < len)
                    target.append(s.charAt(l));
            }
        }
        // 输出尾
        for (int i = 0; i * segment + numRows - 1 < len; i++) {
            target.append(s.charAt(i * segment + numRows - 1));
        }
        return target.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        Test10 test10 = new Test10();
        String a = test10.convert(s, 3);
        MyAssert.assertEquals("PAHNAPLSIIGYIR", a);


        Helper.print(a);

/**
 输入：s = "PAYPALISHIRING", numRows = 3
 输出："PAHNAPLSIIGYIR"
 示例 2：
 输入：s = "PAYPALISHIRING", numRows = 4
 输出："PINALSIGYAHRPI"
 **/
    }
}
