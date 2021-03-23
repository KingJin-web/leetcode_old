package com.king.D0322;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-03-23 20:59
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.reverse(1234602100));
    }

    public int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }

    public int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
}
