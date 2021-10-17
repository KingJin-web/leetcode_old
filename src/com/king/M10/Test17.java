package com.king.M10;

import com.king.TreeNode;
import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: leetcode
 * @description: 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * @author: King
 * @create: 2021-10-17 17:10
 */
public class Test17 {

    //给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。


    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }



    public static void main(String[] args) {
        //root = [3,1,4,null,2], k = 1
        Test17 test17 = new Test17();
       TreeNode treeNode =  LeetcodeUtil.stringToTreeNode("[3,1,4,null,2]");
        LeetcodeUtil.prettyPrintTree(treeNode);

        MyPrint.print(test17.kthSmallest(treeNode,1));
    }

}
