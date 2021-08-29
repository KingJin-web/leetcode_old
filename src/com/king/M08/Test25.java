package com.king.M08;

import com.king.Helper;

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
        //inputs = ["RecentCounter", "ping", "ping", "ping", "ping"]
        //inputs = [[], [1], [100], [3001], [3002]]输入：
        //inputs = ["RecentCounter", "ping", "ping", "ping", "ping"]
        //inputs = [[], [1], [100], [3001], [3002]]
        //输出：
        //[null, 1, 2, 3, 3]

        RecentCounter p = new RecentCounter();
        p.ping(1);
        p.ping(100);
        p.ping(3001);
        int a = p.ping(3002);
        Helper.print(p.queue);
        System.out.println(a);
    }
}

