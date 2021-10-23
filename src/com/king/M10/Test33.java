package com.king.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 492. 构造矩形
 * https://leetcode-cn.com/problems/construct-the-rectangle/
 * @author: King
 * @create: 2021-10-23 23:11
 */
public class Test33 {

    //作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，
    // 你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
    //
    //1. 你设计的矩形页面必须等于给定的目标面积。
    //
    //2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
    //
    //3. 长度 L 和宽度 W 之间的差距应当尽可能小。

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
    //内存消耗： 35.8 MB , 在所有 Java 提交中击败了 59.59% 的用户
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[]{area / w, w};
    }

    public static void main(String[] args) {
        Test33 test33 = new Test33();
        MyPrint.print(test33.constructRectangle(11));
    }
}
