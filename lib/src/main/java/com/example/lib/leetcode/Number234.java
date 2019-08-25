package com.example.lib.leetcode;

public class Number234 {

    public static void main(String[] args) {
        Number234 number206 = new Number234();
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        ListNode left = pre, right = fast == null ? slow : slow.next;
        while (left != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
