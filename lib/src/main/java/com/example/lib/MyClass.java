package com.example.lib;

import java.util.ArrayList;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>(list1);
        list1.clear();
        System.out.println(list2.size());

    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = inorderTraversal(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)){
                return false;
            }
        }

        return true;
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = inorderTraversal(root);
        return list.get(k - 1);
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val== right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(list, root);
        return list;
    }

    public void inorderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) return;
        inorderTraversal(list, root.left);
        list.add(root.val);
        inorderTraversal(list, root.right);
    }


}
