package com.king.M10;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 260. 只出现一次的数字 III
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-10-30 01:12
 */
public class Test30 {

    //给定一个整数数组?nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
    //
    //?
    //
    //进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？


    //执行用时： 6 ms , 在所有 Java 提交中击败了 10.85% 的用户 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 8.84% 的用户
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] arr = new int[2];
        int a = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                arr[a++] = m.getKey();
            }
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
