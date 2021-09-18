package com.king.M09;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 292. Nim 游戏
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nim-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-09-18 10:24
 */
public class Test18 {
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
    //内存消耗： 35.3 MB , 在所有 Java 提交中击败了 6.47% 的用户
    public boolean canWinNim(int n) {
        return (n & 3) >= 1;
    }

    //这题我在网易遇到过 反正 return n % ( 最大 + 最小 ) != 0 即可
    //别看这题答案短，我还遇到过直接 return true 的题
    public boolean canWinNim1(int n) {
        return n % 4 != 0;
    }
    public static void main(String[] args) {
        Test18 test18 = new Test18();
        MyPrint.print(test18.canWinNim(4));
        MyPrint.print(test18.canWinNim(2));
    }

//你和你的朋友，两个人一起玩?Nim 游戏：
//
//桌子上有一堆石头。
//你们轮流进行自己的回合，你作为先手。
//每一回合，轮到的人拿掉?1 - 3 块石头。
//拿掉最后一块石头的人就是获胜者。
//假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。


}