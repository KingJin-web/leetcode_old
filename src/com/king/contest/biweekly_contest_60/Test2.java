package com.king.contest.biweekly_contest_60;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-04 23:34
 */
public class Test2 {
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    list.add(findFarmland(i, j, new int[]{i, j, 0, 0}, land));
                }
            }
        }
        return list.toArray(new int[0][]);
    }

    private int[] findFarmland(int i, int j, int[] result, int[][] land) {
        if (i < land.length && j < land[0].length && land[i][j] == 1) {
            land[i][j] = 0;
            result[2] = Math.max(result[2], i);
            result[3] = Math.max(result[3], j);
            findFarmland(i, j + 1, result, land);
            findFarmland(i + 1, j, result, land);
        }
        return result;
    }
}
