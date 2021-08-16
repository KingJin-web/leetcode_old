package com.king.M08;


import com.king.Helper;

import java.util.*;

/**
 * @program: leetcode
 * @description: 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @author: King
 * @create: 2021-08-16 22:07
 */
public class Test16 {

    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 20.52% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 88.82% 的用户
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 67.53% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 75.50% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = addSet(nums1);
        Set<Integer> set2 = addSet(nums2);
        return intersectionSet(set1, set2);
    }


    public static Set<Integer> addSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }

    public static int[] intersectionSet(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() < set2.size()) {
            return intersectionSet(set2, set1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                result.add(num);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    private static int[] ListToArray(List<Integer> result) {
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    public static int[] intersectionSet1(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() < set2.size()) {
            return intersectionSet1(set2, set1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
        Test16 test16 = new Test16();
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        Helper.print(test16.intersection(nums1, nums2));
    }
}
