package com.king.M04;

/**
 * @program: leetcode
 * @description: 403. 青蛙过河
 * https://leetcode-cn.com/problems/frog-jump/
 * @author: King
 * @create: 2021-04-29 17:13
 */
public class Test20 {
    public boolean canCross1(int[] stones) {
          /*
        假设每次都跳 k + 1 步
        0   1   2   3   4   5   6   ：  i
        1   2   3   4   5   6   7   :   step
        那么第 i 个单位最远能够条 i + 1 步

        对于第 i 个石头，前面的石头 j 能否跳到该石头, 假设两石头间的距离为 diff = stones[i] - stones[j],
        需要判断 j 是否存在可以跳跃 diff 步 的能力，而这个能力是由 石头 j 前面的石头决定的
        当前面能够跳 diff 步石头 i 时，那么石头 i 可跳的步数增加 diff - 1 || diff || diff + 1

        因此，我们记录 石头 i 所有能够跳跃的步数
        dp[i][j] 表示 第 i 个石头是否可以跳 j 步

比如 当 石头 j 能够跳到 石头 i 时， diff = stones[i] - stones[j]
那么对于 石头 i 来说，它能够跳跃的步数增加了以下三个
                    dp[i][diff - 1] = true;
                    dp[i][diff] = true;
                    dp[i][diff + 1] = true;
        */
        int len = stones.length;

        //dp[i][j] 表示 第 i 个石头是否可以跳 j 步
        boolean[][] dp = new boolean[len][len + 1];

        //初始条件：第 0 个石头可以跳 1 步
        dp[0][1] = true;

        for (int i = 1; i < len; i++) {
            boolean flag = false;
            //因为 石头 i 最大只能跳 i + 1 步，因此 前面的石头 j 到达 石头 i 的距离必须 <= i
            for (int j = i - 1; j >= 0; j--) {
                int diff = stones[i] - stones[j];
                if (diff > i) {
                    break;
                }
                //对于 石头 j ，它需要跳 diff 步
                if (dp[j][diff]) {
                    dp[i][diff - 1] = true;
                    dp[i][diff] = true;
                    dp[i][diff + 1] = true;
                    flag = true;
                }
            }
            //当到达了终点 而 flag ，表示无法从前面的任意石头跳到终点，返回 false
            if (i == len - 1 && !flag) {
                return false;
            }
        }
        return true;

    }
}
