package com.king.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 600. 不含连续1的非负整数
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-09-11 00:04
 */
public class Test10 {
    //给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含?连续的1?的个数。

    //示例 1:
    //
    //输入: 5
    //输出: 5
    //解释:
    //下面是带有相应二进制表示的非负整数<= 5：
    //0 : 0
    //1 : 1
    //2 : 10
    //3 : 11
    //4 : 100
    //5 : 101
    //其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
    //说明: 1 <= n <= 109

    //执行用时： 1 ms , 在所有 Java 提交中击败了 99.26% 的用户 内存消耗： 35.5 MB , 在所有 Java 提交中击败了 44.85% 的用户
    public int findIntegers(int num) {
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int res = 0;
        if ((num & num >> 1) == 0)
            res++;
        int[] binary = new int[32];
        for (int i = 0; i < 32; i++) {
            binary[i] = num % 2;
            num = num / 2;
        }
        for (int i = 31; i >= 0; i--) {
            if (binary[i] == 1) {
                res += dp[i];
                if (i < 31 && binary[i + 1] == 1)
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test10 test10 = new Test10();
        MyPrint.print(test10.findIntegers(5));
    }
}
