package com.king.M07;

import com.king.Helper;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 面试题 17.10. 主要元素
 * https://leetcode-cn.com/problems/find-majority-element-lcci/
 * @author: King
 * @create: 2021-07-09 23:00
 */
public class Test3 {
    public static Test3 t3 = new Test3();

    public int majorityElement(int[] nums) {

        int l = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.get(num) > l){
                return num;
            }
        }

        System.out.println(map);
        return 0;
    }

    public static void main(String[] args) {
    int a = t3.majorityElement(Helper.getArrays(1,2,5,9,5,9,5,5,5));
        System.out.println(a);
    }
}
