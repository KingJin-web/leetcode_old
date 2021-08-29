package com.king.M08;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 1588. 所有奇数长度子数组的和
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 * @author: King
 * @create: 2021-08-29 19:29
 */
public class Test29 {
    //考虑每个元素i在排列组合种出现的次数×上arr[i],累加结果即可
    //所以遍历每个元素看其出现次数，具体的，要想使得下标为i的元素出现
    //在奇数长度的子数组的次数，在包含arr[i]的前提下，左侧若有偶数个元素，
    //右侧必须为偶数个元素，左侧如果有奇数个元素右侧也必须有奇数个元素
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 45.75% 的用户
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            //下标为i时，arr[i]左侧一共有i个数，可以在其前面选择0、1、2...i个数
            //共有i+1种可能，i的右侧有arr.length - i - 1个元素
            //所以有arr.length - i种可能
            int left = i + 1, right = arr.length - i;
            //对左侧而言，选择偶数长度的子数组情况为left/2
            //奇数为(left + 1)/2，右侧亦然
            int leftOdd = (left + 1) / 2, leftEven = left / 2;
            int rightOdd = (right + 1) / 2, rightEven = right / 2;

            //对每个元素出现在奇数个子数组的次数累加即可
            res += (leftOdd * rightOdd + leftEven * rightEven) * arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Test29 test29 = new Test29();
//        输入：arr = [1,4,2,5,3]
//        输出：58
//        解释：所有奇数长度子数组和它们的和为：
//                [1] = 1
//                [4] = 4
//                [2] = 2
//                [5] = 5
//                [3] = 3
//                [1,4,2] = 7
//                [4,2,5] = 11
//                [2,5,3] = 10
//                [1,4,2,5,3] = 15
//        我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
        int a = test29.sumOddLengthSubarrays(Helper.getArrays(1, 4, 2, 5, 3));
        Helper.print(a);
    }
}
