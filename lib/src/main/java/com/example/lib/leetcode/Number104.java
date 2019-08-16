package com.example.lib.leetcode;

public class Number104 {

    public static void main(String[] args) {
    }

    public int maxDepth(TreeNode root) {
        return order(root);
    }

    public int order(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = order(node.left) + 1;
        int rightHeight = order(node.right) + 1;
        return Math.max(leftHeight, rightHeight);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
