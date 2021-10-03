package com.king.contest.biweekly_contest_62;

import com.king.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 5872. 连接后等于目标字符串的字符串对
 * @author: King
 * @create: 2021-10-02 22:44
 */
public class Test2 {
    //给你一个 数字 字符串数组 nums 和一个 数字 字符串 target ，
    //请你返回 nums[i] + nums[j] （两个字符串连接）结果等于 target 的下标 (i, j) （需满足 i != j）的数目。

    //执行用时： 25 ms , 在所有 Java 提交中击败了 73.04% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 51.81% 的用户
    public int numOfPairs(String[] nums, String target) {
        int ln = nums.length;
        int result = 0;
        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < ln ; j++) {
                if (i != j && (nums[i] + nums[j]).equals(target)){
                    ++result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        MyPrint.print(test2.numOfPairs(Helper.getArrays("777","7","77","77"),"7777"));
        MyPrint.print(test2.numOfPairs(Helper.getArrays("123","4","12","34"),"1234"));
    }

    //输入：nums = ["777","7","77","77"], target = "7777"
    //输出：4
    //解释：符合要求的下标对包括：
}
