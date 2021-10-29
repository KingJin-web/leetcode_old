package com.king.other;

import com.king.Helper;
import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-10-29 16:18
 */
public class Test1 {
    //斐波拉契定义：F(0)=0，F(1)=1, F( n )=F(n - 1)+F(n - 2)（n ≥ 2，n∈ N*）
    //请用代码实现：判断一个整数数组，不删除或者删除一次首尾数字，该数组是否为菲波拉契数列

    public boolean isFib(int[] nums) {
        int len = nums.length;
        if (nums[0] != 0) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (i + 1 < len && i + 2 < len) {
                if (nums[i + 2] != nums[i] + nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] fib(int n) {
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        MyPrint.print(arr);
        return arr;
    }

//    public static void main(String[] args) {
//        Test1 test1 = new Test1();
//        MyPrint.print(test1.isFib(test1.fib(10)));
//        MyPrint.print(test1.isFib(Helper.getArrays(1,2,3,4)));
//    }

    public static void main(String[] args) {
    }
}
