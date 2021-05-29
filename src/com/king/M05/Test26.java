package com.king.M05;

/**
 * @program: leetcode
 * @description: 67. 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * @author: King
 * @create: 2021-05-29 23:34
 */
public class Test26 {
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    public static void main(String[] args) {
        Test26 test26 = new Test26();
        System.out.println(test26.addBinary("11","1"));
    }
}
