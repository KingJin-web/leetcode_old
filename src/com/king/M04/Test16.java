package com.king.M04;

import com.king.TreeNode;

/**
 * @program: leetcode
 * @description: 938. 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * @author: King
 * @create: 2021-04-27 23:25
 */
public class Test16 {

}


class Solution1 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        if(root.val >= L && root.val <= R) {
            //当前节点再两数之间，把自身值加到结果里取，并往左右子节点递归
            return root.val + rangeSumBST(root.left, L ,R) + rangeSumBST(root.right, L , R);
        } else if(root.val < L){
            //当前节点小于L，往右子节点寻找
            return rangeSumBST(root.right, L, R);
        } else {
            //当前节点大于R，往左子节点寻找
            return rangeSumBST(root.left, L, R);
        }
    }
}
