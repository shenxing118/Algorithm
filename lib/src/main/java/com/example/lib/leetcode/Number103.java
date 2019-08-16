package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Number103 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        int line = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.pop();
                nodes.add(node);
                if (line % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
            }
            lists.add(list);
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            line++;
        }
        return lists;
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
