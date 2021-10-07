package com.king.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 434. 字符串中的单词数
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-10-07 09:21
 */
public class Test7 {

    //统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
    //请注意，你可以假定字符串里不包括任何不可打印的字符。
    //示例:
    //
    //输入: "Hello, my name is John"
    //输出: 5
    //解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。


    //执行用时： 2 ms , 在所有 Java 提交中击败了 28.55% 的用户 内存消耗： 36.4 MB , 在所有 Java 提交中击败了 19.91% 的用户
    public int countSegments(String s) {
        if(s.equals("")) return 0;
        int k=0;
        for(int i=0;i<s.length();i++){
            if(!Character.isSpace(s.charAt(i))){
                k=i;
                break;
            }

        }
        String str = s.substring(k);
        String[] arr = str.split("\\s+");
        return arr.length;
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        MyPrint.print(test7.countSegments("Hello, my name is John"));
        MyPrint.print(test7.countSegments(""));
        MyPrint.print(test7.countSegments(", , , ,        a, eaefa"));//6
    }
}

