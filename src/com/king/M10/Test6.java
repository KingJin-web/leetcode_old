package com.king.M10;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: leetcode
 * @description: 414. 第三大的数
 * https://leetcode-cn.com/problems/third-maximum-number/
 * @author: King
 * @create: 2021-10-06 22:51
 */
public class Test6 {

    //执行用时： 6 ms , 在所有 Java 提交中击败了 25.26% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 15.51% 的用户
    public int thirdMax(int[] nums) {
        Set<Integer> s = new TreeSet<>();
        for (int num : nums) {
            s.add(num);
        }
        Integer[] o = s.toArray(new Integer[0]);
        if (s.size() < 3) {
            return o[o.length - 1];
        }
        return o[o.length - 3];
    }


    public static void main(String[] args) {
        Test6 test6 = new Test6();
        MyPrint.print(test6.thirdMax(LeetcodeUtil.stringToIntegerArray("[2, 2, 3, 1]")));
        MyPrint.print(test6.thirdMax(LeetcodeUtil.stringToIntegerArray("[1,2]")));
    }
}
