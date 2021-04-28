package com.king;

import java.util.LinkedList;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-04-14 00:47
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int v0, Integer... values) {
        this.val = v0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int index = 0;
        queue.addLast(this);
        while (index < values.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (index < values.length && values[index] != null) {
                    node.left = new TreeNode(values[index]);
                    queue.addLast(node.left);
                }
                index++;
                if (index < values.length && values[index] != null) {
                    node.right = new TreeNode(values[index]);
                    queue.addLast(node.right);
                }
                index++;
            }
        }
    }

    public  TreeNode(Integer[] integers) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int index = 0;
        queue.addLast(this);
        while (index < integers.length) {
            int size = queue.size();
            for (int i = 0; i <= size; i++) {
                TreeNode node = queue.removeFirst();
                if (index < integers.length && integers[index] != null) {
                    node.left = new TreeNode(integers[index]);
                    queue.addLast(node.left);
                }
                index++;
                if (index < integers.length && integers[index] != null) {
                    node.right = new TreeNode(integers[index]);
                    queue.addLast(node.right);
                }
                index++;
            }
        }
        System.out.println(queue);
    }


    @Override
    public String toString() {
        LinkedList<Integer> arr = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(this);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node != null) {
                    arr.addLast(node.val);
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                } else {
                    arr.addLast(null);
                }
            }
        }
        while (arr.peekLast() == null) {
            arr.removeLast();
        }
        return arr.toString();
    }

}
