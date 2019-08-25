package com.example.lib.leetcode;

public class Number2 {

    public static void main(String[] args) {
        Number2 number206 = new Number2();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int more = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            ListNode node = new ListNode((val1 + val2 + more) % 10);
            more = (val1 + val2 + more) / 10;
            cur.next = node;
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (more != 0) {
            cur.next = new ListNode(1);
        }
        return head.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
