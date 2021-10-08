package com.king.M10;

import com.king.util.MyPrint;

import java.util.*;

/**
 * @program: leetcode
 * @description: 187. 重复的DNA序列
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-10-08 22:58
 */
public class Test8 {
    //所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
    //
    //编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
    //


    //执行用时： 16 ms , 在所有 Java 提交中击败了 80.67% 的用户 内存消耗： 46.5 MB , 在所有 Java 提交中击败了 84.51% 的用户
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len < 10) return new ArrayList<>();
        Set<String> res = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= len; ++i) {
            String sub = s.substring(i - 10, i);
            //MyPrint.print(sub);
            if (map.containsKey(sub)) {
                res.add(sub);
            } else {
                map.put(sub, null);
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Test8 test8 = new Test8();
        MyPrint.print(test8.findRepeatedDnaSequences(s));
    }
}
