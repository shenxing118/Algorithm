package com.example.lib.leetcode;

import java.util.PriorityQueue;

public class Number378 {

    public static void main(String[] args) {
        System.out.println(new Number378().kthSmallest2(new int[][]{
                {1, 2},
                {1,3}}, 1));
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int start = matrix[0][0], end = matrix[matrix.length - 1][matrix[0].length - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = 0, i = 0, j = matrix[0].length - 1;
            int biggestLessMid = matrix[0][0];
            int smallestMoreMid = matrix[matrix.length - 1][matrix[0].length - 1];
            while (i < matrix.length && j >= 0) {
                if (matrix[i][j] <= mid) {
                    biggestLessMid = Math.max(biggestLessMid, matrix[i][j]);
                    count += j + 1;
                    i++;
                } else {
                    smallestMoreMid = Math.min(smallestMoreMid,matrix[i][j]);
                    j--;
                }
            }
            if (count == k) {
                return biggestLessMid;
            } else if (count > k) {
                end = biggestLessMid;
            } else {
                start = smallestMoreMid;
            }
        }
        return start;
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> heap = new PriorityQueue<>();
        for (int i = 0; i < matrix[0].length; i++) {
            heap.offer(new Tuple(0, i, matrix[0][i]));
        }
        Tuple ith = null;
        for (int i = 0; i < k; i++) {
            ith = heap.poll();
            if (ith.i > matrix.length - 2) continue;
            heap.offer(new Tuple(ith.i + 1, ith.j, matrix[ith.i + 1][ith.j]));
        }
        return ith.val;
    }

    public class Tuple implements Comparable<Tuple> {

        int i, j, val;

        Tuple(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }
}
