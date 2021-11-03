package com.king.M11;

import com.king.ListNode;
import com.king.util.LeetcodeUtil;

/**
 * @program: leetcode
 * @description: 237. 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author: King
 * @create: 2021-11-02 02:45
 */
public class Test2 {

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 37.8 MB ,
    //在所有 Java 提交中击败了 54.53% 的用户
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        ListNode listNode = LeetcodeUtil.stringToListNode("[4,5,1,9]");
        LeetcodeUtil.prettyPrintLinkedList(listNode);
        test2.deleteNode(listNode);
        LeetcodeUtil.prettyPrintLinkedList(listNode);
    }
}
