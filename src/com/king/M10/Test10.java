package com.king.M10;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 441. 排列硬币
 * https://leetcode-cn.com/problems/arranging-coins/
 * @author: King
 * @create: 2021-10-10 21:15
 */
public class Test10 {
    //执行用时： 10 ms , 在所有 Java 提交中击败了 17.84% 的用户 内存消耗： 35.6 MB , 在所有 Java 提交中击败了 54.82% 的用户
    public int arrangeCoins1(int n) {
        int result = 0;
        int i = 1;
        while (n >= i) {
            n -= i;
            ++result;
            ++i;
        }
        return result;
    }
    /**
     * 数学求解法 O(1) 不含求根预算
     *执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.7 MB , 在所有 Java 提交中击败了 22.41% 的用户
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {
        return (int) (-1 + Math.sqrt(1 + 8 * (long) n)) / 2;
    }

    /**
     * 迭代求解法 O(n)
     *执行用时： 8 ms , 在所有 Java 提交中击败了 35.69% 的用户
     * 内存消耗： 35.7 MB , 在所有 Java 提交中击败了 12.78% 的用户
     * @param n
     * @return
     */
    public static int arrangeCoins2(int n) {
        int i = 1;
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;
    }

    /**
     * 二分查找，O(log(n / 2 + 1))
     *
     * @param n
     * @return
     */
    public static int arrangeCoins3(int n) {
        long start = 0, end = (long) n / 2 + 1, mid;
        while (end - start > 1) {
            mid = (start + end) >>> 1;
            if (mid * (mid + 1) == (long) 2 * n) {
                return (int) mid;
            } else if (mid * (mid + 1) <= (long) 2 * n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (end * (end + 1) == (long) 2 * n) ? (int) end : (int) start;
    }
    public static void main(String[] args) {
        Test10 test10 = new Test10();
        MyPrint.print(test10.arrangeCoins(8));
    }
}
