package com.king.D0224;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 两数之和
 * @author: King
 * @create: 2021-02-25 00:47
 */
public class Test3 {

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;

//        int[]   nums =   { 3, 2, 4 };
//        int target =   6;

        int[] nums = {2, 5, 5, 11};
        int target = 10;
        Solution1 solution1 = new Solution1();
        System.out.println(Arrays.toString(solution1.twoSum(nums, target)));

    }
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {

//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i = 0; i < nums.length; i++){
//            if(map.containsKey(nums[i])){
//                return new int[]{map.get(nums[i]), i};
//            }
//            map.put(target - nums[i], i);
//        }
//        return null;

        int a[] = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target && j != i) {
                    a = new int[]{i, j};
                    System.out.println(i + "```" + j);
                    return a;
                }
            }
        }
        return null;

    }
}