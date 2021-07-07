package com.nowcoder.M07;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-07-06 14:57
 */
class Test {
    public static Test t1 = new Test();

    {
        System.out.println("blockA");
    }

    static {
        System.out.println("blockB");
    }

    public static void main(String[] args) {
        Test t2 = new Test();
    }
}
