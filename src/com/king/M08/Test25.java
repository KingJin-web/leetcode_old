package com.king.M08;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 剑指 Offer II 042. 最近请求次数
 * https://leetcode-cn.com/problems/H8086Q/
 * @author: King
 * @create: 2021-08-25 23:04
 */
public class Test25 {
    private final RecentCounter p = new RecentCounter();

    public static class RecentCounter {

        Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);

            while (queue.peek() < t - 3000) {
                queue.poll();
            }

            return queue.size();
        }

    }

    public static void main(String[] args) {
        Test25 test25 = new Test25();
        test25.p.ping(155);
    }
}

