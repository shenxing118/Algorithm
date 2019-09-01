package com.example.lib.leetcode;

public class Number279 {

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }

    public static int numSquares(int n) {
        int[] minNum = new int[n + 1];
        minNum[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, minNum[i - j * j] + 1);
            }
            minNum[i] = min;
        }
        return minNum[n];
    }
}
