package com.king.M08;

import com.king.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: leetcode
 * @description: 581. 最短无序连续子数组
 * @author: King
 * @create: 2021-08-03 15:33
 */
public class Test3 {
    static Test3 t3 = new Test3();

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 55.31% 的用户
     * 内存消耗： 39.2 MB , 在所有 Java 提交中击败了 92.33% 的用户
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (arr[i] != nums[i]) {
                list.add(i);
            }
        }
        return list.size() == 0? 0 :list.get(list.size() - 1) - list.get(0) + 1;

    }

    public static void main(String[] args) {
        Helper.print(t3.findUnsortedSubarray(Helper.getArrays(2, 6, 4, 8, 10, 9, 15)));
    }


}
