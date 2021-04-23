package com.king;

/**
 * @program: leetcode
 * @description: 单链表的定义。
 * @author: King
 * @create: 2021-04-23 20:59
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] arr) {
        for (int a : arr) {
            add(a);
        }

    }

    public void print() {
        System.out.print(this.val + "-->");
        if (this.next != null) {
            this.next.print();
        }
    }

    public void add(int num) {
        ListNode newNode = new ListNode(num);
        if (this.next == null) {
            this.next = newNode;
        } else {
            this.next.add(num);
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}