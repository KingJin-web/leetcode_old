package com.king.contest.weekly_contest_262;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 至少在两个数组中出现的值
 * @author: King
 * @create: 2021-10-10 11:06
 */
public class Test1 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> list = new HashSet<>();
        Set<Integer> l;
        for (int num : nums1){
            set.add(num);
        }
        l = new HashSet<>();
        for (int num: nums2){
            l.add(num);
        }
        for (int num: l){
            if (!set.add(num)){
                list.add(num);
            }
        }
        l = new HashSet<>();
        for (int num: nums3){
            l.add(num);
        }
        for (int num: l){
            if (!set.add(num)){
                list.add(num);
            }
        }
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] num1 = LeetcodeUtil.stringToIntegerArray("[1,1,3,2]");
        int [] num2 = LeetcodeUtil.stringToIntegerArray("[2,3,3]");
        int [] num3 = LeetcodeUtil.stringToIntegerArray("[3]");
        MyPrint.printf(test1.twoOutOfThree(num1,num2,num3));
    }
}
