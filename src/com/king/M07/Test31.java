package com.king.M07;

import com.king.Helper;

import java.util.*;

/**
 * @program: leetcode
 * @description: 496. 下一个更大元素 I
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * @author: King
 * @create: 2021-07-27 16:58
 */
public class Test31 {
    private final Test31 a = this;

    private static final Test31 d = new Test31();


    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 97.49% 的用户
     * 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 53.39% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 先处理 nums2，把对应关系存入哈希表
        for (int j : nums2) {
            while (!stack.isEmpty() && stack.peekLast() < j) {
                map.put(stack.removeLast(), j);
            }
            stack.addLast(j);
        }

        // 遍历 nums1 得到结果集
        int[] res = new int[len1];
        for (int i = 0; i < len1; ++i) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        //输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
        //输出: [-1,3,-1]
        int[] a = d.nextGreaterElement(Helper.getArrays(4, 1, 2), Helper.getArrays(1, 3, 4, 2));
        Helper.print(a);

    }

    private static class Solution {

        /**
         * 暴力
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;

            int[] res = new int[len1];
            if (len1 < 1) {
                return res;
            }

            for (int i = 0; i < len1; i++) {
                int curVal = nums1[i];
                int j = 0;
                while (j < len2 && nums2[j] != curVal) {
                    j++;
                }

                // 此时 nums[j] = nums[i]
                j++;
                while (j < len2 && nums2[j] < curVal) {
                    j++;
                }

                if (j == len2) {
                    res[i] = -1;
                    continue;
                }
                res[i] = nums2[j];
            }
            return res;
        }
    }
}
