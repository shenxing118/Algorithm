package com.example.lib.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Number146 {


    public static void main(String[] args) {
//        String values = "[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]";
//        String replaceValue = values.replaceAll("[\\[]", "{").replaceAll("[\\]]", "}");
//        System.out.println(replaceValue);

        String[] operator = new String[]{"LRUCache",
                "put", "put", "put", "put", "put",
                "get", "put", "get", "get", "put",
                "get", "put", "put", "put", "get",
                "put", "get", "get", "get", "get",
                "put", "put", "get", "get", "get",
                "put", "put", "get", "put", "get",
                "put", "get", "get", "get", "put",
                "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};

        int[][] valueArray = new int[][]{{10},
                {10, 13}, {3, 17}, {6, 11}, {10, 5}, {9, 10},
                {13}, {2, 19}, {2}, {3}, {5, 25},
                {8}, {9, 22}, {5, 5}, {1, 30}, {11},
                {9, 12}, {7}, {5}, {8}, {9},
                {4, 30}, {9, 3}, {9}, {10}, {10},
                {6, 14}, {3, 1}, {3}, {10, 11}, {8},
                {2, 14}, {1}, {5}, {4}, {11, 4},
                {12, 24}, {5, 18}, {13}, {7, 23}, {8}, {12}, {3, 27}, {2, 12},
                {5}, {2, 9}, {13, 4}, {8, 18}, {1, 7},
                {6}, {9, 29}, {8, 21}, {5}, {6, 30}, {1, 12}, {10}, {4, 15}, {7, 22}, {11, 26}, {8, 17}, {9, 29}, {5}, {3, 4}, {11, 30}, {12}, {4, 29}, {3}, {9}, {6}, {3, 4}, {1}, {10}, {3, 29}, {10, 28}, {1, 20}, {11, 13}, {3}, {3, 12}, {3, 8}, {10, 9}, {3, 26}, {8}, {7}, {5}, {13, 17}, {2, 27}, {11, 15}, {12}, {9, 19}, {2, 15}, {3, 16}, {1}, {12, 17}, {9, 1}, {6, 19}, {4}, {5}, {5}, {8, 1}, {11, 7}, {5, 2}, {9, 28}, {1}, {2, 2}, {7, 4}, {4, 22}, {7, 24}, {9, 26}, {13, 28}, {11, 26}};

        LRUCache cache = new Number146().new LRUCache(valueArray[1][0]);
        LRUCache2 cache2 = new Number146().new LRUCache2(valueArray[1][0]);
//        System.out.println("null");
        for (int i = 1; i < operator.length; i++) {
            if ("put".equals(operator[i])) {
                cache.put(valueArray[i][0], valueArray[i][1]);
                cache2.put(valueArray[i][0], valueArray[i][1]);
//                System.out.println("null");
            } else if ("get".equals(operator[i])) {
                cache.get(valueArray[i][0]);
                cache2.get(valueArray[i][0]);
            }

            int[][] list1 = cache.getList();
            int[][] list2 = cache2.getList();
            if (list1.length != list2.length) {
                System.out.println("length is diff");
            } else {
                for (int j = 0; j < list1.length; j++) {
                    if (list1[j][0] != list2[j][0] || list1[j][1] != list2[j][1]) {
                        System.out.println(i + "content is diff");
                        System.out.println("list1 : ");
                        printArray(list1);
                        System.out.println("list2 : ");
                        printArray(list2);
                        return;
                    }
                }
            }

        }
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public class LRUCache2 {

        private LinkedHashMap<Integer, Integer> map;
        private int capacity;

        public LRUCache2(int capacity) {
            map = new LinkedHashMap<>(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return map.get(key) != null ? map.get(key) : -1;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key) && map.size() == capacity) {
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
        }


        public int[][] getList() {
            int[][] res = new int[map.size()][2];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                res[i][0] = entry.getKey();
                res[i][1] = entry.getValue();
                i++;
            }
            return res;
        }

    }

    class LRUCache {

        class Node {
            Node pre;
            Node next;
            int key;
            int value;

            Node() {
            }

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer, Node> map;
        int capacity;
        int count;
        Node head = new Node();
        Node tail = head;

        String operator = "";

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            operator = "get : " + key;
            if (map.containsKey(key)) {
                Node node = map.get(key);
                removeEntry(node);
                addEntry(node);
                return node.value;
            } else {
                return -1;
            }

        }

        public void put(int key, int value) {
            operator = "put : " + key + " , " + value;
            if (map.containsKey(key)) {
                removeEntry(map.get(key));
            } else if (count == capacity) {
                removeEntry(head.next);
            }

            addEntry(new Node(key, value));
        }

        private void addEntry(Node node) {
            node.pre = tail;
            node.next = null;
            tail.next = node;
            tail = tail.next;
            map.put(node.key, node);
            count++;
        }

        private void removeEntry(Node removedNode) {
            removedNode.pre.next = removedNode.next;
            if (removedNode.next != null) {
                removedNode.next.pre = removedNode.pre;
            } else {
                tail = tail.pre;
            }
            map.remove(removedNode.key);
            count--;
        }

        public int[][] getList() {
            int[][] res = new int[map.size()][2];
            Node cur = head.next;
            int i = 0;
            while (cur != null && i < map.size()) {
                res[i][0] = cur.key;
                res[i][1] = cur.value;
                i++;
                cur = cur.next;
            }
            if (cur != null) {
                System.out.println(operator);
                System.out.println("Map list");
                for (Map.Entry<Integer, Node> entry : map.entrySet()) {
                    System.out.println(entry.getValue().key + " " + entry.getValue().value);
                }

                System.out.println("Linked list");
                Node current = head.next;
                int j = 0;
                while (current != null && j < map.size() * 2) {
                    System.out.println(current.key + " " + current.value);
                    current = current.next;
                    j++;
                }
            }
            return res;
        }


    }
}
