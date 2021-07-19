package com.king.M07;

import com.king.Helper;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 383. 赎金信
 * https://leetcode-cn.com/problems/ransom-note/
 * @author: King
 * @create: 2021-07-19 20:33
 */
public class Test18 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了90.11%的用户
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] Rs = new int[26];
        int[] Ms = new int[26];
        char[] charArrayRN = ransomNote.toCharArray();
        char[] charArrayM = magazine.toCharArray();
        // 统计救赎信的各个字母出现次数
        for (char c : charArrayRN) {
            Rs[c - 'a']++;
        }
        // 统计杂志的各个字母出现次数
        for (char c : charArrayM) {
            Ms[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (Rs[i] > Ms[i]) {
                return false;
            }
        }
//        Helper.print(Rs, Ms);
//        Helper.print(charArrayM, charArrayRN);
        System.gc();
        return true;
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了59.35%的用户
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了99.97%的用户
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] Rs = new int[26];
        int[] Ms = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            Rs[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            Ms[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (Rs[i] > Ms[i]) {
                return false;
            }
        }
//        Helper.print(Rs, Ms);
//        Helper.print(charArrayM, charArrayRN);
        return true;
    }

    public static void main(String[] args) {
        Test18 t18 = new Test18();
        Helper.print(t18.canConstruct("aaab", "baaa"));
    }
}
