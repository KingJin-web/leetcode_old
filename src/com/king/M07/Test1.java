package com.king.M07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 645. 错误的集合
 * https://leetcode-cn.com/problems/set-mismatch/
 * @author: King
 * @create: 2021-07-04 19:34
 */
public class Test1 {
    public int[] findErrorNums1(int[] nums) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int c = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= c; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                arr[0] = i;
            } else if (count == 0) {
                arr[1] = i;
            }
        }
        return arr;
    }

    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int c = 1 , i = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            i = map.getOrDefault(c++,0);
            if (i == 2) {
                arr[0] = c - 1;
            } else if (i == 0) {

                arr[1] = c - 1;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 2, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(new Test1().findErrorNums(arr)));
    }

}
