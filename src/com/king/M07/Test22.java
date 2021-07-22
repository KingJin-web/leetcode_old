package com.king.M07;

import com.king.Helper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 剑指 Offer 03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @author: King
 * @create: 2021-07-22 10:30
 */
public class Test22 {
    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了30.74%的用户
     * 内存消耗：47.5 MB, 在所有 Java 提交中击败了23.74%的用户
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {

            if (hashMap.containsKey(num)) {
                return num;
            }
            hashMap.put(num, 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        Test22 t22 = new Test22();
        Helper.print(t22.findRepeatNumber(Helper.getArrays(9, 1, 2, 3, 1, 0, 2, 5, 3)));
        Helper.print(t22.findRepeatNumber1(Helper.getArrays(9, 1, 2, 3, 1, 0, 2, 5, 3)));
    }

    /**
     * 超时了 无语
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int num : nums) {
            if (array.contains(num)) {
                return num;
            }
            array.add(num);
        }
        return 0;


    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了84.17%的用户
     * 内存消耗：45.7 MB, 在所有 Java 提交中击败了96.54%的用户
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            ++arr[num];
            if (arr[num] > 1) return num;
        }
        return -1;
    }
}
