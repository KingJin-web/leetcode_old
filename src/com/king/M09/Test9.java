package com.king.M09;

import com.king.util.MyPrint;
import com.king.util.StringUtil;

/**
 * @program: leetcode
 * @description: 1894. 找到需要补充粉笔的学生编号
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-09-10 18:42
 */
public class Test9 {
//一个班级里有n个学生，编号为 0到 n - 1。每个学生会依次回答问题，编号为 0的学生先回答，
//然后是编号为 1的学生，以此类推，直到编号为 n - 1的学生，然后老师会重复这个过程，重新从编号为 0的学生开始回答问题。
//给你一个长度为 n且下标从 0开始的整数数组chalk和一个整数k。一开始粉笔盒里总共有k支粉笔。当编号为i的学生回答问题时，
//他会消耗 chalk[i]支粉笔。如果剩余粉笔数量 严格小于chalk[i]，那么学生 i需要 补充粉笔。
//请你返回需要 补充粉笔的学生 编号。

    //执行用时： 2537 ms , 在所有 Java 提交中击败了 5.03% 的用户 内存消耗： 54.5 MB , 在所有 Java 提交中击败了 27.96% 的用户
    public int chalkReplacer1(int[] chalk, int k) {
        while (true) {
            for (int i = 0; i < chalk.length; i++) {
                if (k < chalk[i]) {
                    return i;
                }
                k -= chalk[i];
            }
        }
    }

    //超时
    public int chalkReplacer(int[] chalk, int k) {
        int index = 0;
        int ln = chalk.length;
        int a = 0;
        while (k >= (a = chalk[index % ln])) {
            k -= a;
            System.out.println("  " + index % ln + " " + k);
            ++index;
        }
        return index % ln;
    }

    public static void main(String[] args) {
        //输入：chalk = [5,1,5], k = 22
        //输出：0
        //解释：学生消耗粉笔情况如下：
        //- 编号为 0 的学生使用 5 支粉笔，然后 k = 17 。
        //- 编号为 1 的学生使用 1 支粉笔，然后 k = 16 。
        //- 编号为 2 的学生使用 5 支粉笔，然后 k = 11 。
        //- 编号为 0 的学生使用 5 支粉笔，然后 k = 6 。
        //- 编号为 1 的学生使用 1 支粉笔，然后 k = 5 。
        //- 编号为 2 的学生使用 5 支粉笔，然后 k = 0 。
        //编号为 0 的学生没有足够的粉笔，所以他需要补充粉笔。
        Test9 test9 = new Test9();
        MyPrint.print(test9.chalkReplacer(StringUtil.stringToIntegerArray("[5,1,5]"), 22));
        MyPrint.print(test9.chalkReplacer(StringUtil.stringToIntegerArray("[3,4,1,2]"), 25));
    }
}
