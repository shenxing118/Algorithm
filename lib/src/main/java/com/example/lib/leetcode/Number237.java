package com.example.lib.leetcode;

public class Number237 {

    public static void main(String[] args) {
        Number237 number206 = new Number237();
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
