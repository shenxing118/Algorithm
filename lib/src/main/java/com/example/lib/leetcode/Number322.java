package com.example.lib.leetcode;

public class Number322 {

    public static void main(String[] args) {
        int[] prices = new int[]{2, 5, 10, 1};
        System.out.println(coinChange(prices, 27));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length ; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = (min == Integer.MAX_VALUE ? -1 : min);
        }
        return dp[amount];
    }
}
