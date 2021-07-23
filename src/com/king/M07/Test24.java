package com.king.M07;

import com.king.Helper;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode
 * @description: 1893. 检查是否区域内所有整数都被覆盖
 * https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 * @author: King
 * @create: 2021-07-23 14:33
 */
public class Test24 {
    /**
     * 暴力法
     *
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public boolean isCovered1(int[][] ranges, int left, int right) {
        boolean[] flag = new boolean[51];
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                flag[i] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (!flag[i]) return false;
        }
        return true;
    }


    public boolean isCovered2(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        for (int[] range : ranges) {
            int l = range[0];
            int r = range[1];
            if (l <= left && left <= r) {
                left = r + 1;
            }
        }
        return left > right;
    }

    public boolean isCovered3(int[][] ranges, int left, int right) {
        boolean[] flag = new boolean[51];
        Helper.print(flag);
        for(int[] range : ranges){
            int L = Math.max(range[0],left);
            int R = Math.min(range[1],right);
            for(int i = L; i <= R; i++){
                flag[i] = true;
            }
        }
        for(int i = left; i <= right; i++){
            if(!flag[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {

        Test24 t24 = new Test24();

       // Helper.print(t24.isCovered1(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5));
        Helper.print(t24.isCovered3(new int[][]{{1, 10}, {10, 20}, {5, 6}}, 21, 21));
    }
}
