package com.king.M11;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 594. 最长和谐子序列
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-11-20 23:17
 */
public class Test20 {

    //和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
    //
    //现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
    //
    //数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。


    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int begin = 0,res = 0;
        for(int end = 0;end < nums.length;end++){
            while(nums[end] - nums[begin] > 1)
                begin++;
            if(nums[end] - nums[begin] == 1)
                res = Math.max(res,end - begin + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        //输入：nums = [1,3,2,2,5,2,3,7]
        //输出：5
        //解释：最长的和谐子序列是 [3,2,2,2,3]

        Test20 test20 = new Test20();
       int a =  test20.findLHS(LeetcodeUtil.stringToIntegerArray("[1,3,2,2,5,2,3,7]"));
        MyPrint.print(a);
    }
}
