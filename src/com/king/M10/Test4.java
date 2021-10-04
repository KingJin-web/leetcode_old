package com.king.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 482. 密钥格式化
 * https://leetcode-cn.com/problems/license-key-formatting/
 * @author: King
 * @create: 2021-10-05 00:02
 */
public class Test4 {
    //有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
    //
    //给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，
    // 但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
    //
    //给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。

    //执行用时： 51 ms , 在所有 Java 提交中击败了 15.24% 的用户 内存消耗： 39 MB , 在所有 Java 提交中击败了 23.10% 的用户
    public String licenseKeyFormatting1(String s, int k) {
        StringBuilder sb = new StringBuilder(s.replaceAll("-", "").toUpperCase());
        for (int i = sb.length() - k; i > 0; i -= k) {
            sb.insert(i, '-');
        }
        return sb.toString();
    }

    //执行用时： 9 ms , 在所有 Java 提交中击败了 85.93% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 66.47% 的用户
    public String licenseKeyFormatting(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int ln = chars.length;
        int c = 0;
        for (int i = ln - 1; i >= 0; --i) {
            if (chars[i] != '-') {
                ++c;
                sb.append(Character.toUpperCase(s.charAt(i)));
                if (c % k == 0) {
                    sb.append("-");
                }

            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        MyPrint.print(test4.licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}
