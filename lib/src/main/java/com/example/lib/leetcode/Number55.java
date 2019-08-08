package com.example.lib.leetcode;

public class Number55 {

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 1, 0, 4};
        System.out.println(canJump(prices));
    }

    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
