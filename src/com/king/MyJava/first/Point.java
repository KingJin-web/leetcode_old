package com.king.MyJava.first;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-04-07 16:17
 */
public class Point {
    private double X;
    private double Y;

    public Point(double x, double y) {
        X = x;
        Y = y;
    }

    @Override
    public String toString() {
        return "X=" + X + ", Y=" + Y;
    }

    public void moveXAdd() {
        this.X++;
    }

    public void moveYAdd() {
        this.Y++;
    }

    public void moveXSub() {
        this.X--;
    }

    public void moveYSub() {
        this.Y--;
    }

    public void moveTo(double x, double y) {
        this.X = x;
        this.Y = y;

    }
}


class Test {
    public static void main(String[] args) {
        Point point = new Point(5, -5);

        point.moveXAdd();
        System.out.println(point);
        point.moveYAdd();
        System.out.println(point);
        point.moveTo(18, 19);
        System.out.println(point);
    }
}
