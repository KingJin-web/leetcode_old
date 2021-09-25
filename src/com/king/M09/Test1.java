package com.king.M09;

import com.king.Helper;

import java.sql.PreparedStatement;

/**
 * @program: leetcode
 * @description: 165. 比较版本号
 * //链接：https://leetcode-cn.com/problems/compare-version-numbers
 * @author: King
 * @create: 2021-09-01 21:04
 */
public class Test1 {
    //给你两个版本号 version1 和 version2 ，请你比较它们。
    //
    //版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。
    // 每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。
    // 例如，2.5.33 和 0.1 都是有效的版本号。
    //比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。
    // 也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。
    // 例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。

    //返回规则如下：
    //
    //如果 version1 > version2 返回 1，
    //如果 version1 < version2 返回 -1，
    //除此之外返回 0。

    //执行用时： 1 ms , 在所有 Java 提交中击败了 80.56% 的用户 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 47.26% 的用户
    public int compareVersion1(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int l1 = str1.length, l2 = str2.length;
        for (int i = 0; i < l1 || i < l2; ++i) {
            int x = 0, y = 0;
            if (i < l1) {
                x = Integer.parseInt(str1[i]);
            }
            if (i < l2) {
                y = Integer.parseInt(str2[i]);
            }
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    //双指针
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 87.25% 的用户
    public int compareVersion(String version1, String version2) {
        char[] chars1 = version1.toCharArray(), chars2 = version2.toCharArray();
        int l1 = chars1.length, l2 = chars2.length;
        for (int i = 0, j = 0; i < l1 || j < l2; ) {
            int x = 0;
            while (i < l1 && !(chars1[i] == '.')) {
                x = x * 10 + chars1[i] - '0';
                ++i;
            }
            ++i; // 跳过点号
            int y = 0;
            while (j < l2 && !(chars2[j] == '.')) {
                y = y * 10 + chars2[j] - '0';
                ++j;
            }
            ++j;

            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //输入：version1 = "7.5.2.4", version2 = "7.5.3"
        //输出：-1
        String version1 = "7.5.2.4", version2 = "7.5.3";
        Test1 test1 = new Test1();

        Helper.print(test1.compareVersion(version1, version2));

        version1 = "1.0.1";
        version2 = "1";
        Helper.print(test1.compareVersion(version1, version2));
    }

}

