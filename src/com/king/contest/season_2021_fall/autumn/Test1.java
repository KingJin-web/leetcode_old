package com.king.contest.season_2021_fall.autumn;

import com.king.util.MyPrint;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 1. 无人机方阵
 * @author: King
 * @create: 2021-09-11 15:57
 */
public class Test1 {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int m = source.length;
        int n = source[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map1.put(source[i][j], map1.getOrDefault(source[i][j], 0) + 1);
                map2.put(target[i][j], map2.getOrDefault(target[i][j], 0) + 1);
            }
        }
        int c = 0;
        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            if (map2.get(entry1.getKey()) != null) {
                c = Math.abs(map2.remove(entry1.getKey()) - entry1.getValue());
            }
        }


//        for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
//            //c += entry2.getValue();
//        }
        return c;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[][] nums1 = new int[][]{{1, 2, 3}, {3, 4, 5}};
        int[][] nums2 = new int[][]{{1, 3, 5}, {2, 3, 4}};
        int a = test1.minimumSwitchingTimes(nums1, nums2);
        MyPrint.print(a);
        nums1 = new int[][]{{1, 3}, {5, 4}};
        nums2 = new int[][]{{3, 1}, {6, 5}};
        //a = test1.minimumSwitchingTimes(nums1, nums2);

        nums1 = new int[][]{{1, 2, 3, 4, 5, 7}, {7, 5, 4, 3, 2, 1}};
        nums2 = new int[][]{{1, 2, 3, 4, 5, 6}, {7, 5, 4, 3, 2, 1}};
        a = test1.minimumSwitchingTimes(nums1, nums2);
        MyPrint.print(a);
    }
}
