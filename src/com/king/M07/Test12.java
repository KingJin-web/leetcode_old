package com.king.M07;

import com.king.Helper;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @author: King
 * @create: 2021-07-16 21:05
 */
public class Test12 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char c ;
        int i = 0;
        for (;i< s.length();++i){
            c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for (i = 0;i < s.length(); ++i){
            c = s.charAt(i);
            if (map.get(c) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Test12 t12 = new Test12();
        Helper.print(t12.firstUniqChar("loveleetcode"));
    }
}
