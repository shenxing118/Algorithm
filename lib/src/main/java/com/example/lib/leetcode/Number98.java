package com.example.lib.leetcode;

import java.util.Stack;

public class Number98 {

    public static void main(String[] args) {
        Number98 number98 = new Number98();
        System.out.print(number98.isValidBST(number98.new TreeNode(0)));
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        double curVal = -Float.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.val <= curVal) return false;
            curVal = cur.val;
            cur = cur.right;
        }
        return true;
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
