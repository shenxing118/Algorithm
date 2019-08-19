package com.example.lib.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Number454 {

    public static void main(String[] args) {
        Number454 number454 = new Number454();
        int[] a = new int[]{0};
        int[] b = new int[]{0};
        int[] c = new int[]{0};
        int[] d = new int[]{0};
        number454.fourSumCount(a, b, c, d);
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> abSum = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                abSum.put(sum, abSum.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                count += abSum.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }
        return count;
    }
}
