package com.king.M08;

import com.king.Helper;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 1805. 字符串中不同整数的数目
 * 链接：https://leetcode-cn.com/problems/number-of-different-integers-in-a-string
 * @author: King
 * @create: 2021-08-27 00:19
 */
public class Test27 {
//    给你一个字符串 word ，该字符串由数字和小写英文字母组成。
//
//    请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123 34 8 34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
//
//    返回对 word 完成替换后形成的 不同 整数的数目。
//
//    只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
//
//    来源：力扣（LeetCode）
//
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    //执行用时： 3 ms , 在所有 Java 提交中击败了 73.14% 的用户 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 17.15% 的用户
    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 57 || chars[i] < 48) {
                chars[i] = ' ';
            }
        }
        String[] strs = new String(chars).split(" ");
        for (String s : strs) {
            if (!s.equals("")) {
                set.add(delete(s));
            }
        }
        return set.size();
    }

    public String delete(String s){
        if (s.startsWith("0")){
            return delete(s.substring(1));
        }else {
            return s;
        }
    }
    public static void main(String[] args) {
        Test27 test27 = new Test27();
        Helper.print(test27.numDifferentIntegers("a123bc34d8ef34"));
        Helper.print(test27.numDifferentIntegers("a1b01c001"));
    }
}
