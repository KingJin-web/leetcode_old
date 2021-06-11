package com.king.M06;

import com.king.ListNode;

import java.util.List;

/**
 * @program: leetcode
 * @description: 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author: King
 * @create: 2021-06-05 23:19
 */
public class Test1 {
    /**
     *
     执行用时：1 ms, 在所有 Java 提交中击败了99.81%的用户
     内存消耗：40 MB, 在所有 Java 提交中击败了5.03%的用户
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
       int[] head = {1,2,6,3,4,5,6};
        int val = 6;
        ListNode listNode = new ListNode(head);
        System.out.println(listNode);
        System.out.println(new Test1().removeElements(listNode,val));
    }
}
