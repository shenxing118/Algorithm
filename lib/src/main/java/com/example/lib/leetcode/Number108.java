package com.example.lib.leetcode;

public class Number108 {

    public static void main(String[] args) {
        Number108 number108 = new Number108();
        int[] nums = new int[]{-10, -7, -3, 0, 5, 7, 9};
        TreeNode treeNode = number108.sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return addNode(nums, 0, nums.length - 1);
    }

    public TreeNode addNode(int[] nums, int p, int r) {
        if (p <= r) {
            int q = (r + p) / 2;
            TreeNode treeNode = new TreeNode(nums[q]);
            treeNode.left = addNode(nums, p, q - 1);
            treeNode.right = addNode(nums, q + 1, r);
            return treeNode;
        } else {
            return null;
        }
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
