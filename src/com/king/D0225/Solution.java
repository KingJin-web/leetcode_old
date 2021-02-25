package com.king.D0225;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-02-25 20:51
 */
public class Solution {
    /**
     * 将整数转换为两个无零整数的和
     * https://leetcode-cn.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
     *
     * @param n
     * @return
     */
//    public int[] getNoZeroIntegers(int n) {
//
//        if (n <= 10) {
//            return new int[]{1, n - 1};
//        }
//
//        for (int i = 1; i <= n; i++) {
//            String a = Integer.toString(n - i);
//            String b = Integer.toString(i);
//            if (a.indexOf('0') < 1 && b.indexOf('0') < 1) {
//                return new int[]{i,n - i};
//            }
//        }
//        return null;
//    }

    public int[] getNoZeroIntegers(int n) {
        if (n <= 10) {
            return new int[]{1, n - 1};
        }
        for(int i = 1; i < n; i++){
            if(changeZero(i) && changeZero(n - i)){
                return new int[] {i, n - i};
            }
        }
        return null;
    }
    public boolean changeZero(int n){
        while(n > 0){

            if(n % 10 == 0){
                return false;//出现数字0
            }
            n /= 10;
        }
        return true;
    }
}



