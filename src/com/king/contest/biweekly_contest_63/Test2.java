package com.king.contest.biweekly_contest_63;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-10-16 22:54
 */
public class Test2 {
    public boolean winnerOfGame1(String colors) {
        char[] cs = colors.toCharArray();
        List<Character> chars = new ArrayList<>();
        for (char c : cs) {
            chars.add(c);
        }

        while (true) {
            boolean result = true;
            for (int i = 0; i < chars.size() - 2; i++) {
                if (chars.get(i) == 'A' && chars.get(i + 1) == 'A' && chars.get(i + 2) == 'A') {
                    chars.remove(i + 1);
                    result = false;
                    break;
                }
            }
            if (result){
                return false;
            }

            result = true;
            for (int i = 0; i < chars.size() - 2; i++) {
                if (chars.get(i) == 'B' && chars.get(i + 1) == 'B' && chars.get(i + 2) == 'B') {
                    chars.remove(i + 1);
                    result = false;
                    break;
                }
            }
            if (result){
                return true;
            }

        }
    }
    public boolean winnerOfGame2(String colors) {

        StringBuilder sb = new StringBuilder(colors);
        while (true){
            int index = -1;
            if ((index = sb.indexOf("AAA")) >= 0){
                sb.deleteCharAt(index +  1);
            }else {
                return false;
            }
            index = -1;
            if ((index = sb.indexOf("BBB")) >= 0){
                sb.deleteCharAt(index +  1);
            }else {
                return true;
            }
        }

    }

    //执行用时： 9 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
    public boolean winnerOfGame(String colors) {

        char [] s = colors.toCharArray();
        int cnt = 0;
        for(int i = 1; i + 1 < colors.length(); ++i) {
            if(s[i] == s[i-1] && s[i] == s[i+1]) {
                if(s[i] == 'A') ++cnt;
                else --cnt;
            }
        }
        return cnt > 0;
    }

    public static void main(String[] args) {
        String s = "ABBBBBBBAAA";
        Test2 test2 = new Test2();
        String colors = "AAABABB";
        MyPrint.print(test2.winnerOfGame(s));
        MyPrint.print(test2.winnerOfGame(colors));
    }
}
