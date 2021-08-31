package com.king.M08;

import com.king.Helper;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1109. 航班预订统计
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 * @author: King
 * @create: 2021-08-31 14:49
 */
public class Test31 {

    //执行用时： 1530 ms , 在所有 Java 提交中击败了 13.58% 的用户 内存消耗： 53.4 MB , 在所有 Java 提交中击败了 54.06% 的用户
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] arr = new int[n];
        for (int[] nums : bookings) {
            for (int i = nums[0] - 1; i < nums[1]; ++i) {
                arr[i] += nums[2];
            }
        }
        return arr;
    }

    //执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 53 MB , 在所有 Java 提交中击败了 83.26% 的用户
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n + 2];

        for (int[] booking : bookings) {
            arr[booking[0]] += booking[2];
            arr[booking[1] + 1] -= booking[2];
        }
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
        }
        return Arrays.copyOfRange(arr, 1, n + 1);
    }

    public static void main(String[] args) {
        Test31 test31 = new Test31();
        //输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
        //输出：[10,55,45,25,25]
        //解释：
        //航班编号        1   2   3   4   5
        //预订记录 1 ：   10  10
        //预订记录 2 ：       20  20
        //预订记录 3 ：       25  25  25  25
        //总座位数：      10  55  45  25  25
        //因此，answer = [10,55,45,25,25]

        int[][] arrs = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        Helper.print(test31.corpFlightBookings(arrs, 5));

    }
}
