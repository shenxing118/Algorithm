package com.example.lib.leetcode;

public class Number34 {

    public static void main(String[] args) {
        int[] prices = new int[]{5, 7, 7, 8, 8, 10};
        int[] range = new Number34().searchRange(prices, 8);
        System.out.println(range[0] + " , " + range[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    res[0] = mid;
                    break;
                } else {
                    j = mid - 1;
                }
            }
        }

        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    res[1] = mid;
                    break;
                } else {
                    i = mid + 1;
                }
            }
        }
        return res;
    }
}
