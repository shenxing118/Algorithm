package com.example.lib.leetcode;

public class Number328 {

    public static void main(String[] args) {
        Number328 number206 = new Number328();
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode oddCur = head, evenCur = evenHead;
        while (evenCur != null && evenCur.next != null) {
            oddCur.next = evenCur.next;
            oddCur = oddCur.next;
            evenCur.next = oddCur.next;
            evenCur = evenCur.next;
        }
        oddCur.next = evenHead;
        return head;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
