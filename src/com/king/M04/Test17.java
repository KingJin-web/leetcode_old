package com.king.M04;

/**
 * @program: leetcode
 * @description: 633. 平方数之和
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * @author: King
 * @create: 2021-04-28 16:20
 */
public class Test17 {
    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了50.68% 的用户
     * 内存消耗：35.3 MB, 在所有 Java 提交中击败了27.97% 的用户
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        long x = 0, y = (int) Math.sqrt(c);
        long sum;
        while (x <= y) {
            sum = x * x + y * y;
            if (c == sum) {
                //System.out.println(x + "," + y);
                return true;
            }
            if (sum < c) {
                x++;
            } else {
                y--;
            }
        }

        return false;
    }

    public boolean judgeSquareSum2(int c) {
        long y = (int) Math.sqrt(c);
        System.out.println(y);
        for (int i = 0; i <= y; i++) {
            if ( i * i + y * y == c){
                System.out.println(y +","+ i);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
       // System.out.println(new Test17().judgeSquareSum(25));
        System.out.println(new Test17().judgeSquareSum2(2));
        ;
    }
}
