package com.king.M07;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 171. Excel表列序号
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * @author: King
 * @create: 2021-07-30 14:26
 */
public class Test33 {
    public static Test33 t33 = new Test33();

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 36.27% 的用户
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int a = 0;
        char[] chars = columnTitle.toCharArray();
        for (char c : chars) {
            a = a * 26 + (c - 'A' + 1);
        }
        return a;
    }

    public static void main(String[] args) {
        Helper.print(t33.titleToNumber("AB"));
    }
}
