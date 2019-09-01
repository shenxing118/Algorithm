package com.example.lib.leetcode;

public class Number66 {

    public static void main(String[] args) {
        int[] prices = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    }

    public int[] plusOne(int[] digits) {
        int more = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + more;
            if (val >= 10) {
                digits[i] = 0;
                more = 1;
            } else {
                digits[i] = val;
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = digits[i - 1];
        }
        return res;
    }

}
