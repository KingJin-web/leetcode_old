package com.king.contest.weekly_contest_262;

import java.util.*;
/**
 * @program: leetcode
 * @description: 5895. 获取单值网格的最小操作数
 * https://leetcode-cn.com/contest/weekly-contest-262/problems/minimum-operations-to-make-a-uni-value-grid/
 * @author: King
 * @create: 2021-10-10 11:18
 */
public class Test2 {
    public int minOperations(int[][] grid, int x) {

        return 0;
    }
}
class StockPrice {

    //时间戳  价格
    Map<Integer, Integer> map;

    int last;

    public StockPrice() {
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
        return getMaxValue(map);
    }

    public int minimum() {
        return getMinValue(map);
    }


    public  Integer getMaxValue(Map<Integer, Integer> map) {
        Collection<Integer> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return (Integer) obj[obj.length - 1];
    }


    public  Integer getMinValue(Map<Integer, Integer> map) {
        Collection<Integer> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return (Integer) obj[0];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */