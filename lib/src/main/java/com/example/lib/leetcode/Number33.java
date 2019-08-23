package com.example.lib.leetcode;

public class Number33 {

    public static void main(String[] args) {
        int[] prices = new int[]{5, 7, 7, 8, 8, 10};
        int range = new Number33().search(prices, 8);
        System.out.println(range);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] > nums[j]) i = mid + 1;
            else j = mid;
        }
        int start, end;
        if (target > nums[nums.length - 1]) {
            start = 0;
            end = i - 1;
        } else {
            start = i;
            end = nums.length - 1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid + 1;
            else if (nums[mid] > target) end = mid - 1;
            else return mid;
        }
        return -1;
    }
}
