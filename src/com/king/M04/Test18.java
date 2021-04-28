package com.king.M04;

import com.king.TreeNode;

/**
 * @program: leetcode
 * @description: 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author: King
 * @create: 2021-04-28 19:38
 */
public class Test18 {
    public TreeNode sortedArrayToBST(Integer[] nums) {
        return new TreeNode(nums);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
    public static void main(String[] args) {
        int[] integers = new int[]{-10,-3,0,5,9};
        System.out.println(new Test18().sortedArrayToBST(integers));
    }
}
