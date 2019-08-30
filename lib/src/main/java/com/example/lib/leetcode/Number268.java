package com.example.lib.leetcode;

public class Number268 {

    public static void main(String[] args) {
        System.out.println(new Number268().missingNumber(new int[]{1}));
    }

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] != nums.length && nums[i] != i) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }
}
