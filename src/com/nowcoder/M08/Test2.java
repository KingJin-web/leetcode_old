package com.nowcoder.M08;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description: [编程题]添加字符
 * https://www.nowcoder.com/questionTerminal/b2b816e20e8343b49abbaf493886ce26
 * @author: King
 * @create: 2021-08-10 23:00
 */
public class Test2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String a = in.nextLine();
            String b = in.nextLine();

            int max = 0;

            char[] chars1 = a.toCharArray();
            char[] chars2 = b.toCharArray();
            for (int i = 0; i <= b.length() - a.length(); ++i) {
                int count = 0;
                for (int j = 0; j < a.length(); ++j) {
                    if (chars1[j] == chars2[j + i])
                        ++count;

                }
                max = Math.max(max, count);

            }
            System.out.println(a.length() - max);
        }
    }

}
/**
 * 时间限制：C/C++ 1秒，其他语言2秒
 * <p>
 * 空间限制：C/C++ 32M，其他语言64M
 * <p>
 * 牛牛手里有一个字符串A，羊羊的手里有一个字符串B，B的长度大于等于A，所以牛牛想把A串变得和B串一样长，这样羊羊就愿意和牛牛一起玩了。
 * 而且A的长度增加到和B串一样长的时候，对应的每一位相等的越多，羊羊就越喜欢。比如"abc"和"abd"对应相等的位数为2，为前两位。
 * 牛牛可以在A的开头或者结尾添加任意字符，使得长度和B一样。现在问牛牛对A串添加完字符之后，不相等的位数最少有多少位？
 * <p>
 * 输入描述:
 * 第一行为字符串A，第二行为字符串B，A的长度小于等于B的长度，B的长度小于等于50.字符均为小写字母。
 * <p>
 * 输出描述:
 * 输出一个整数表示A串添加完字符之后，不相等的位数最少有多少位？
 * <p>
 * 输入例子1:
 * abe
 * cabc
 * <p>
 * 输出例子1:
 * 1
 **/
