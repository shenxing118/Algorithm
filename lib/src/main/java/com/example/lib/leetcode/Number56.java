package com.example.lib.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Number56 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {0, 2}, {2, 3}, {4, 6}, {4, 5}, {5, 5}, {0, 2}, {3, 3}};
        int[][] result = merge(intervals);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[][] result = new int[intervals.length][intervals[0].length];
        result[0] = intervals[0];
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (result[j][1] >= intervals[i][0]) {
                result[j][1] = Math.max(result[j][1], intervals[i][1]);
            } else {
                j++;
                result[j] = intervals[i];
            }

        }

        return Arrays.copyOf(result, j + 1);
    }
}
