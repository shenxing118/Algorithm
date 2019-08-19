package com.example.lib.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Number347 {

    public static void main(String[] args) {
        Number347 number347 = new Number347();
        int[] nums = new int[]{1,1,1,2,2,3};
        List<Integer> list = number347.topKFrequent2(nums, 2);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        final Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(count.get(o1), count.get(o2));
            }
        });
        for (int key : count.keySet()) {
            heap.offer(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> topK = new ArrayList<>();
        while (!heap.isEmpty()) {
            topK.add(heap.poll());
        }
        Collections.reverse(topK);
        return topK;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Map.Entry<Integer, Integer>[] heap = new Map.Entry[k];
        int n = 0;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (n < k) {
                heap[n] = entry;
                n++;
                if (n == k) {
                    buildHeap(heap, k);
                }
            } else {
                if (heap[0].getValue() < entry.getValue()) {
                    heap[0] = entry;
                    heapify(heap, k, 0);
                }
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            list.add(0, heap[0].getKey());
            swap(heap, 0, i);
            heapify(heap, i, 0);
        }
        return list;
    }

    public void buildHeap(Map.Entry<Integer, Integer>[] heap, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(heap, n, i);
        }
    }

    public void heapify(Map.Entry<Integer, Integer>[] heap, int n, int i) {
        while (true) {
            int minPos = i;
            if (2 * i + 1 < n && heap[i].getValue() > heap[2 * i + 1].getValue()) {
                minPos = 2 * i + 1;
            }
            if (2 * i + 2 < n && heap[minPos].getValue() > heap[2 * i + 2].getValue()) {
                minPos = 2 * i + 2;
            }
            if (minPos == i) {
                break;
            }
            swap(heap, minPos, i);
            i = minPos;
        }
    }

    public void swap(Map.Entry[] heap, int i, int j) {
        Map.Entry temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


}