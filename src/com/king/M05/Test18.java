package com.king.M05;

/**
 * @program: leetcode
 * @description: 993. 二叉树的堂兄弟节点
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * @author: King
 * @create: 2021-05-17 00:05
 */
public class Test18 {
    public static void main(String[] args) {
        int [] a= {0,1,2,3,4,5},b[] = {{1,2},{4,5,6,7}};
        b[0] = a;
        b[0][1] = b [1][3];
        System.out.println(b[0][3]);
        System.out.println(a[1]);
    }
}
