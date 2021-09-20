package com.king.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 650. 只有两个键的键盘
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2-keys-keyboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-09-19 23:30
 */
public class Test19 {

    //最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
    //
    //Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
    //Paste（粘贴）：粘贴 上一次 复制的字符。
    //给你一个数字n ，你需要使用最少的操作次数，在记事本上输出 恰好n个 'A' 。返回能够打印出n个 'A' 的最少操作次数。

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.5 MB , 在所有 Java 提交中击败了 16.35% 的用户
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test19 test19 = new Test19();

        //输入：3
        //输出：3
        //解释：
        //最初, 只有一个字符 'A'。
        //第 1 步, 使用 Copy All 操作。
        //第 2 步, 使用 Paste 操作来获得 'AA'。
        //第 3 步, 使用 Paste 操作来获得 'AAA'。
        MyPrint.print(test19.minSteps(3));
    }

}
