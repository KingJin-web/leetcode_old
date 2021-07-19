package com.king.M07;

import com.king.Helper;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 1838. 最高频元素的频数
 * https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
 * @author: King
 * @create: 2021-07-19 19:35
 */
public class Test17 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        for (int r = 1; r < n; ++r) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    //    输入：nums = [1,4,8,13], k = 5
//    输出：2
//    解释：存在多种最优解决方案：
//            - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
//            - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
//            - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
    public static void main(String[] args) {
        Test17 t17 = new Test17();
        Helper.print(t17.maxFrequency(Helper.getArrays(1, 4, 8, 13), 5));
    }


}
