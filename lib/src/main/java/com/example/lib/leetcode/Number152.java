package com.example.lib.leetcode;

public class Number152 {

    public static void main(String[] args) {
        int[] prices = new int[]{-2, 5, -1};
        System.out.println(maxProduct(prices));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxEndHere = nums[0];
        int minEndHere = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax;
            int tempMin;
            tempMax = Math.max(nums[i], maxEndHere * nums[i]);
            tempMax = Math.max(tempMax, minEndHere * nums[i]);

            tempMin = Math.min(nums[i], maxEndHere * nums[i]);
            tempMin = Math.min(tempMin, minEndHere * nums[i]);

            maxEndHere = tempMax;
            minEndHere = tempMin;

            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }
}
