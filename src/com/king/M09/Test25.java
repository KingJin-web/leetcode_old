package com.king.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 583. 两个字符串的删除操作
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 * @author: King
 * @create: 2021-09-25 13:50
 */
public class Test25 {
    //给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。

    //执行用时： 6 ms , 在所有 Java 提交中击败了 94.95% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 76.90% 的用户
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[m][n];
        return m - lcs + n - lcs;
    }

    public static void main(String[] args) {
        Test25 test25 = new Test25();
        MyPrint.print(test25.minDistance("AKing47","BAKing69"));
    }

}
