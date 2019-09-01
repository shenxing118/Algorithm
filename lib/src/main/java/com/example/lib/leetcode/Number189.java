package com.example.lib.leetcode;

public class Number189 {

    public static void main(String[] args) {
        int[] prices = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] lastK = new int[k];
        for (int i = 0; i < k; i++) {
            lastK[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[k + i] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = lastK[i];
        }
    }

}
