package com.king.M09;

import com.king.util.MyPrint;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 371. 两整数之和
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 * 看到两数之和，我啪一下子就进来了啊，很快啊，定睛一看不让用加减号，我啪一下子就躺下了啊
 * @author: King
 * @create: 2021-09-26 22:52
 */
public class Test26 {

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 17.26% 的用户
    public int getSum1(int a, int b) {
        return a + b;
    }

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35 MB , 在所有 Java 提交中击败了 84.83% 的用户
    public int getSum(int a,int b){
        int [] arr = {a,b};
        return Arrays.stream(arr).sum();
    }

    public int getSum2(int a, int b) {
        return BigInteger.valueOf(a).add(BigInteger.valueOf(b)).intValue();
    }

    public static void main(String[] args) {
        Test26 test26 = new Test26();
        MyPrint.print(test26.getSum(1,3));
    }
}
