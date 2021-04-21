package com.king.MyJava.Second;

/**
 * @program: leetcode
 * @description: 猫
 * @author: King
 * @create: 2021-04-21 16:19
 */
public class Cat implements Animal {
    @Override
    public void cry() {
        System.out.println("喵 喵 喵!");
    }

    @Override
    public String getAnimalName() {
        return "猫";
    }
}
