package com.example.lib.leetcode;

public class Number26 {

    public static void main(String[] args) {
        Number26 number206 = new Number26();
    }

    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
