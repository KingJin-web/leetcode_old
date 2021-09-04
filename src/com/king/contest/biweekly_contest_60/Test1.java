package com.king.contest.biweekly_contest_60;

import com.king.util.MyPrint;
import com.king.util.StringUtil;

/**
 * @program: leetcode
 * @description: 找到数组的中间位置
 * @author: King
 * @create: 2021-09-04 23:08
 */
public class Test1 {
    public int pivotIndex(int[] nums) {
        int sum=0;
        int left=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum-nums[0]==0){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            left+=nums[i];
            if(left-nums[i]==sum-left){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        MyPrint.print(test1.pivotIndex(StringUtil.stringToIntegerArray("[2,3,-1,8,4]")));
    }
}
