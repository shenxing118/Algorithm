package com.example.lib.leetcode;

public class Number53 {

    public static void main(String[] args) {
        int[] prices = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(prices));
    }

    public static int maxSubArray(int[] nums) {
        int maxEndHere = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndHere = Math.max(nums[i], maxEndHere + nums[i]);
            maxSoFar = Math.max(maxEndHere, maxSoFar);
        }
        return maxSoFar;
    }
}
