package com.king.M11;

import com.king.util.MyPrint;
import org.junit.rules.TestRule;

/**
 * @program: leetcode
 * @description: 367. 有效的完全平方数
 * @author: King
 * @create: 2021-11-04 00:57
 */
public class Test4 {

    //给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
    //
    //进阶：不要 使用任何内置的库函数，如? sqrt 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/valid-perfect-square
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 26.79% 的用户
    public boolean isPerfectSquare(int num) {
        return Math.sqrt(num) % 1 == 0;
    }

    public boolean isPerfectSquare1(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // int product = mid * mid;   越界
            int t = num / mid;
            if (t == mid) {
                if (num%mid == 0) return true;
                low = mid + 1;
            } else if (t < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        MyPrint.print(test4.isPerfectSquare(16));
    }
}
