package com.king.M07;

import com.king.Helper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/
 * @author: King
 * @create: 2021-07-11 11:03
 */
public class Test4 {
    private static Test4 test4 = new Test4();

    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了9.15%的用户
     * 内存消耗：44.4 MB, 在所有 Java 提交中击败了30.11%的用户
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = 0;
        for (int num : nums) {
            n = map.getOrDefault(num, 0);
            map.put(num, ++n);
            if (n >= 2) {
                return true;
            }
            // System.out.println(num + " " +n);
        }
        //System.out.println(map);
        return false;
    }

    public static void main(String[] args) {
        boolean b = test4.containsDuplicate(Helper.getArrays(1, 1, 1, 3, 3, 4, 3, 2, 4, 2));
        System.out.println(b);
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了53.90%的用户
     * 内存消耗：42.5 MB, 在所有 Java 提交中击败了53.60%的用户
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length; ) {
            res.add(nums[i]);
            if (res.size() < ++i) {
                return true;
            }
        }
        return false;

    }

}
