package com.king.M09;

import com.king.Helper;
import com.king.util.MyPrint;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-24 11:25
 */
public class Test24 {

    public String replace1(String s) {
        return s.replace(" ", "%20");
    }

    public String replace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }


    //在一个二维数组中,每一行都按照从左到右递增的顺序排序,每- -列都按照从 上到下递增的顺序排序。请完成一个
    //函数,输入这样的一个二维数组和一个整数, 判断数组中是否含有该整数。
    //剑指 Offer 04. 二维数组中的查找
    //https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 44 MB , 在所有 Java 提交中击败了 82.94% 的用户
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Test24 test24 = new Test24();
        MyPrint.print(test24.replace("Hello  World "));
        int[][] arrs = new int[][]{
                Helper.getArrays(1, 2, 3),
                Helper.getArrays(4, 5, 6),
                Helper.getArrays(7, 8, 9)
        };
        int[][] nums = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        MyPrint.print(test24.findNumberIn2DArray(nums,9));
        MyPrint.print(test24.findNumberIn2DArray(arrs, 8));
        MyPrint.print(arrs);
        MyPrint.print(Helper.getArrays(1, 2, 3, 7));
    }

    public static class T2 {
        public static void main(String[] args) {
//            int a = 0,c = 0;
//            do {
//                --c;
//                a=a-1;
//            }while (a > 0);

            int i = 1;
            int j;
            j = i++;
            MyPrint.print(i + " " + j);
        }
    }


    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * <p>
         * 出现次数最多的词组
         *
         * @param content string字符串 英文文本
         * @return string字符串ArrayList<ArrayList <>>
         */
        public ArrayList<ArrayList<String>> frequentWords(String content) {
            // write code here

            String[] ss = content.split("[!.?,]");
            Map<String, Integer> map = new HashMap<>();
            Pattern p = Pattern.compile("\\b[a-zA-Z]+\\b");
            Matcher m = p.matcher(content);
            while (m.find()) {
                String a = m.group();
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            MyPrint.print(ss);
            return null;
        }

        public static void main(String[] args) {
            String s = "hello world.";
            Solution solution = new Solution();
            MyPrint.print(solution.frequentWords("how are you. fine, thank you."));
            MyPrint.print(solution.factorization(38));

        }

        public ArrayList<ArrayList<Integer>> factorization(int n) {
            Map<Integer, Integer> map = new HashMap<>();
            int k = 2;
            while (k <= n) {    //进行循环判断
                if (k == n) {
                    map.put(k, map.getOrDefault(k, 0) + 1);
                    break;
                } else if (n % k == 0) {
                    map.put(k, map.getOrDefault(k, 0) + 1);
                    n = n / k;
                } else ++k;
            }
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (Map.Entry<Integer, Integer> next : map.entrySet()) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(next.getKey());
                list.add(next.getValue());
                result.add(list);
            }

            return result;
        }


    }
}
