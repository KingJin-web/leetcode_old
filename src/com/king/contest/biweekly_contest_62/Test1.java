package com.king.contest.biweekly_contest_62;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 5871. 将一维数组转变成二维数组
 * @author: King
 * @create: 2021-10-02 22:35
 */
public class Test1 {
    //给你一个下标从 0 开始的一维整数数组 original 和两个整数 m 和  n 。你需要使用 original 中 所有 元素创建一个 m 行 n 列的二维数组。
    //original 中下标从 0 到 n - 1 （都 包含 ）的元素构成二维数组的第一行，
    // 下标从 n 到 2 * n - 1 （都 包含 ）的元素构成二维数组的第二行，依此类推。
    //请你根据上述过程返回一个 m x n 的二维数组。如果无法构成这样的二维数组，请你返回一个空的二维数组。
    public int[][] construct2DArray(int[] original, int m, int n) {
        int ln = original.length;
        if (n * m != ln) {
            return new int[0][];
        }
        int[][] result = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                result[i][j] = original[index++];
        return result;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        MyPrint.print(test1.construct2DArray(LeetcodeUtil.stringToIntegerArray("[1,2,3,4]"), 2, 2));
    }
}
