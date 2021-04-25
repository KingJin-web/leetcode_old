package com.king.M04;


import com.king.TreeNode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 897. 递增顺序搜索树
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2021-04-25 19:11
 */
public class Test13 {

    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);


    }



    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }

    public static void main(String[] args) {
        Integer[] integer = new Integer[]{};
        TreeNode t = new TreeNode(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9);
        System.out.println(t.left);
        System.out.println(t.right);
        System.out.println(t);

        TreeNode treeNode = new Test13().increasingBST(t);
        System.out.println(treeNode);
    }
}


class Z {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}