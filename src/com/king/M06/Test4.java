package com.king.M06;

/**
 * @program: leetcode
 * @description: 374. 猜数字大小
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 * @author: King
 * @create: 2021-06-14 23:34
 */
public class Test4  extends GuessGame{
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;

    }
}
