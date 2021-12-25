package com.king.M12;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 1078. Bigram 分词
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/occurrences-after-bigram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-12-26 02:22
 */
public class Test26 {
    //给出第一个词first 和第二个词second，考虑在某些文本text中可能以 "first second third" 形式出现的情况，
    // 其中second紧随first出现，third紧随second出现。
    //
    //对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。

    //示例 1：
    //
    //输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
    //输出：["girl","student"]
    //示例 2：
    //
    //输入：text = "we will we will rock you", first = "we", second = "will"
    //输出：["we","rock"]


    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.4 MB , 在所有 Java 提交中击败了 73.00% 的用户
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] strings = text.split(" ");
        for (int i = 0; i < strings.length - 2; i++) {
            if (strings[i].equals(first)) {
                if (strings[i + 1].equals(second)) {
                    list.add(strings[i + 2]);
                }
            }
        }
        return list.toArray(new String[0]);

    }

    public static void main(String[] args) {
        Test26 text = new Test26();
        MyPrint.print(text.findOcurrences("alice is a good girl she is a good student", "a", "good"));

    }
}
