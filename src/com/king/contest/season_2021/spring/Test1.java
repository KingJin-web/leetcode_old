package com.king.contest.season_2021.spring;

import com.king.util.MyPrint;
import com.king.util.LeetcodeUtil;

/**
 * @program: leetcode
 * @description: 1. 拿硬币
 * <p>
 * https://leetcode-cn.com/problems/na-ying-bi/submissions/
 * @author: King
 * @create: 2021-09-11 17:19
 */
public class Test1 {
    //执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.5 MB , 在所有 Java 提交中击败了 85.27% 的用户
    public int minCount(int[] coins) {
        int result = 0;
        for (int coin : coins) {
            result += coin / 2 + coin % 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
//        输入：[4,2,1]
//        输出：4
        MyPrint.print(test1.minCount(LeetcodeUtil.stringToIntegerArray("[4,2,1]")));
    }
}
