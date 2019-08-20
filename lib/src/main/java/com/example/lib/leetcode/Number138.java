package com.example.lib.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Number138 {

    public static void main(String[] args) {
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node copyHead = new Node(head.label);
        Node cur = head;
        Node curCopy = copyHead;
        map.put(head, copyHead);
        while (cur.next != null) {
            Node node = new Node(cur.next.label);
            map.put(cur.next, node);
            curCopy.next = node;
            cur = cur.next;
            curCopy = curCopy.next;
        }
        cur = head;
        curCopy = copyHead;
        while (cur.random != null) {
            if (map.containsKey(cur.random)) {
                curCopy.random = map.get(cur.random);
            } else {
                Node node = new Node(cur.random.label);
                curCopy.random = node;
            }
            cur = cur.next;
            curCopy = curCopy.next;
        }
        return copyHead;
    }

    class Node {
        int label;
        Node next, random;

        Node(int x) {
            this.label = x;
        }
    }


}
