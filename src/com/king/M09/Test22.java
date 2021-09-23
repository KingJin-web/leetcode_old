package com.king.M09;

import com.king.ListNode;
import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 725. 分隔链表
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 * @author: King
 * @create: 2021-09-22 18:21
 */
public class Test22 {
    //给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
    //
    //每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
    //
    //这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
    //
    //返回一个由上述 k 部分组成的数组。

    //1，遍历链表获取长度 length（这个跑不掉 ?）；
    //2，length 除以 k 得到每段链表的平均长度 aveLength 和 余数 remainder，remainder 的值就是有多少个长度为 (aveLength + 1) 的子链表排在前面。
    //    2.1，举个例子帮助理解一下 11 / 3 = 3 余 2： 一共有3段，每段平均3个节点，但是剩下了2个节点，剩下的2个节点不能丢啊，得全部塞到子链表里面去，怎么塞呢？
    //    2.2，根据题意长的链表排前面，短的链表排后面，所以只有前面的两个子链表一人分担一个多余的节点，如此一来便形成了 4 4 3 的结构。
    //3，接下来的事儿就比较简单了，按照每个子链表应该的长度[4, 4, 3]去截断给定的链表。
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 13.70% 的用户
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode listNode = head;
        int len = 0;
        while (listNode != null) {
            listNode = listNode.next;
            ++len;
        }
        int quotient = len / k, remainder = len % k;
        ListNode[] listNodes = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; ++i) {
            curr.println();
            listNodes[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; ++j) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return listNodes;
    }

    public static void main(String[] args) {
        Test22 test22 = new Test22();
        ListNode listNode = LeetcodeUtil.stringToListNode("[1,2,3,4,5,6,7,8,9,10]");
        for (ListNode listNode1 : test22.splitListToParts(listNode, 3)) {
            listNode1.println();
        }
        listNode = LeetcodeUtil.stringToListNode("[1,2,3]");
//        for (ListNode listNode1 : test22.splitListToParts1(listNode, 5)) {
//           // listNode1.println();
//        }
        MyPrint.print(Arrays.toString(test22.splitListToParts1(listNode, 5)));
//        listNode = LeetcodeUtil.stringToListNode("[1,2,3,4,5,6,7,8,9,10]");
//        for (ListNode listNode1 : test22.splitListToParts1(listNode, 3)) {
//            listNode1.println();
//        }
    }

    public ListNode[] splitListToParts1(ListNode head, int k) {
        ListNode listNode = head;
        int len = 0;
        while (listNode != null) {
            listNode = listNode.next;
            ++len;
        }
        int quotient = len / k, remainder = len % k;
        ListNode[] listNodes = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; ++i) {
            listNodes[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; ++j) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return listNodes;
    }

}
