package com.example.lib.leetcode;

public class Number160 {

    public static void main(String[] args) {
        Number160 number206 = new Number160();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        boolean aTob = false, bToA = false;
        while (a != null && b != null) {
            a = a.next;
            b = b.next;
            if (a == null && !aTob) {
                a = headB;
                aTob = true;
            }
            if (b == null && !bToA) {
                b = headA;
                bToA = true;
            }
            if (a == b) {
                return a;
            }
        }
        return null;


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
