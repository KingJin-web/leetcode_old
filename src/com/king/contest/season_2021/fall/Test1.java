package com.king.contest.season_2021.fall;

import com.king.util.MyPrint;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 1. 无人机方阵
 * https://leetcode-cn.com/problems/0jQkd0/
 * https://leetcode-cn.com/contest/season/2021-fall/problems/0jQkd0/
 * @author: King
 * @create: 2021-09-11 15:57
 */
public class Test1 {
    public int minimumSwitchingTimes1(int[][] source, int[][] target) {
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

        for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
            c += entry2.getValue();
        }
        return c;
    }

    //执行用时： 4 ms , 在所有 Java 提交中击败了 100.00% 的用户
    // 内存消耗： 40 MB , 在所有 Java 提交中击败了 100.00% 的用户
    public int minimumSwitchingTimes(int[][] A, int[][] B) {
        int n = A.length, m = A[0].length, res = 0;
        int[] cnt = new int[10005];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                cnt[A[i][j]]++;
                cnt[B[i][j]]--;
            }
        for (int i : cnt) if (i > 0) res += i;
        return res;
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
        nums1 = new int[][]{{989, 498, 941, 850, 992, 367, 914, 224, 143, 144, 98, 819, 932, 723, 617, 151, 102, 76, 871, 339, 574, 363, 324, 656, 210, 566, 454, 534, 64, 941, 938, 96, 861, 728, 804, 641, 627, 848, 342, 748, 721, 65, 940, 228, 823, 146, 557, 94, 328, 521, 502, 309, 299, 128, 341, 945, 209, 819, 561, 295, 94, 818, 325, 248, 189, 842, 34, 673, 488, 92, 776, 898, 946, 863, 920, 946, 554, 401, 723, 283, 832, 870, 917, 604, 973, 594, 462, 677, 718, 813, 85, 628, 499, 646, 866, 249, 750, 120, 226, 814}};
        nums2 = new int[][]{{524, 415, 803, 311, 489, 598, 930, 517, 289, 774, 634, 257, 546, 830, 924, 318, 748, 921, 701, 484, 104, 445, 626, 935, 990, 489, 887, 267, 825, 562, 15, 737, 409, 845, 685, 2, 506, 889, 250, 334, 892, 196, 582, 245, 991, 823, 459, 83, 897, 956, 112, 565, 724, 561, 835, 554, 987, 618, 602, 456, 611, 395, 590, 298, 194, 192, 628, 267, 71, 696, 134, 154, 40, 83, 717, 850, 700, 858, 538, 535, 242, 221, 696, 846, 430, 282, 505, 657, 939, 366, 333, 119, 602, 344, 195, 17, 278, 723, 381, 175}};
        // 93
        a = test1.minimumSwitchingTimes(nums1, nums2);
        MyPrint.print(a);
    }
}
