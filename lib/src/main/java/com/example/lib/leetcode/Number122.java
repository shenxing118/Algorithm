package com.example.lib.leetcode;

public class Number122 {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 5};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int peak;
        int valley;
        for (int i = 0; i < prices.length - 1; ) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            max += peak - valley;
        }
        return max;
    }
}
