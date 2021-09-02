package com.king.M09;

import com.king.Helper;
import com.king.ListNode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: leetcode
 * @description: 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @author: King
 * @create: 2021-09-02 18:08
 */
public class Test2 {


//执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 41.18% 的用户
public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode fast = head;
    while(fast!=null) {
        fast = fast.next;
        if(k==0) {
            head = head.next;
        }else {
            k--;
        }
    }
    return head;
}

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        ListNode listNode = new ListNode(Helper.getArrays(1,2,3,4,5,6));
        Helper.print(test2.getKthFromEnd(listNode,2));
    }











    public static class s{
        /**
         * 根据日期获得所在周的日期
         *
         * @param mdate
         * @return
         */
        @SuppressWarnings("deprecation")
        public static List<Date> dateToWeek(Date mdate) {
            int b = mdate.getDay();

            Date fdate;
            List<Date> list = new ArrayList<>();
            long fTime = mdate.getTime() - (long) b * 24 * 3600000;
            for (int a = 1; a <= 7; a++) {
                fdate = new Date();
                fdate.setTime(fTime + (a * 24 * 3600000)); //一周从周一开始算，则使用此方式
                //fdate.setTime(fTime + ((a-1) * 24*3600000)); //一周从周日开始算，则使用此方式
                list.add(a - 1, fdate);
            }

            return list;
        }

        /**
         * 测试
         *
         * @param args
         */
        public static void main(String[] args) {
            // 定义输出日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();
            List<Date> days = dateToWeek(currentDate);
            System.out.println("今天的日期: " + sdf.format(currentDate));
            for (Date date : days) {
                System.out.println(sdf.format(date));

            }
            List<Date> list = dateToWeek(new Date());
            String startDate = sdf.format(list.get(0));
            String endDate = sdf.format(list.get(1));
            Helper.print(startDate + " " +endDate);
        }
    }
}
