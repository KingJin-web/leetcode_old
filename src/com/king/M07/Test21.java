package com.king.M07;

import com.king.Helper;
import com.king.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @author: King
 * @create: 2021-07-21 16:38
 */
public class Test21 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode listNode = headA;
        while (listNode != null) {
            set.add(listNode); System.out.println(listNode);
            listNode = listNode.next;

        }
        listNode = headB;
        while (listNode != null){
           if(set.contains(listNode)){
                return listNode;
           }
            System.out.println(listNode);
            listNode = listNode.next;
        }
        return null;
    }

    /**
     *
     执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     内存消耗：41.1 MB, 在所有 Java 提交中击败了58.16%的用户
     太浪漫了 两个结点不断的去对方的轨迹中寻找对方的身影，只要二人有交集，就终会相遇❤
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode n1 = headA;
        ListNode n2 = headB;

        while(n1 != n2){
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }
    public static void main(String[] args) {
        Test21 t21 = new Test21();
        ListNode headA = new ListNode(Helper.getArrays(0, 9, 1, 2, 4));
        ListNode headB = new ListNode(Helper.getArrays(3, 2, 4));

        Helper.print(t21.getIntersectionNode(headA,headB));
        Helper.print(t21.getIntersectionNode1(headA,headB));
        headA = new ListNode(Helper.getArrays(4,1,8,4,5));
        headB =new ListNode(Helper.getArrays(5,0,1,8,4,5));
        Helper.print(t21.getIntersectionNode(headA,headB));
        Helper.print(t21.getIntersectionNode1(headA,headB));
    }
}
