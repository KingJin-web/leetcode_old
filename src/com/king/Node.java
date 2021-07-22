package com.king;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-07-22 09:17
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
}