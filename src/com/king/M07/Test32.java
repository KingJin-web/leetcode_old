package com.king.M07;

import com.king.Helper;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author: King
 * @create: 2021-07-28 14:41
 */
public class Test32 {
    private static Test32 t32 = new Test32();


    public static void main(String[] args) {

        Helper.print(t32.isValid("{}{}{{{}}}(((())))"));
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.28% 的用户
     * 内存消耗： 36.6 MB , 在所有 Java 提交中击败了 52.85% 的用户
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (isSym(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;

    }

    private boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }


    public static class StackDemo {
        public static void test(int x) {
            Stack<Integer> s1 = new Stack<Integer>();
            Stack<Integer> s2 = new Stack<Integer>();
            s1.push(x);
            s2.push(x);
            int p1 = s1.peek();
            int p2 = s2.peek();
            System.out.println(p1 == p2);
            System.out.println(s1.peek() == s2.peek());
            Helper.printAddresses("p1", p1);
            Helper.printAddresses("p2", p2);

        }

        static void showpush(Stack<Integer> st, int a) {
            st.push(new Integer(a));
            System.out.println("push(" + a + ")");
            System.out.println("stack: " + st);
        }

        static void showpop(Stack<Integer> st) {
            System.out.print("pop -> ");
            Integer a = (Integer) st.pop();
            System.out.println(a);
            System.out.println("stack: " + st);
        }

        public static void main(String args[]) {
            Stack<Integer> st = new Stack<Integer>();
            System.out.println("stack: " + st);
            showpush(st, 42);
            showpush(st, 66);
            showpush(st, 99);
            showpop(st);
            showpop(st);
            showpop(st);
            try {
                showpop(st);
            } catch (EmptyStackException e) {
                System.out.println("empty stack");
            }
        }
    }
}
