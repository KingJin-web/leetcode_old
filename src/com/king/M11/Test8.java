package com.king.M11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 299. ²ÂÊı×ÖÓÎÏ·
 * @author: King
 * @create: 2021-11-08 22:25
 */
public class Test8 {

    public String getHint(String secretStr, String guessStr) {
        char[] secret = secretStr.toCharArray();
        char[] guess = guessStr.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int A = 0;
        for (int i = 0; i < secret.length; i++) {
            if (secret[i] == guess[i]) {
                guess[i] = 'X';
                A++;
                continue;
            }
            if (map.get(secret[i]) == null) {
                map.put(secret[i], 1);
            } else {
                map.put(secret[i], map.get(secret[i]) + 1);
            }
        }
        int B = 0;
        for (char c : guess) {
            if (c != 'X') {
                if (map.get(c) != null && map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                    B++;
                }
            }
        }
        return A + "A" + B + "B";
    }


    public String listToString(List<String> lists){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (;i < lists.size() - 1;++i){
            sb.append(lists.get(i)).append(", ");
        }
        sb.append(lists.get(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        Test8 mainActivity = new Test8();
        List<String> list = new ArrayList<>();
        list.add("a");list.add("a");list.add("a");list.add("a");
        System.out.println(mainActivity.listToString(list));
    }
}
