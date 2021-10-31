package com.king.M10;

import com.king.Helper;
import com.king.util.MyPrint;

import java.util.*;

/**
 * @program: leetcode
 * @description: 500. 键盘行
 *   链接：https://leetcode-cn.com/problems/keyboard-row
 * @author: King
 * @create: 2021-10-31 12:00
 */
public class Test31 {
    //        给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
    //        美式键盘 中：
//        第一行由字符 "qwertyuiop" 组成。
//        第二行由字符 "asdfghjkl" 组成。
//        第三行由字符 "zxcvbnm" 组成。\

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 54.08% 的用户
    public String[] findWords(String[] words) {
        List<String> strings = new ArrayList<>();
        for (String s:words){
            if (rowPosit(s)){
                strings.add(s);
            }
        }
        return strings.toArray(new String[]{});
    }

    public boolean rowPosit(String s){
        s = s.toLowerCase();
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        char [] chars = s.toCharArray();
        int num1 = 0, num2 = 0, num3 = 0;
        int ln = chars.length;
        for (char ch :chars){
            if(row1.indexOf(ch) != -1){
               ++num1;
            }else if (row2.indexOf(ch) != -1){
                ++num2;
            }else{
                ++num3;
            }
        }

        return num1 == ln || num2 == ln || num3 == ln;

    }
    public static void main(String[] args) {
        Test31 test31 = new Test31();
        MyPrint.print(test31.findWords(Helper.getArrays("Hello","Alaska","Dad","Peace")));
    }
}
