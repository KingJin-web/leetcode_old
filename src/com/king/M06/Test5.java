package com.king.M06;

/**
 * @program: leetcode
 * @description: 852. 山脉数组的峰顶索引
 * @author: King
 * @create: 2021-06-15 23:37
 */
public class Test5 {

    public int peakIndexInMountainArray(int[] arr) {
        int a = 0;
        for (int i = 1;i < arr.length - 1;i++){
            if (arr[i-1] < arr[i]){
                a = i;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        int[] arr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        System.out.println(new Test5().peakIndexInMountainArray(arr));
    }
}
