package com.king.contest.weekly_contest_257;

import com.king.Helper;
import com.king.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 5863. 统计特殊四元组
 * @author: King
 * @create: 2021-09-05 10:57
 */
public class Test1 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public int countQuadruplets(int[] nums) {
        int co = 0;
        subsets(nums);
        for (List<Integer> list : res) {
            if (list.size() == 4) {
                System.out.println(list);
                int a = list.get(0);
                int b = list.get(1);
                int c = list.get(2);
                int d = list.get(3);
                if (a + b + c == d) {
                    ++co;
                }

            }
        }
        return co;
    }

    public int findMiddleIndex(int[] nums) {
        int right = 0;
        for (int num : nums) {
            right += num;
        }
        for (int i = 0, left = 0; i < nums.length; i++) {
            if (left == (right -= nums[i])) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

}

