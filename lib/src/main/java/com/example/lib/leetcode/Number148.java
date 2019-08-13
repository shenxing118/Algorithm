package com.example.lib.leetcode;


import java.util.Collections;

public class Number148 {

    public static void main(String[] args) {
        Number148 number148 = new Number148();
        ListNode head = number148.new ListNode(0);
        ListNode p = head;
        p.next = number148.new ListNode(-1);
        p = p.next;
        p.next = number148.new ListNode(5);
        p = p.next;
        p.next = number148.new ListNode(3);
        p = p.next;
        p.next = number148.new ListNode(4);
        p = p.next;
        p.next = number148.new ListNode(0);
        ListNode result = number148.sortList(head.next);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midPre = null;
        ListNode mid = head;
        ListNode last = head;

        while (last != null && last.next != null) {
            midPre = mid;
            mid = mid.next;
            last = last.next.next;
        }

        midPre.next = null;

        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(mid);

        ListNode result = merge(leftNode, rightNode);

        return result;

    }

    public ListNode merge(ListNode leftNode, ListNode rightNode) {
        ListNode l = new ListNode(0), p = l;

        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                p.next = leftNode;
                p = p.next;
                leftNode = leftNode.next;
            } else {
                p.next = rightNode;
                p = p.next;
                rightNode = rightNode.next;
            }
        }

        if (leftNode == null) {
            p.next = rightNode;
        } else if (rightNode == null) {
            p.next = leftNode;
        }

        return l.next;

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
