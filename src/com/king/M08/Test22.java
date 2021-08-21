package com.king.M08;

import com.king.Helper;

/**
 * @program: leetcode
 * @description: 443. 压缩字符串
 * https://leetcode-cn.com/problems/string-compression/
 * @author: King
 * @create: 2021-08-21 20:32
 */
public class Test22 {

    //执行用时： 1 ms , 在所有 Java 提交中击败了 98.90% 的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 29.76% 的用户
    public int compress1(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Test22 test22 = new Test22();

        Helper.print(test22.compress1(Helper.getArrays('a','b','b','b','b','b','b','b','b','b','b','b','b')));
        //输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
        //输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
        //解释：
        //由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
        //注意每个数字在数组中都有它自己的位置。
    }

}
