package com.king.M07;

import com.king.Helper;

import java.util.*;

/**
 * @program: leetcode
 * @description: 面试题 10.02. 变位词组
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 * @author: King
 * @create: 2021-07-18 15:42
 */
public class Test15 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Test15 t15 = new Test15();
        Helper.print(t15.groupAnagrams(Helper.getArrays("eat", "tea", "tan", "ate", "nat", "bat")));
    }
}
