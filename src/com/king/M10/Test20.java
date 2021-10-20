package com.king.M10;

/**
 * @program: leetcode
 * @description: 453. 最小操作次数使数组元素相等
 * @author: King
 * @create: 2021-10-20 23:14
 */
public class Test20 {

    // 优化前 2 ms
    public int minMoves1(int[] nums) {
        int l = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - l * min;
    }

    // 优化后 1 ms
    //执行用时： 2 ms , 在所有 Java 提交中击败了 73.83% 的用户
    //内存消耗： 39 MB , 在所有 Java 提交中击败了 16.53% 的用户
    public int minMoves(int[] nums) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
