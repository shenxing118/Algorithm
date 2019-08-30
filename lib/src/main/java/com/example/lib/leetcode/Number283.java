package com.example.lib.leetcode;

public class Number283 {

    public static void main(String[] args) {
        Number283 number206 = new Number283();
    }

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
