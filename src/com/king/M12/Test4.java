package com.king.M12;

import com.king.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 383. 赎金信
 * @author: King
 * @create: 2021-12-04 23:22
 */
public class Test4 {
    //执行用时： 1 ms , 在所有 Java 提交中击败了 99.85% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 96.38% 的用户
    public boolean canConstruct(String ransomNote, String magazine) {
        // 先统计magazine中的词频
        int[] arr = new int[26];
        char[] chars = magazine.toCharArray();
        for (char c : chars) {
            arr[c - 'a']++;
        }

        // 再遍历ransomNote中的字符，从词频表中减去
        chars = ransomNote.toCharArray();
        for (char c : chars) {
            if (arr[c - 'a']-- <= 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        // 先统计magazine中的词频
        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }

        // 再遍历ransomNote中的字符，从词频表中减去
        for (int i = 0; i < ransomNote.length(); i++) {
            if (arr[ransomNote.charAt(i) - 'a']-- <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();

        //  MyPrint.main(Helper.getArrays("123","123"));
        MyPrint.print(test4.getClass());
    }

}
