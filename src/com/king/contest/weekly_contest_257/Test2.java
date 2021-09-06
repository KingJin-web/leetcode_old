package com.king.contest.weekly_contest_257;
import java.applet.AudioClip;
import java.util.Arrays;

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
        Test2 test2 = new Test2();
        Helper.print(new Test2().numberOfWeakCharacters(ints));
        Helper.print(test2.numberOfWeakCharacters2(StringUtil.stringToInt2dArray("[[1,5],[10,4],[4,3]]")));
        Helper.print(test2.numberOfWeakCharacters2(StringUtil.stringToInt2dArray("[[5,5],[6,3],[3,6]]")));
        // [[5,5],[6,3],[3,6]]

    }

    //执行用时： 91 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 84.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
    public int numberOfWeakCharacters2(int[][] properties) {
        Arrays.sort(properties,(o1, o2)->o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
        int cnt=0;
        int max=-1;
        int n=properties.length;
        for(int i=0;i<n;i++){
            if(max>properties[i][1]){
                cnt++;
            }
            max=Math.max(max,properties[i][1]);

        }
        return cnt;
    }

}
