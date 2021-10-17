package com.king.contest.biweekly_contest_63;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 5885. 使每位学生都有座位的最少移动次数
 * https://leetcode-cn.com/problems/minimum-number-of-moves-to-seat-everyone/
 * @author: King
 * @create: 2021-10-16 22:48
 */
public class Test1 {

    //执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
    int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < n; i++) ans += Math.abs(seats[i] - students[i]);
        return ans;
    }

    //输入：seats = [4,1,5,9], students = [1,3,2,6]
    //输出：7
    //解释：学生移动方式如下：
    //- 第一位学生不移动。
    //- 第二位学生从位置 3 移动到位置 4 ，移动 1 次。
    //- 第三位学生从位置 2 移动到位置 5 ，移动 3 次。
    //- 第四位学生从位置 6 移动到位置 9 ，移动 3 次。
    //总共 0 + 1 + 3 + 3 = 7 次移动。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/minimum-number-of-moves-to-seat-everyone
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        MyPrint.print(test1.minMovesToSeat(LeetcodeUtil.stringToIntegerArray("[4,1,5,9]"),
                LeetcodeUtil.stringToIntegerArray(" [1,3,2,6]")));
    }
}
