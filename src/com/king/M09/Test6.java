package com.king.M09;

import com.king.util.MyPrint;
import com.king.util.StringUtil;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 704. 二分查找
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-09-06 22:18
 */
public class Test6 {
    //给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
    // 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
    public int search(int[] nums, int target) {
        MyPrint.print(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // int mid = (left + right)/2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Test6 test6 = new Test6();

        //输入: nums = [-1,0,3,5,9,12], target = 9
        //输出: 4
        //解释: 9 出现在 nums 中并且下标为 4

        //输入: nums = [-1,0,3,5,9,12], target = 2
        //输出: -1
        //解释: 2 不存在 nums 中因此返回 -1

        MyPrint.print(test6.search(StringUtil.stringToIntegerArray("[-1,0,3,5,9,12]"),9));
        MyPrint.print(test6.search(StringUtil.stringToIntegerArray("[-1,0,3,5,9,12]"),2));
    }

}
