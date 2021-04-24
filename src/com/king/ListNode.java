package com.king;

/**
 * @program: leetcode
 * @description: 单链表的定义。
 * @author: King
 * @create: 2021-04-23 20:59
 */
public class ListNode {

   public int val;
   public ListNode next;

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
     * LinkList CreateListByTailInsert(int *a, int n) //尾插法
     * {
     * <p>
     * LinkList head = (ListNode *)malloc(sizeof(ListNode)); //生成头结点
     * head->next = NULL;
     * head->data = 0; // 不要
     * ListNode *tailNode = head;
     * for (int i = 0; i < n; i++) //  head
     * {
     * ListNode *newnode = (ListNode *)malloc(sizeof(ListNode)); //生成头结点
     * newnode->next = NULL;
     * newnode->data = a[i];
     * tailNode->next = newnode;
     * tailNode = newnode;
     * }
     * <p>
     * return head; //返回头指针
     * }
     *
     * @param arr
     */
    public ListNode(int[] arr) {
        if (arr.length < 2) {
            this.val = arr[0];
            return;
        }
        this.val = arr[0];
        this.next = new ListNode(arr[1]);
        ListNode other = this.next;
        for (int i = 2; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            other.next = temp;
            other = temp;
        }

    }

    /**
     * 1-->2-->3-->4-->5-->6-->8
     * 单链表的打印
     */
    public void println() {
        if (this.next != null) {
            System.out.print(this.val + "-->");
            this.next.println();
        } else {
            System.out.println(this.val);
        }
    }

    /**
     * 插入
     * @param num
     */
    public void add(int num) {
        ListNode newNode = new ListNode(num);
        if (this.next == null) {
            this.next = newNode;
        } else {
            this.next.add(num);
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




    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}