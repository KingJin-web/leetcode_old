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

    /**
     * 将数组转为链表
     * 详细解释一下这个函数的操作过程：
     * <p>
     * 先声明一个root对象，这个对象的指向内存的指针假如是400
     * 再声明一个中转阶段other，此时other和root都是同一个指针400，指向实际的一个内存对象
     * 第一次for遍历时候，先创建一个临时对象temp，指向指针为401的一个内存对象
     * 将401这个指针关联到指针400的next上，这时候root=other，即 400.next=401，此时401.next为空
     * 循环中最后一步将other的指针从400切换为401，即此时root还是400那个对象，root的next为指针401的那个对象
     * 第二次for循环时候，创建一个指针为402的对象temp
     * 将401的next指向402，即此时root的状态为400.next=401，而此时401.next=402，形成的链表即为400->401->402
     * 循环的最后一步又将other指针切换为402
     * 第三次for循环，创建一个指针为403的对象temp
     * 将402的next指向403，即即此时root的状态为400.next=401，401.next=402，402.next=403，形成的链表即为400->401->402->403
     * 经过函数若干次循环后，root最终就会是将一个{400, 401, 402, 403, 404, 405}这样的数组转换为400->401>402->403->404->405的链表结构
     *
     * @param arr
     */
    public ListNode(int[] arr) {
        ListNode root = new ListNode(arr[0]);
        ListNode other = root;
        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            other.next = temp;
            other = temp;
        }
    }

    public ListNode arrayToListNode(int[] s) {
        ListNode root = new ListNode(s[0]);
        ListNode other = root;
        for (int i = 1; i < s.length; i++) {
            ListNode temp = new ListNode(s[i]);
            other.next = temp;
            other = temp;
        }
        return root;
    }

    public void print() {

        if (this.next != null) {
            System.out.print(this.val + "-->");
            this.next.print();
        } else {
            System.out.println(this.val);
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