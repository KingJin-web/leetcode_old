package com.king.beforM04.D0223;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-02-23 15:25
 */
public class Test1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5}, grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;

        int a = solution.maxSatisfied(customers,grumpy,X);
        System.out.println(a);
    }
}

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int sum = 0, len = customers.length;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0){
                sum += customers[i];
                customers[i] = 0;
            }
        }
        int num = customers[0];
        int maxval = customers[0];
        for (int i = 1; i < len; i++){
            if (i < X) num = num + customers[i];
            else num = num + customers[i] - customers[i - X];
            maxval = Math.max(maxval, num);
        }

        return (sum + maxval);
    }
}