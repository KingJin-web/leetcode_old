package com.king.M08;

import com.king.Helper;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 611. 有效三角形的个数
 * https://leetcode-cn.com/problems/valid-triangle-number/
 * @author: King
 * @create: 2021-08-04 09:55
 */
public class Test4 {
    static Test4 t4 = new Test4();

    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int c = 0;
        Arrays.sort(nums);
        for (int i = 0; i <n; ++i) {
            int k = i;
            for (int j = i + 1; j < n; ++j) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    Helper.println(nums[i],nums[j],nums[k]);
                    ++k;
                }
                c += Math.max(k - j, 0);
            }
        }

        return c;
    }

    public static void main(String[] args) {


        Helper.print(t4.triangleNumber(Helper.getArrays(2, 2, 3, 4)));
    }

}
