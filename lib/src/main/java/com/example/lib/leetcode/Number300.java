package com.example.lib.leetcode;

import java.util.Arrays;

public class Number300 {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(prices));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxValue = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }
}
