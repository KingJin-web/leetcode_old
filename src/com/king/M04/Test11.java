package com.king.M04;

import com.king.ListNode;

/**
 * @program: leetcode
 * @description: 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author: King
 * @create: 2021-04-23 20:58
 */
public class Test11 {
    public static void main(String[] args) {
        //[2,4,3]
        //[5,6,4]
        int arr[] = new int[]{2,4,3};
        ListNode l1 = new ListNode(arr);

        l1.print();

        ListNode l2 = new ListNode(2,l1);

        System.out.println(l2);

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }
}
