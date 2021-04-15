package com.king.M04;

/**
 * @program: leetcode
 * @description: 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 * @author: King
 * @create: 2021-04-15 19:30
 */
public class Test3 {

    public static void main(String[] args) {
        Test3 t3 = new Test3();
        int[] nums = new int[]{1,2,3,1};
        System.out.println(t3.rob(nums));

    }
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));

//        假设数组nums 的长度为 n。如果不偷窃最后一间房屋，则偷窃房屋的下标范围是 [0, n-2][0,n−2]；
//        如果不偷窃第一间房屋，则偷窃房屋的下标范围是 [1, n-1][1,n−1]。
//        在确定偷窃房屋的下标范围之后，即可用第 198 题的方法解决。
//        对于两段下标范围分别计算可以偷窃到的最高总金额，其中的最大值即为在 n 间房屋中可以偷窃到的最高总金额。
        //1,2,3,1
        //1,2,
        //2,3
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
