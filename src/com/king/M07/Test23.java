package com.king.M07;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 面试题 01.01. 判定字符是否唯一
 * https://leetcode-cn.com/problems/is-unique-lcci/
 * @author: King
 * @create: 2021-07-22 20:57
 */
public class Test23 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了29.45%的用户
     *
     * @param astr
     * @return
     */
    public boolean isUnique1(String astr) {
        char[] chars = astr.toCharArray();
        int[] arr = new int[26];
        for (char c : chars) {
            System.out.println(c + " " + (c - 'a'));
            if (++arr[c - 'a'] >= 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36 MB, 在所有 Java 提交中击败了69.24%的用户
     *
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        if (astr.length() > 26) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < astr.length(); ++i) {
            if (++arr[astr.charAt(i) - 'a'] >= 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test23 t22 = new Test23();
        Helper.print(t22.isUnique("kzwunahkiz"));
    }
}
