package com.king.M10;

import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 869. 重新排序得到 2 的幂
 * https://leetcode-cn.com/problems/reordered-power-of-2/comments/
 * @author: King
 * @create: 2021-10-28 02:14
 */
public class Test28 {

    //给定正整数 N?，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
    //
    //如果我们可以通过上述方式得到?2 的幂，返回 true；否则，返回 false。

    //执行用时： 1 ms , 在所有 Java 提交中击败了 97.93% 的用户
    //内存消耗： 35.2 MB , 在所有 Java 提交中击败了 77.59% 的用户
    public boolean reorderedPowerOf2(int N) {
        String[] rec = {"1", "2", "4", "8", "16", "23", "46", "128", "256", "125", "0124", "0248", "0469", "1289", "13468",
                "23678", "35566", "011237", "122446", "224588", "0145678", "0122579", "0134449", "0368888",
                "11266777", "23334455", "01466788", "112234778", "234455668", "012356789", "0112344778"};
        char[] at = String.valueOf(N).toCharArray();
        Arrays.sort(at);
        String str = new String(at);
        for (String p : rec) {
            if (str.equals(p)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Test28 test28 = new Test28();
        //示例 4：
        //
        //输入：24
        //输出：false
        //示例 5：
        //
        //输入：46
        //输出：true
        MyPrint.print(test28.reorderedPowerOf2(24));
    }
}
