package com.king.M12;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 997. 找到小镇的法官
 * https://leetcode-cn.com/problems/find-the-town-judge/
 * @author: King
 * @create: 2021-12-19 22:11
 */
public class Test19 {
    //分别用两个数组存储，一个用来存储入度数，也就是相信你的人的个数，数组下标就是代表该人，1到N
    //另外一个用来存储出度数，也就是你相信的人的个数
    //入度数等于N-1，出度数为0，则这个人就是法官，否则无法确定法官。

    //执行用时： 2 ms , 在所有 Java 提交中击败了 99.21% 的用户
    //内存消耗： 45.8 MB , 在所有 Java 提交中击败了 81.98% 的用户
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int[] edge : trust) {
            int x = edge[0], y = edge[1];
            ++inDegrees[y];
            ++outDegrees[x];
        }
        for (int i = 1; i <= n; ++i) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Test19 test19 = new Test19();
//        输入：n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
//        输出：3
        int n = 4;
        int [][] trust = new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}};
        MyPrint.print(test19.findJudge(n,trust));
    }

}
