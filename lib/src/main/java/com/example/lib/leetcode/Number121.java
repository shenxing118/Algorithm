package com.example.lib.leetcode;

public class Number121 {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit2(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxEndingHere = 0;
        int maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxEndingHere = Math.max(prices[i] - prices[i - 1], maxEndingHere + prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }

    public static int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
