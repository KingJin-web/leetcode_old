package com.king.M04;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

import com.king.TreeNode;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 783. 二叉搜索树节点最小距离
 * @author: King
 * @create: 2021-04-13 23:16
 */
public class Test2 {


    private TreeNode pre = null;   //pre记录前一节点
    private int res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    public int min(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        return 0;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null) {
            res = Math.min(root.val - pre.val, res);   //记录最小
        }
        pre = root;
        dfs(root.right);
    }

    public static void main(String[] args) {
        Integer[] integers = {4, 2, 6, 1, 3, null};
        TreeNode treeNode2 = new TreeNode(1, 2, null, 8, 1, 3, 4, 5, 6, 7);
        TreeNode treeNode = new TreeNode(integers);
        System.out.println(Arrays.toString(integers));
        System.out.println(treeNode);
        System.out.println(treeNode2);


        Test2 test2 = new Test2();
        System.out.println(test2.min(treeNode));
        System.out.println(test2.minDiffInBST(treeNode));

    }
}

