package com.king.M09;

import com.king.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 1961. 检查字符串是否为数组前缀
 * @author: King
 * @create: 2021-09-09 09:43
 */
public class Test7 {
    //给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。字符串 s 要成为 words 的 前缀字符串 ，
    // 需要满足：s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，且 k 不超过 words.length 。
    // 如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
    // 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/check-if-string-is-a-prefix-of-array 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //执行用时： 1 ms , 在所有 Java 提交中击败了 97.81% 的用户 
    //内存消耗： 38.6 MB , 在所有 Java 提交中击败了 7.33% 的用户
    public boolean isPrefixString1(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String world : words) {
            sb.append(world);
            if (s.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    //执行用时： 2 ms , 在所有 Java 提交中击败了 7.68% 的用户 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 99.65% 的用户
    public boolean isPrefixString(String s, String[] words) {
        String sb = "";
        for (String world : words) {
            sb+=world;
            if (s.equals(sb)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        输入：s = "iloveleetcode", words = ["i","love","leetcode","apples"]
//        输出：true
        Test7 test7 = new Test7();
        String s = "iloveleetcode";
        MyPrint.print(test7.isPrefixString(s, Helper.getArrays("i", "love", "leetcode", "apples")));
        MyPrint.print(test7.isPrefixString1(s, Helper.getArrays("i", "love", "leetcode", "apples")));
    }
}
