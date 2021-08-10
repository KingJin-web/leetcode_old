package com.nowcoder.M08;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-08-10 23:52
 */
public class Test3 {
    a aa = new a();

    public static void main(String[] args) {
    }
    public static class a{
        public static void main(String[] args) {
            class b{
                b() {
                    System.out.println("a.b");
                }
            }
            b bb = new b();

            System.out.println("a");
        }
    }

}
