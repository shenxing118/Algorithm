package com.example.lib.leetcode;

public class Number70 {

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 1, 0, 4};
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        int[] f = new int[n + 2];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
