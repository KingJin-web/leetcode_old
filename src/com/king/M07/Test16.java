package com.king.M07;

import com.king.Helper;
import com.king.ListNode;

import java.util.List;

/**
 * @program: leetcode
 * @description: 206. 反转链表
 * @author: King
 * @create: 2021-07-18 16:19
 */
public class Test16 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Test16 test15 = new Test16();
        ListNode listNode = new ListNode(Helper.getArrays(1, 2, 3, 4, 5));
        ListNode listNode1 = test15.reverseList(listNode);

        System.out.println(listNode1);
    }
}
