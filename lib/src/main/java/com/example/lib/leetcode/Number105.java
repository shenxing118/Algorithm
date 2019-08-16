package com.example.lib.leetcode;

public class Number105 {

    public static void main(String[] args) {
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int parentIndex, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[parentIndex]);
        int i = inLeft;
        for (; i <= inRight; i++) {
            if (preorder[parentIndex] == inorder[i]) {
                break;
            }
        }
        treeNode.left = helper(preorder, inorder, parentIndex + 1, inLeft, i - 1);
        treeNode.right = helper(preorder, inorder, parentIndex + (i - inLeft + 1), i + 1, inRight);
        return treeNode;
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
