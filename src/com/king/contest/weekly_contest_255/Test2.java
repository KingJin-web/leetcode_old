package com.king.contest.weekly_contest_255;

import com.king.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-08-22 10:51
 */
public class Test2 {

    List<String> list = new ArrayList<>();

    String a = null;
    public String findDifferentBinaryString(String[] nums) {
        list = Arrays.asList(nums);
        int n = nums.length;
        dfs(n, "");

        return a;
    }

    //step从deep开始, 0结束
    void dfs(int step, String res) {
        if (step == 0) {
            if (!list.contains(res)){
                a = res;
                return;
            }
        } else {
            dfs(step - 1, res + "0");
            dfs(step - 1, res + "1");
        }

    }

    public static void main(String[] args) {

        Test2 test2 = new Test2();
        int deep = 2;

        //test2.dfs(deep, "");

        Helper.print(test2.findDifferentBinaryString(Helper.getArrays("111","011","001")));
    }

}
