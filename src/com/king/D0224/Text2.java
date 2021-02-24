package com.king.D0224;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-02-25 00:26
 */
public class Text2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] a = solution.transpose(matrix);

        System.out.println(Arrays.deepToString(a));
    }
}

class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                arr[j][i] = matrix[i][j];
            }
        }

        return arr;
    }
}