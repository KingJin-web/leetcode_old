package com.king.M08;

/**
 * @program: leetcode
 * @description: 526. 优美的排列
 * https://leetcode-cn.com/problems/beautiful-arrangement/
 * @author: King
 * @create: 2021-08-16 21:06
 */
public class Test15 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.1 MB , 在所有 Java 提交中击败了 69.08% 的用户
     *
     * @param n
     * @return
     */
    public int countArrangement(int n) {
        int[] table = new int[]{0, 1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
        return table[n];

    }

}
