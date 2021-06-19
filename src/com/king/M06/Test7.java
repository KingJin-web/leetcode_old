package com.king.M06;

/**
 * @program: leetcode
 * @description:     }         ans = Math.max(ans, builder.length());         int size = arr.size();         for (int i = start; i < size; i++) {             String s = arr.get(i);             builder.append(s);             dfs(arr, i + 1, builder);             builder.delete(builder.length() - s.length(), builder.length());         }     }      private boolean match(StringBuilder builder) {         String s = builder.toString();         int[] counter = new int[26];         for (int i = 0; i < s.length(); i++) {             char c = s.charAt(i);             counter[c - 97]++;             if (counter[c - 97] > 1) {                 return false;             }         }         return true;     }
 * @author: King
 * @create: 2021-06-19 23:30
 */
public class Test7 {
}
