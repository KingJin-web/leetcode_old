package com.king.M12;

/**
 * @program: leetcode
 * @description: 372. ³¬¼¶´Î·½
 * https://leetcode-cn.com/problems/super-pow/
 * @author: King
 * @create: 2021-12-05 22:51
 */
public class Test5 {
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % MOD);
            a = pow(a, 10);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }

}
