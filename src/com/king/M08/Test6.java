package com.king.M08;

import com.king.Helper;
import com.king.ListNode;

import java.util.HashMap;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-08-06 10:19
 */
public class Test6 {

    /**
     * 剑指 Offer II 001. 整数除法
     * https://leetcode-cn.com/problems/xoh6Oh/
     * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
     */
    public static class T1 {
        public int divide(int a, int b) {
            //特殊处理 -2^31/ -1 = 2^31 溢出
            if (a == Integer.MIN_VALUE && b == -1) {
                return Integer.MAX_VALUE;
            }
            boolean k = (a > 0 && b > 0) || (a < 0 && b < 0);
            int result = 0;
            a = -Math.abs(a);
            b = -Math.abs(b);
            while (a <= b) {
                int temp = b;
                int c = 1;
                while (a - temp <= temp) {
                    temp = temp << 1;
                    c = c << 1;
                }
                a -= temp;
                result += c;
            }
            return k ? result : -result;
        }

        public static void main(String[] args) {
            T1 t1 = new T1();
            Helper.print(Math.abs(0x80000000));
            Helper.print(t1.divide(-2147483648
                    , 2));

        }
    }

    /**
     * 剑指 Offer 05. 替换空格
     * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     */
    public static class T2 {
        static T2 t2 = new T2();

        /**
         * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
         * 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 36.42% 的用户
         *
         * @param s
         * @return
         */
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(c);
                }
            }

            return String.valueOf(sb);
        }

        /**
         * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
         * 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 77.23% 的用户
         *
         * @param s
         * @return
         */
        public String replaceSpace1(String s) {

            return s.replace(" ", "%20");
        }

        public static void main(String[] args) {

            Helper.print(t2.replaceSpace("We are happy"));
            Helper.print("We are happy".replace(" ", "%20"));
        }
    }

    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
     */
    public static class T3 {
        /**
         * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
         * 内存消耗： 39 MB , 在所有 Java 提交中击败了 59.42% 的用户
         *
         * @param head
         * @return
         */
        public int[] reversePrint(ListNode head) {

            ListNode listNode = head;
            int count = 0;
            while (listNode != null) {

                ++count;
                listNode = listNode.next;
            }
            int[] arr = new int[count];
            listNode = head;
            for (int i = arr.length - 1; i >= 0; --i) {
                arr[i] = listNode.val;
                listNode = listNode.next;
            }
            return arr;
        }

        public static void main(String[] args) {
            T3 t3 = new T3();
            ListNode l = new ListNode(Helper.getArrays(1, 3, 2));
            Helper.print(t3.reversePrint(l));
            Helper.print(l);
        }
    }

}
