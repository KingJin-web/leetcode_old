package com.king.M06;

import com.king.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author: King
 * @create: 2021-06-05 23:26
 */
public class Test2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] listA = {4, 1, 8, 4, 5}, listB = {5, 0, 1, 8, 4, 5};
        ListNode listNode1 = new ListNode(listA);
        ListNode listNode2 = new ListNode(listB);

        System.out.println(new Test2().getIntersectionNode(listNode1,listNode2));
    }
}
