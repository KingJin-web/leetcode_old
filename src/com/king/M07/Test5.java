package com.king.M07;

import com.king.Helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @author: King
 * @create: 2021-07-12 23:09
 */
public class Test5 {

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 66.35%
     * 的用户
     * 内存消耗：
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 9.80%
     * 的用户
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
        for(int i = 0; i < len; i++) {
            // ② map中查找是否有 target - curvalue的数据
            if(mp.containsKey(target - nums[i]))
                return new int[]{mp.get(target - nums[i]), i};

            // ① 数组中的每个数放入map中
            mp.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Test5 t5 = new Test5();

        System.out.println(Arrays.toString(t5.twoSum(Helper.getArrays(2, 7, 11, 15), 9)));
    }
}
