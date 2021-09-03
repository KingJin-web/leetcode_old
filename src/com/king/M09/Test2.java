package com.king.M09;

import com.king.Helper;
import com.king.ListNode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
        while (fast != null) {
            fast = fast.next;
            if (k == 0) {
                head = head.next;
            } else {
                k--;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        ListNode listNode = new ListNode(Helper.getArrays(1, 2, 3, 4, 5, 6));
        Helper.print(test2.getKthFromEnd(listNode, 2));
    }


    public static class s {
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
            Helper.print(startDate + " " + endDate);
        }
    }

    public static class s2 {
        //这个是根据一天的时间得到一周的时间
        public static List<String> cal2(String time) {//其中time为yyyy-mm-dd形式
            List<String> list = new ArrayList<>();
            String[] strings = time.split("-");
            int year = Integer.parseInt(strings[0]);
            int mon = Integer.parseInt(strings[1]);
            int day = Integer.parseInt(strings[2]);
            Calendar oDate = Calendar.getInstance();
            oDate.set(year, mon - 1, day);
            oDate.add(Calendar.DATE, (-1) * (oDate.get(Calendar.DAY_OF_WEEK)));
            String s;
            for (int i = 1; i < 8; i++) {
                oDate.add(Calendar.DATE, 1);
                s = oDate.get(Calendar.YEAR) + "-";
                s += (oDate.get(Calendar.MONTH) + 1) + "-" + oDate.get(Calendar.DATE);
                list.add(s);
            }
            return list;
        }

        public static List<String> dateToWeek(String date) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date mdate = null;
            try {
                mdate = sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int b = mdate.getDay();
            Date fdate;
            List<String> list = new ArrayList<String>();
            long fTime = mdate.getTime() - (long) b * 24 * 3600000;

            for (int a = 1; a <= 7; a++) {
                fdate = new Date();
                fdate.setTime(fTime + (a * 24 * 3600000)); //一周从周一开始算，则使用此方式
                //fdate.setTime(fTime + ((a-1) * 24*3600000)); //一周从周日开始算，则使用此方式
                list.add(sdf.format(fdate));
            }

            return list;
        }

        public static List<String> a(String recipeTime) throws ParseException {
            List<String> list = new ArrayList<String>();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            //自定义时间
            //String recipeTime = "2019-01-01";
            //现在时间
            //String  recipeTime=simpleDateFormat.format(new Date());
            calendar.setTime(simpleDateFormat.parse(recipeTime));
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            if (1 == week) {
                calendar.add(Calendar.DAY_OF_MONTH, -1);
            }
            int getDayFirst = calendar.get(Calendar.DAY_OF_WEEK);
            calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - getDayFirst);
            //本周星期一
            //String beginDate = simpleDateFormat.format(calendar.getTime());
            //本周星期日
            calendar.add(Calendar.DATE, 6);
            //String endDate = simpleDateFormat.format(calendar.getTime());
            for (int i = 0; i < 7; i++) {
                calendar.setFirstDayOfWeek(Calendar.MONDAY);
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                long time = calendar.getTimeInMillis() + 24 * 60 * 60 * 1000 * i;
                String sunday = simpleDateFormat.format(time);
                list.add(sunday);
            }
            return list;
        }

        public static void main(String[] args) throws ParseException {
//            String str = "\"update_at\":\"";
//            Helper.print(str.length());
            Helper.print(dateToWeek("2021-09-05"));
            Helper.print(cal2("2021-09-11"));
            Helper.print(a("2021-09-05"));
        }
    }
}
