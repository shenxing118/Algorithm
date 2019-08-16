package com.example.lib.leetcode;

import java.util.Stack;

public class Number230 {

    public static void main(String[] args) {
    }


    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int count = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            count++;
            if (count == k){
                return node.val;
            }
            cur = node.right;
        }
        return 0;
    }


    public static int number = 0;
    public static int count;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        inOrder(root, k);
        return number;
    }

    public void inOrder(TreeNode node, int k) {
        if (node == null) return;
        inOrder(node.left, k);
        count++;
        if (count == k) {
            number = node.val;
            return;
        }
        inOrder(node.right, k);
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
