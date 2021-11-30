package com.king.M11;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode
 * @description: 786. 第 K 个最小的素数分数
 * https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/
 * @author: King
 * @create: 2021-11-29 23:09
 */
public class Test29 {

    //执行用时： 379 ms , 在所有 Java 提交中击败了 28.24% 的用户 内存消耗： 74.6 MB , 在所有 Java 提交中击败了 21.18% 的用户



     int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        List<int[]> frac = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                frac.add(new int[]{arr[i], arr[j]});
            }
        }
        frac.sort((x, y) -> x[0] * y[1] - y[0] * x[1]);
        return frac.get(k - 1);
    }

    public static void main(String[] args) {
        //输入：arr = [1,2,3,5], k = 3
        //输出：[2,5]
        //解释：已构造好的分数,排序后如下所示:
        //1/5, 1/3, 2/5, 1/2, 3/5, 2/3
        //很明显第三个最小的分数是 2/5
     Test29 test29 = new Test29();
        MyPrint.print(test29.kthSmallestPrimeFraction(LeetcodeUtil.stringToIntegerArray("[1,2,3,5]"),3));

    }


}


