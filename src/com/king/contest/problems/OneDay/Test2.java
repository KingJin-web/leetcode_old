package com.king.contest.problems.OneDay;

import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: LCP 29. 乐团站位
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/SNJvJP
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-09-16 20:04
 */
public class Test2 {
    public int orchestraLayout(int num, int x, int y) {
        //先确定这个位置在第几圈,circle从0开始计数，即第“一”圈为circle == 0
        long circle = Math.min(Math.min(x, num - 1 - x), Math.min(y, num - 1 - y));

        //len 记录第circle圈的边长，边长为正方形边长-1，每圈过后边长减2
        long len = num - 1 - 2 * circle;

        //count一定会溢出，这里参考 @灰包包 老哥的count解法。
        long count = (long) num * num - (len + 1) * (len + 1);

        //根据pos在不同的坐标来计算count，其实这里想要优化来着
        if (x == circle && y < num - 1 - circle) {
            count += y - circle + 1;          //这个时候在上边的边
        } else if (y == num - 1 - circle && x < num - 1 - circle) {
            count += len + x - circle + 1;        //在右边的边
        } else if (x == num - 1 - circle && y > circle) {
            count += 2 * len + num - circle - y;    //在下边的边
        } else {
            count += 3 * len + num - circle - x;
        }
        return (int) (count % 9 == 0 ? 9 : count % 9);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        //输入：num = 3, Xpos = 0, Ypos = 2
        //输出：3
        MyPrint.print(test2.orchestraLayout(3,0,2));
    }
    //某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。
    // 乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。
    //为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。
    // 例如当 num = 5 时，站位如图所示


}
