package com.king.M08;

import com.king.Helper;

import java.awt.*;
import java.util.stream.IntStream;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-08-07 15:34
 */
public class Test7 {

    /**
     * 剑指 Offer 64. 求1+2+…+n
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * https://leetcode-cn.com/problems/qiu-12n-lcof/
     */
    public static class T1 {
        int[] arr = new int[]{0};

        /**
         * 执行用时： 1918 ms , 在所有 Java 提交中击败了 48.47% 的用户
         * 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 5.02% 的用户
         * @param n
         * @return
         */
        public int sumNums(int n) {
            try {
                return arr[n];
            }catch (Exception e){
                return n + sumNums(n - 1);
            }
        }

        public int sumNums2(int n) {
            return IntStream.range(1, n + 1).sum();
        }

        public static void main(String[] args) {
            T1 t1 = new T1();
            Helper.print(t1.sumNums(5));
        }
    }
}
