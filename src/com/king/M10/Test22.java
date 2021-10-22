package com.king.M10;

import com.king.Helper;
import com.king.util.MyPrint;

import java.util.*;

/**
 * @program: leetcode
 * @description: 229. 求众数 II
 * @author: King
 * @create: 2021-10-22 20:37
 */

public class Test22 {
    //给定一个大小为 n 的整数数组，找出其中所有出现超过 ? n/3 ? 次的元素。

    //执行用时： 11 ms , 在所有 Java 提交中击败了 28.12% 的用户 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 94.25% 的用户
    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length;
        int n = length / 3;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                list.add(entry.getKey());
            }

        }
        return list;
    }

    public static void main(String[] args) {
        Test22 test22 = new Test22();
        MyPrint.print(test22.majorityElement(Helper.getArrays(1, 1, 2, 3, 6, 1, 1)));
    }
}
