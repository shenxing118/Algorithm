package com.example.lib.leetcode;

public class Number287 {

    public static void main(String[] args) {
        System.out.println(new Number287().findDuplicate(new int[]{3,1,3,4,2}));
    }

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                } else {
                    swap(nums, i, nums[i]);
                }
            } else {
                i++;
            }
        }
        return 0;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
