package com.king.M04;

/**
 * @program: leetcode
 * @description: 27. 移除元素
 * @author: King
 * @create: 2021-04-19 22:58
 */
public class Test7 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
    int len ;
    private void run() {

        len = removeElement(nums, 2);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        test7.run();

    }


}
