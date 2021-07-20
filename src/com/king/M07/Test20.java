package com.king.M07;

import com.king.Helper;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 118. 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/
 * @author: King
 * @create: 2021-07-20 20:09
 */
public class Test20 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    public static void main(String[] args) {
        Test20 t20 = new Test20();
        Helper.printList(t20.generate(5));
    }

}
