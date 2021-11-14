package com.king.M11;

import com.king.util.MyPrint;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 677. 键值映射
 * https://leetcode-cn.com/problems/map-sum-pairs/
 * @author: King
 * @create: 2021-11-14 12:33
 */

public class Test14 {

    //执行用时： 12 ms , 在所有 Java 提交中击败了 66.71% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 75.04% 的用户
    public static class MapSum {

        private Map<String, Integer> map;

        public MapSum() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (Map.Entry<String, Integer> m : map.entrySet()) {
                if (m.getKey().startsWith(prefix)) {
                    sum += m.getValue();
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("key", 1);
        obj.insert("key2", 1);
        obj.insert("key3", 1);
        obj.insert("key", 4);
        obj.insert("123key", 1);
        int param_2 = obj.sum("key");
        MyPrint.print(obj);
        MyPrint.print(param_2);
    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
}
