package com.king.MyJava.Second;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-04-21 16:22
 */
public class Application {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.playSound(new Dog());
        simulator.playSound(new Cat());
    }
}
