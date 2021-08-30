package com.king.M08;

import com.king.Helper;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: leetcode
 * @description: 528. 按权重随机选择
 * 链接：https://leetcode-cn.com/problems/random-pick-with-weight
 * @author: King
 * @create: 2021-08-30 13:59
 */
public class Test30 {

    //执行用时： 28 ms , 在所有 Java 提交中击败了 62.44% 的用户 内存消耗： 43.4 MB , 在所有 Java 提交中击败了 33.78% 的用户
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

    public static void main(String[] args) {
        //输入：
        //["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
        //[[[1,3]],[],[],[],[],[]]
        //输出：
        //[null,1,1,1,1,0]
        //解释：
        //Solution solution = new Solution([1, 3]);
        //solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
        //solution.pickIndex(); // 返回 1
        //solution.pickIndex(); // 返回 1
        //solution.pickIndex(); // 返回 1
        //solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
        //
        //由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
        //[null,1,1,1,1,0]
        //[null,1,1,1,1,1]
        //[null,1,1,1,0,0]
        //[null,1,1,1,0,1]
        //[null,1,0,1,0,0]
        //......
        //诸若此类。

        Solution solution = new Solution(Helper.getArrays(1, 3));
        ArrayList<Integer> list = new ArrayList<>();

        list.add(solution.pickIndex()); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
        list.add(solution.pickIndex()); // 返回 1
        list.add(solution.pickIndex()); // 返回 1
        list.add(solution.pickIndex()); // 返回 1
        list.add(solution.pickIndex()); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
        Helper.print(list.toArray());
    }
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
