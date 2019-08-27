package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Number94 {

    public static void main(String[] args) {
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
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
