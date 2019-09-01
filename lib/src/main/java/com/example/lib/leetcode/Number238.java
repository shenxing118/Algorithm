package com.example.lib.leetcode;

public class Number238 {

    public static void main(String[] args) {
        int[] prices = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= R;
            R *= nums[i];
        }
        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        int allProduct = 1;
        int zeroCount = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                allProduct *= nums[i];
            } else {
                zeroCount++;
            }
        }
        if (zeroCount > 1) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 0) {
                res[i] = allProduct / nums[i];
            } else if (nums[i] == 0) {
                res[i] = allProduct;
            }
        }
        return res;
    }

}
