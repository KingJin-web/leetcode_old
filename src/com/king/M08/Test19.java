package com.king.M08;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 345. 反转字符串中的元音字母
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * @author: King
 * @create: 2021-08-19 16:01
 */
public class Test19 {
    private static Test19 test19 = new Test19();

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 83.83% 的用户
     * 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 77.08% 的用户
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        String tool = "aoeiuAOEIU";
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (tool.indexOf(chars[left]) < 0 && left < right) {
                ++left;
            }
            while (tool.indexOf(chars[right]) < 0 && left < right) {
                --right;
            }
            if (left < right) {
                swap(chars, left, right);
                ++left;
                --right;
            }

        }
        return new String(chars);
    }


    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void swap(char c1, char c2) {
        char c = c1;
        c1 = c2;
        c2 = c1;
    }

    public static void main(String[] args) {
        //Helper.print(test19.reverseVowels("leetcode"));
        Helper.print(test19.reverseVowels(".,"));
    }
}
