package com.king.M10;

import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode
 * @description: 352.将数据流变为多个不相交区间
 * https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/
 * @author: King
 * @create: 2021-10-09 23:22
 */

public class Test9 {
    //实现 SummaryRanges 类：
    //
    //SummaryRanges() 使用一个空数据流初始化对象。
    //void addNum(int val) 向数据流中加入整数 val 。
    //int[][] getIntervals() 以不相交区间?[starti, endi] 的列表形式返回对数据流中整数的总结。

    //执行用时： 315 ms , 在所有 Java 提交中击败了 5.60% 的用户 内存消耗： 44.1 MB , 在所有 Java 提交中击败了 24.80% 的用户
    private static class SummaryRanges {

        private final List<Integer> list;

        public SummaryRanges() {
            list = new ArrayList<>();
        }

        public void addNum(int val) {
            list.add(val);
        }

        public int[][] getIntervals() {
            if (list.size() == 1) {
                return new int[][]{{list.get(0), list.get(0)}};
            }
            Collections.sort(list);
            List<int[]> intevals = new ArrayList<>();
            int l = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 1) > 1) {
                    intevals.add(new int[]{l, list.get(i - 1)});
                    l = list.get(i);
                }
            }
            intevals.add(new int[]{l, list.get(list.size() - 1)});
            return intevals.toArray(new int[intevals.size()][]);
        }


    }

    public static void main(String[] args) {

        // Your SummaryRanges object will be instantiated and called as such:
        SummaryRanges obj = new SummaryRanges();
        obj.addNum(10);
        int[][] param_2 = obj.getIntervals();

        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);      // arr = [1]
        // 返回 [[1, 1]]
        MyPrint.print(summaryRanges.getIntervals(),true);

        summaryRanges.addNum(3);      // arr = [1, 3]
        // 返回 [[1, 1], [3, 3]]
        MyPrint.print(summaryRanges.getIntervals());
        summaryRanges.addNum(7);      // arr = [1, 3, 7]
        // 返回 [[1, 1], [3, 3], [7, 7]]
        MyPrint.print(summaryRanges.getIntervals());
        summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
        // 返回 [[1, 3], [7, 7]]
        MyPrint.print(summaryRanges.getIntervals());
        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        // 返回 [[1, 3], [6, 7]]
        MyPrint.print(summaryRanges.getIntervals());
    }

    //输入：
    //["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
    //[[], [1], [], [3], [], [7], [], [2], [], [6], []]
    //输出：
    //[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
    //
    //解释：
    //SummaryRanges summaryRanges = new SummaryRanges();
    //summaryRanges.addNum(1);      // arr = [1]
    //summaryRanges.getIntervals(); // 返回 [[1, 1]]
    //summaryRanges.addNum(3);      // arr = [1, 3]
    //summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
    //summaryRanges.addNum(7);      // arr = [1, 3, 7]
    //summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
    //summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
    //summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
    //summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
    //summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
}
