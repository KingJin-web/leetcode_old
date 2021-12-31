package com.king.M12;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 507. 完美数
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-12-30 23:08
 */
public class Test31 {
    //对于一个?正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
    //
    //给定一个?整数?n，?如果是完美数，返回 true，否则返回 false
    //
    //?
    //

    //输入：num = 28
    //输出：true
    //解释：28 = 1 + 2 + 4 + 7 + 14
    //1, 2, 4, 7, 和 14 是 28 的所有正因子。

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35 MB , 在所有 Java 提交中击败了 83.18% 的用户
    public boolean checkPerfectNumber1(int num) {
        switch (num) {
            case 6:
            case 28:
            case 496:
            case 8128:
            case 33550336:
                return true;
        }
        return false;
    }

    //执行用时： 2468 ms , 在所有 Java 提交中击败了 5.11% 的用户 内存消耗： 35.2 MB , 在所有 Java 提交中击败了 51.02% 的用户
    private boolean checkPerfectNumber(int num) {
        return factor(num) == num;
    }

    public int factor(int k) {
        int i, s = 0;
        for (i = 1; i < k; i++) {
            if (k % i == 0) {
                s += i;
            }
        }
        return s;
    }


    public static void main(String[] args) {
        Test31 test = new Test31();
        MyPrint.print(test.checkPerfectNumber1(28));
        MyPrint.print(test.checkPerfectNumber(28));
        MyPrint.print(test.factor(28));
    }


}
