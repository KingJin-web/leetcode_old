package com.king.MyJava.Second;

/**
 * @program: leetcode
 * @description: 圆类
 * @author: King
 * @create: 2021-04-21 16:07
 */
public class Circle implements Shape {

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double s() {
        return pI * r * r;
    }
}
