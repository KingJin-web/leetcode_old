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
    public int countArrangement1(int n) {
        int[] table = new int[]{0, 1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
        return table[n];

    }

    int count = 0;

    /**
     * 执行用时： 55 ms , 在所有 Java 提交中击败了 71.71% 的用户 内存消耗： 35.1 MB , 在所有 Java 提交中击败了 73.19% 的用户
     * @param N
     * @return
     */
    public int countArrangement(int N) {
        int[] visited = new int[N + 1];
        countArrangement(1, N, visited);
        return count;
    }

    public void countArrangement(int step, int N, int[] visited) {
        if (step == N + 1) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            //用过的不能再次使用，避免重复
            if (visited[i] == 0) {
                visited[i] = 1;
                //限制条件进行，剪枝
                if (i % step == 0 || step % i == 0) {
                    countArrangement(step + 1, N, visited);
                }
                visited[i] = 0;
            }
        }

    }

}
