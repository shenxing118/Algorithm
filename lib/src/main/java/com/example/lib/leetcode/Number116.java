package com.example.lib.leetcode;

import java.util.LinkedList;

public class Number116 {

    public static void main(String[] args) {
    }

    public Node connect2(Node root) {
        Node leftNode = root;
        while (leftNode != null && leftNode.left != null) {
            Node curNode = leftNode;
            while (curNode != null) {
                curNode.left.next = curNode.right;
                curNode.right.next = curNode.next == null ? null : curNode.next.left;
                curNode = curNode.next;
            }
            leftNode = leftNode.left;
        }
        return root;
    }

    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int number = queue.size();
            for (int i = 0; i < number; i++) {
                Node node = queue.pop();
                if (i != number - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


}
