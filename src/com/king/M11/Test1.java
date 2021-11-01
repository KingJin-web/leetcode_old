package com.king.M11;

import com.king.Helper;
import com.king.util.MyPrint;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 575. 分糖果
 * https://leetcode-cn.com/problems/distribute-candies/
 * @author: King
 * @create: 2021-11-01 04:09
 */
public class Test1 {

    //给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
    // 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。

    /**
     * 贪心
     * 根据题意，妹妹每种糖果至少要拿一颗1.
     * 1. 如果糖果种类数<=数组长度的一半，那么妹妹可以拿到所有种类的糖果。ans = 糖果种类数
     * 2. 如果糖果种类数>数组长度的一半，那么妹妹能拿到的所有糖果都互不相同。ans = candyType.length/2
     * 二者取小即可。
     */

    //执行用时： 36 ms , 在所有 Java 提交中击败了 42.44% 的用户 内存消耗： 40 MB , 在所有 Java 提交中击败了 93.15% 的用户
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int num : candyType) {
            set.add(num);
        }
        return Math.min(set.size(), candyType.length>>1);
     //   return set.size() <= candyType.length / 2 ? ln : ln / 2;
    }

    //输入: candies = [1,1,2,2,3,3]
    //输出: 3
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        MyPrint.print(test1.distributeCandies(Helper.getArrays(1,1,2,2,3,3)));
    }
}
