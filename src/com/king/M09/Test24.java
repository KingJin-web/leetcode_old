package com.king.M09;

import com.king.Helper;
import com.king.util.MyPrint;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-24 11:25
 */
public class Test24 {

    public String replace1(String s) {
        return s.replace(" ", "%20");
    }

    public String replace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Test24 test24 = new Test24();
        MyPrint.print(test24.replace("Hello  World "));
        int[][] arrs = new int[][]{
                Helper.getArrays(1, 2, 3),
                Helper.getArrays(4, 5, 6),
                Helper.getArrays(7, 8, 9)
        };
        MyPrint.print(test24.findNumberIn2DArray(arrs, 8));
        MyPrint.print(arrs);
        MyPrint.print(Helper.getArrays(1,2,3,7));
    }

    public static class T2{
        public static void main(String[] args) {
            int a = 0,c = 0;
            do {
                --c;
            }while (a > 0);
            MyPrint.print(c);
        }

    }
}
