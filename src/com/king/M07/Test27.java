package com.king.M07;

import com.king.Helper;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author: King
 * @create: 2021-07-24 10:09
 */
public class Test27 {
    private static Test27 t27 = new Test27();
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 83.79% 的用户
     * 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 77.33% 的用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                start = Math.max(map.get(chars[i]) + 1, start);
            }
            max = Math.max(max, i - start + 1);
            map.put(chars[i], i);
        }

        Helper.print(map);
        return max;
    }


    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); ++end) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        Helper.print(map);
        return max;
    }

    public static void main(String[] args) {
        //  Helper.print(t27.lengthOfLongestSubstring("asdfghwqaa"));
        Helper.print(t27.lengthOfLongestSubstring("dvdf"));
        Helper.print(t27.lengthOfLongestSubstring1("dvdf"));
    }
}
