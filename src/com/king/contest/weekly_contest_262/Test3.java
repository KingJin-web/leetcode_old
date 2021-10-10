package com.king.contest.weekly_contest_262;

import com.king.Helper;
import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.*;

/**
 * @program: leetcode
 * @description: 5896. 股票价格波动
 * https://leetcode-cn.com/contest/weekly-contest-262/problems/stock-price-fluctuation/
 * @author: King
 * @create: 2021-10-10 11:22
 */
public class Test3 {

    static class StockPrice1 {

        //时间戳  价格
        Map<Integer, Integer> map;

        int last;

        public StockPrice1() {
            map = new HashMap<>();
        }

        public void update(int timestamp, int price) {
            last = timestamp;
            map.put(timestamp, price);
        }

        public int current() {
            return map.get(last);
        }

        public int maximum() {
            Collection<Integer> c = map.values();
            Integer[] obj = c.toArray(new Integer[0]);
            Arrays.sort(obj);
            return obj[obj.length - 1];
        }

        public int minimum() {
            Collection<Integer> c = map.values();
            Integer[] obj = c.toArray(new Integer[0]);
            Arrays.sort(obj);
            return  obj[0];
        }
    }

    static class StockPrice {
        private final TreeMap<Integer, Integer> map = new TreeMap<>();
        private final TreeMap<Integer, Integer> count = new TreeMap<>();

        public void update(int timestamp, int price) {
            if (map.containsKey(timestamp)) {
                count.put(map.get(timestamp), count.get(map.get(timestamp)) - 1);
                if (count.get(map.get(timestamp)) == 0) {
                    count.remove(map.get(timestamp));
                }
            }
            map.put(timestamp, price);
            count.put(price, count.getOrDefault(price, 0) + 1);
        }

        public int current() {
            return map.lastEntry().getValue();
        }

        public int maximum() {
            return count.lastKey();
        }

        public int minimum() {
            return count.firstKey();
        }
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
        stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
        MyPrint.print(stockPrice.current() );     // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
        MyPrint.print(stockPrice.maximum());     // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
        stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 。
        // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
        MyPrint.print(stockPrice.maximum());     // 返回 5 ，更正后最高价格为 5 。
        stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
        MyPrint.print( stockPrice.minimum());     // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
    }
//["StockPrice","update","maximum","current","minimum","maximum","maximum","maximum","minimum","minimum","maximum","update","maximum","minimum","update","maximum","minimum","current","maximum","update","minimum","maximum","update","maximum","maximum","current","update","current","minimum","update","update","minimum","minimum","update","current","update","maximum","update","minimum"]
//[[],[38,2308],[],[],[],[],[],[],[],[],[],[47,7876],[],[],[58,1866],[],[],[],[],[43,121],[],[],[40,5339],[],[],[],[32,5339],[],[],[43,6414],[49,9369],[],[],[36,3192],[],[48,1006],[],[53,8013],[]]


    static class a{
        public static void main(String[] args) {
            String[] strings = Helper.getArrays("StockPrice","update","maximum","current","minimum","maximum","maximum","maximum","minimum","minimum","maximum","update","maximum","minimum","update","maximum","minimum","current","maximum","update","minimum","maximum","update","maximum","maximum","current","update","current","minimum","update","update","minimum","minimum","update","current","update","maximum","update","minimum");
            int[] l = LeetcodeUtil.stringToIntegerArray("[null,null,2308,2308,2308,2308,2308,2308,2308,2308,2308,null,7876,2308,null,7876,1866,1866,7876,null,121,7876,null,7876,7876,1866,null,1866,121,null,null,1866,1866,null,1866,null,9369,null,1006]");

        }
    }
}
