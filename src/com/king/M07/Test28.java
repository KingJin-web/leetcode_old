package com.king.M07;

import com.king.Helper;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 1047. 删除字符串中的所有相邻重复项
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * @author: King
 * @create: 2021-07-25 21:30
 */
public class Test28 {
    static Test28 t28 = new Test28();

    /**
     * 再次超时
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        for (int i = 1; i < S.length(); ++i) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                S = S.substring(0, i - 1) + S.substring(i + 1);
                i = 0;
            }
        }
        return S;
    }

    public static void main(String[] args) {
        Helper.print(t28.removeDuplicates("abbaca"));
        Helper.print(t28.removeDuplicates1("abbaca"));
    }

    /**
     * 可惜超时了
     *
     * @param S
     * @return
     */
    public String removeDuplicates1(String S) {
        int now = S.length();
        int next = 1;
        while (now != next) {
            now = S.length();
            S = S.replace("aa", "").replace("bb", "").
                    replace("cc", "").replace("dd", "").
                    replace("ee", "").replace("ff", "").
                    replace("gg", "").replace("hh", "").
                    replace("ii", "").replace("jj", "").
                    replace("kk", "").replace("ll", "").
                    replace("mm", "").replace("nn", "").
                    replace("oo", "").replace("pp", "").
                    replace("qq", "").replace("rr", "").
                    replace("ss", "").replace("tt", "").
                    replace("uu", "").replace("vv", "").
                    replace("ww", "").replace("xx", "").
                    replace("yy", "").replace("zz", "");
            next = S.length();

        }


        return S;
    }
}
