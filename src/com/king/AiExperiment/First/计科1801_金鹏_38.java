package com.king.AiExperiment.First;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-04-05 17:18
 */
public class 计科1801_金鹏_38 {
    public static void main(String[] args) {
        int nDisks = 5;
        doTowers(nDisks, 'A', 'B', 'C');
    }

    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("盘子 1 从 " + from + " 到 " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("盘子 " + topN + " 从 " + from + " 到 " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }
}
