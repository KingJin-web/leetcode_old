package com.king.M07;

import com.king.Helper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 167. 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @author: King
 * @create: 2021-07-23 16:33
 */
public class Test25 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 33.20% 的用户
     * 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 99.91% 的用户
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; ++i) {
            if (!map.containsKey(numbers[i])) {
                map.put(target - numbers[i], i);
            } else {
                System.gc();
                return new int[]{map.get(numbers[i]) + 1, i + 1};
            }
        }
        System.gc();
        return new int[2];
    }

    /**
     * 双指针
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 二分查找
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum3(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Test25 t25 = new Test25();
        Helper.print(t25.twoSum(Helper.getArrays(2, 7, 11, 15), 9));

    }


    public static class SuperTest extends Date {
        private static final long serialVersionUID = 1L;
        private void test(){
            System.out.println(super.getClass().getName());
        }

        public static void main(String[]args){
            new SuperTest().test();
        }
    }
}
