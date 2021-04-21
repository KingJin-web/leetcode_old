package com.king.MyJava.Second;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-04-21 16:21
 */
public class Simulator {
    void playSound(Animal a) {
        a.cry();
        System.out.println("This is a " + a.getAnimalName());
    }
}
