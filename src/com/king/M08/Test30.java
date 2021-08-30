package com.king.M08;

import java.util.Random;

/**
 * @program: leetcode
 * @description: 528. 按权重随机选择
 * @author: King
 * @create: 2021-08-30 13:59
 */
public class Test30 {

    public static class Solution {
        int[] pre;
        int sum = 0;

        public Solution(int[] w) {
            pre = new int[w.length];
            for (int i = 0; i < pre.length; i++) {
                sum += w[i];
                pre[i] = sum;
            }
        }

        static Random r = new Random();

        public int pickIndex() {
            int target = r.nextInt(sum) + 1;
            return getIdx(target);
        }

        public int getIdx(int target) {
            int l = 0, r = pre.length - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (pre[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
