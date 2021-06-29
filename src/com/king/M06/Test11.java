package com.king.M06;

/**
 * @program: leetcode
 * @description: 168. Excel表列名称
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 * @author: King
 * @create: 2021-06-29 19:31
 */
public class Test11 {
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            str.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }

        return str.reverse().toString();

    }


    public static void main(String[] args) {
       String a =  new Test11().convertToTitle(2147483647);
        System.out.println(a);
    }
}
