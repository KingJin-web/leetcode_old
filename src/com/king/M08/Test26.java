package com.king.M08;

import com.king.Helper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 881. 救生艇
 * https://leetcode-cn.com/problems/boats-to-save-people/
 * @author: King
 * @create: 2021-08-26 22:50
 */
public class Test26 {
    /**
     * 第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
     * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
     * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
     * <p>
     * 执行用时： 16 ms , 在所有 Java 提交中击败了 95.52% 的用户
     * 内存消耗： 47.4 MB , 在所有 Java 提交中击败了 24.52% 的用户
     *
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int right = people.length - 1;
        int left = 0;
        while (left <= right) {
            if (left == right) {
                ++count;
                break;
            }
            if (people[left] + people[right] > limit) {
                ++count;
                --right;        // 先载最重的, 而且最小的也无法一起载,那么就最重的单独走
            } else {
                ++count;
                --right;        // 最重的与最轻的一起走
                ++left;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Test26 test26 = new Test26();
        Helper.print(test26.numRescueBoats(Helper.getArrays(3, 2, 2, 1), 3));//3
        Helper.print(test26.numRescueBoats(Helper.getArrays(3, 5, 3, 4), 5));//4
        Helper.print(test26.numRescueBoats(Helper.getArrays(5, 1, 4, 2), 6));//2
    }
}
