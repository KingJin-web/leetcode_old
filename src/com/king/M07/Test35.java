package com.king.M07;

import com.king.Helper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-07-31 09:38
 */
public class Test35 {
    static Test35 t35 = new Test35();
    static T1 t1 = new T1();

    /**
     * @program: leetcode
     * @description: 面试题 01.08. 零矩阵
     * https://leetcode-cn.com/problems/zero-matrix-lcci/
     * @author: King
     * @create: 2021-07-31 09:38
     */
    public static class T1 {
        /**
         * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
         * 内存消耗： 40 MB , 在所有 Java 提交中击败了 41.32% 的用户
         *
         * @param matrix
         */
        public void setZeroes(int[][] matrix) {
            int lenx = matrix.length, leny = matrix[0].length;
            boolean[] row = new boolean[lenx], col = new boolean[leny];
            for (int i = 0; i < lenx; ++i) {
                for (int j = 0; j < leny; ++j) {
                    if (matrix[i][j] == 0) {
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }

            for (int i = 0; i < lenx; ++i) {
                for (int j = 0; j < leny; ++j) {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        public static void main(String[] args) {

            int[][] nums = new int[][]{
                    {1, 1, 1},
                    {1, 0, 1},
                    {1, 1, 1}
            };
            Helper.print(nums);
            t1.setZeroes(nums);
            Helper.print();
            Helper.print(nums);

        }
    }

    static T2 t2 = new T2();

    /**
     * @program: leetcode
     * @description: 720. 词典中最长的单词
     * https://leetcode-cn.com/problems/longest-word-in-dictionary/
     * @author: King
     * @create: 2021-07-31 09:38
     */
    public static class T2 {
        public String longestWord(String[] words) {
            //对数组排序，再利用Set对字母存储，小的单词一定包含在后面大的单词里面。后面只需要取前缀相同的
            //对字母排序后，第一个单词一定是共有的，后面只需在此基础上添加
            Arrays.sort(words);

            Set<String> set = new HashSet<>();
            String res = "";
            for (String s : words) {
                //如果单词只有一个字母，那一定是共有的
                if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                    res = s.length() > res.length() ? s : res;
                    set.add(s);
                }
            }
            return res;
        }

        public static void main(String[] args) {
            Helper.printf(t2.longestWord(
                    Helper.getArrays("a", "banana", "app", "appl", "ap", "apply", "apple"))
            );
        }
    }
}
