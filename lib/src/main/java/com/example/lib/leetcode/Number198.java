package com.example.lib.leetcode;

public class Number198 {

    public static void main(String[] args) {
        int[] prices = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(prices));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] maxValue = new int[nums.length];
        maxValue[0] = nums[0];
        maxValue[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            maxValue[i] = Math.max(maxValue[i - 1], maxValue[i - 2] + nums[i]);
        }
        return maxValue[nums.length - 1];
    }
}
