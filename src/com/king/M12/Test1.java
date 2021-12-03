package com.king.M12;

import com.king.util.MyPrint;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 1446. 连续字符
 * https://leetcode-cn.com/problems/consecutive-characters/
 * @author: King
 * @create: 2021-12-02 02:25
 */
public class Test1 {

    //给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
    //
    //请你返回字符串的能量。

    public static void main(String[] args) {
        //输入：s = "abbcccddddeeeeedcba"

        //输出：5
        //解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
        Test1 test1 = new Test1();
        MyPrint.print(test1.maxPower("abbcccddddeeeeedcba"));
        MyPrint.print(test1.maxPower1("abbcccddddeeeeedcba"));

    }

    //执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 14.54% 的用户
    public int maxPower(String s) {
        //  Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int n = s.length();
        int ans = 1, cnt = 1;
        for (int i = 1; i < n; ++i) {
            if (chars[i] == chars[i - 1]){
                ++cnt;
                ans = Math.max(ans,cnt);
            }else {
                cnt = 1;
            }
        }

        return ans;
    }

    public int maxPower1(String s) {
        int ans = 1, cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++cnt;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }
}
