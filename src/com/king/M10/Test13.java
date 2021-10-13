package com.king.M10;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 412. Fizz Buzz
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-10-13 19:08
 */
public class Test13 {


    //给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
    //
    //answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
    //answer[i] == "Fizz" 如果 i 是 3 的倍数。
    //answer[i] == "Buzz" 如果 i 是 5 的倍数。
    //answer[i] == i 如果上述条件全不满足。


    //执行用时： 1 ms , 在所有 Java 提交中击败了 99.43% 的用户 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 83.99% 的用户
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        String[] chart = new String[]{"FizzBuzz", "", "", "Fizz", "", "Buzz", "Fizz", "", "", "Fizz", "Buzz", "", "Fizz", "", ""};
        for (int i = 1; i <= n; i++) {
            if (chart[i % 15].equals(""))
                result.add(Integer.toString(i));
            else
                result.add(chart[i % 15]);
        }
        return result;
    }

    //执行用时： 1 ms , 在所有 Java 提交中击败了 99.43% 的用户 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 33.12% 的用户
    public List<String> fizzBuzz1(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        MyPrint.print(test13.fizzBuzz(3));
    }

}
