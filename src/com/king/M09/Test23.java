package com.king.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 326. 3的幂
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-09-23 14:50
 */
public class Test23 {
    //给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
    //
    //整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x

    //简单递归
    //执行用时： 15 ms , 在所有 Java 提交中击败了 93.08% 的用户
    //内存消耗： 37.9 MB , 在所有 Java 提交中击败了 91.37% 的用户
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        return (n % 3 == 0) && isPowerOfThree(n / 3);
    }

    //你能不使用循环或者递归来完成本题吗？
    //在题目给定的 3232 位有符号整数的范围内，最大的 33 的幂为 3^{19} = 1162261467。我们只需要判断 nn 是否是 3^{19}的约数即可。
    //与方法一不同的是，这里需要特殊判断 n 是负数或 0 的情况。
    //执行用时： 15 ms , 在所有 Java 提交中击败了 93.08% 的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 48.36% 的用户
    public boolean isPowerOfThree1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    //换底公式
    //执行用时： 17 ms , 在所有 Java 提交中击败了 21.16% 的用户 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 69.48% 的用户
    public boolean isPowerOfThree2(int n) {
        double v = Math.log10(n) / Math.log10(3);
        return v%1 == 0;
    }
    public static void main(String[] args) {
        Test23 test23 = new Test23();
        boolean b = test23.isPowerOfThree(9);
        MyPrint.print(b);
        MyPrint.print(test23.isPowerOfThree2(9));
        MyPrint.print(test23.isPowerOfThree2(99));
    }

}
