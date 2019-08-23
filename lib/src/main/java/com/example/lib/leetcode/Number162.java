package com.example.lib.leetcode;


public class Number162 {

    public static void main(String[] args) {
        System.out.println(new Number162().findPeakElement2(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    public int findPeakElement2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] < nums[mid + 1]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            } else {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
        }
        return -1;
    }


}
