package com.king.M12;

/**
 * @program: leetcode
 * @description: 709. 转换成小写字母
 * https://leetcode-cn.com/problems/to-lower-case/
 * @author: King
 * @create: 2021-12-12 23:39
 */
public class Test12 {
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 87.92% 的用户
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            sb.append(Character.toLowerCase(ch));
        }

        return sb.toString();

    }

    public static void main(String[] args) {

    }
}
