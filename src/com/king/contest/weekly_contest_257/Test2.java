package com.king.contest.weekly_contest_257;
import java.applet.AudioClip;
import com.king.Helper;
import com.king.util.StringUtil;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-05 11:37
 */
public class Test2 {

    public int numberOfWeakCharacters1(int[][] properties) {
        int c = 0;
        for (int[] nums : properties) {
            boolean b = false;
            for (int[] ns : properties) {
                if (nums[0] < ns[0] && nums[1] < ns[1]) {
                    b = true;
                }
            }
            if (b) {
                ++c;
            }
        }
        return c;
    }

    public int numberOfWeakCharacters(int[][] properties) {
        int c = 0;
        int ln = properties.length;
        for (int i = 0; i < ln; ++i) {
            boolean b = false;
            int[] nums = properties[i];
            for (int j = 0; j < ln; ++j) {
                int[] ns = properties[j];
                if (nums[0] < ns[0] && nums[1] < ns[1]) {
                    b = true;
                    break;
                }
            }
            if (b) {
                ++c;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1, 5}, {10, 4}, {4, 3}};
        Helper.print(new Test2().numberOfWeakCharacters(ints));
        ;
    }

}
